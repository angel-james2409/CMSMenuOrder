package com.hexaware.MLPXX.factory;

import com.hexaware.MLPXX.persistence.OrderDAO;
import com.hexaware.MLPXX.persistence.DbConnection;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
//import java.util.List;
import java.util.List;

import com.hexaware.MLPXX.model.Menu;
import com.hexaware.MLPXX.model.Order;
/**
 * OrderFactory class used to fetch order data from database.
 * @author hexware
 */
public class OrderFactory {
  /**
   *  Protected constructor.
   */
  protected OrderFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static OrderDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(OrderDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   * @throws ParseException
   */
  public static Order[] showOrder() {
    List<Order> order = dao().show();
    return order.toArray(new Order[order.size()]);
  }
  /**.
   * Place order for customer
   * @param mid for customer id.
   * @param quantity for quantity
   */
  public static void insertOrder(final int mid, final  int quantity) {
    try {
      Order order = new Order();
      order.setMenuId(mid);
      order.setQuantity(quantity);
      Menu menu = MenuFactory.findMenu(order.getMenuId());
      order.setAmount(menu.getPrice());
      order.setOrderDate(Calendar.getInstance());
      order.setOrderTime(Calendar.getInstance());
      order.setOrderStatus("PENDING");
      int id = (int) (Math.random() * 10);
      order.setCustomerId(id);
      computeTotal(order.getAmount(), order.getQuantity(), order);
      computeEstimatedTime(order);
      Time t1 = dateToTimeConvert(order.getEstimatedDeliveryTime());
      Time t2 = dateToTimeConvert(order.getOrderTime());
      dao().insert(order, order.getOrderDate().getTime(), t2, t1, order.getOrderStatus().toString());
      System.out.println("----ORDER PLACED SUCCESSFULLY----");
      System.out.println("Order Amount: Rs." + order.getTotalAmount());
    } catch (Throwable e) {
      e.printStackTrace();
      System.out.println("---TECHNICAL ERROR---");
    }
  }
  public static int acceptOrder( final Order order, final Date date, final Time orderTime,final Time estimatedTime, final String status) {
    final int check = dao().Order( order,date,orderTime, estimatedTime,status);
    return check;
  }
  /**.
   * Date to Time
   * @param date for date
   */
  private static Time dateToTimeConvert(final Calendar date) {
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
    String str = sdf.format(date.getTime());
    Date d1;
    Time time = null;
    try {
      d1 = sdf.parse(str);
      //System.out.println(d1);
      time = new Time(d1.getTime());
      //System.out.println(time);
      return time;
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return time;
  }
  /**.
   * total
   * @param amount for amount
   * @param quantity for quantity
   * @param order for order
   */
  public static void computeTotal(final double amount, final int quantity, final Order order) {
    double totalAmount = amount * quantity;
    order.setTotalAmount(totalAmount);
  }
  /**.
   * estimated time
   * @param order for order
   */
  public static void computeEstimatedTime(final Order order) {
    int estimatedTime = 20;
    // for(OrderItem orderItem: orderItems){
    //     if(orderItem.getFoodItem().getPreparationTime() > estimatedTime){
    //         estimatedTime= orderItem.getFoodItem().getPreparationTime();
    //     }
    //}
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE, estimatedTime);
    order.setEstimatedDeliveryTime(calendar);
  }
}
