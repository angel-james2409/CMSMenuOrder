package com.hexaware.MLPXX.util;
//import java.util.Calendar;
import java.util.Scanner;
import com.hexaware.MLPXX.factory.MenuFactory;
import com.hexaware.MLPXX.factory.OrderFactory;
import com.hexaware.MLPXX.model.Menu;
import com.hexaware.MLPXX.model.Order;
//import com.hexaware.MLPXX.model.Order;
/**
 * CliMain used as Client interface for java coading.
 * @author hexware
 */
class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
 * mainMenu method  used to display the option we had in the application.
 */
  private void mainMenu() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("1. Show Menu");
    System.out.println("2. Show Orders");
    System.out.println("3. AcceptReject");
    System.out.println("4. Exit");
    mainMenuDetails();
  }
/**
 * mainMenuDetails method  process the option selected from main menu.
 */
  private void mainMenuDetails() {
    try {
      System.out.println("Enter your choice:");
      int menuOption = option.nextInt();
      switch (menuOption) {
        case 1:
          showFullMenu();
          break;
        case 2:
          showFullOrder();
          break;
        case 4: 
          OrderResponse();
          break; 
        case 3:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2 or 3 or 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Enter a Valid Value");
    }
    option.nextLine();
    mainMenu();
  }
/**
 * showFullMenu method  display the menu item stored in database.
 */
  private void showFullMenu() {
    Menu[] menu = MenuFactory.showMenu();
    System.out.println("------------------------------------------------------------------------------------");
    String format = "|%1$-10s|%2$-30s|%3$-25s|%4$-15s|%n";
    System.out.format(format, "Menu Id", "Menu Name", "Menu Type", "Price");
    System.out.println("------------------------------------------------------------------------------------");
    //System.out.println("Menu_Id");
    for (Menu m : menu) {
      System.out.format(format, m.getFoodId(), m.getFoodName(), m.getFoodType(), m.getPrice());
    }
    System.out.println("------------------------------------------------------------------------------------");
    System.out.println("1.Place Order");
    System.out.println("\nEnter your option: ");
    int opt = option.nextInt();
    if (opt == 1) {
      placeOrder();
    }
  }

  private void showFullOrder() {
    Order[] order = OrderFactory.showOrder();
    System.out.println("------------------------------------------------------------------------------------------------------");
    String format = "|%1$-10s|%2$-30s|%3$-25s|%4$-20s|%5$-10s|%n";
    System.out.format(format, "Order Id", "STATUS", "Customer Id", "Quanity", "Total");
    System.out.println("------------------------------------------------------------------------------------------------------");
    //System.out.println("Menu_Id");
    for (Order o : order) {
      System.out.format(format, o.getId(), o.getOrderStatus(), o.getCustomerId(), o.getQuantity(), o.getTotalAmount());
    }
    System.out.println("------------------------------------------------------------------------------------------------------");
    // System.out.println("1.Place Order");
    // System.out.println("\nEnter your option: ");
    // int opt = option.nextInt();
    // if (opt == 1) {
    //   placeOrder();
    // }
  }

  /**.
 * placeOrder method
 */

  private void placeOrder() {
    //Order order= new Order();
    System.out.println("Enter Menu_Id: ");
    int mid = option.nextInt();
    //order.setMenuId(option.nextInt());
    System.out.println("Enter Quantity: ");
    int quantity = option.nextInt();
   //order.setQuantity(option.nextInt());

    //Menu menu= MenuFactory.findMenu(order.getMenuId());
    //System.out.println(order.getMenuId());
    //System.out.println(order.getAmount());
    //order.setAmount(menu.getPrice());
    //double total= order.computeTotal();
    //System.out.println(order.getTotalAmount());

    //order.setOrderDate(Calendar.getInstance());
    //order.setOrderTime(Calendar.getInstance());
    //order.setOrderStatus("PENDING");
    //order.setEstimatedDeliveryTime(order.computeEstimatedTime());
  //  // System.out.println(order.getEstimatedDeliveryTime().getTime());
  //   int id= (int) (Math.random() * 10);
  //   order.setCustomerId(id);

    OrderFactory.insertOrder(mid, quantity);

    //   System.out.println("----ORDER PLACED SUCCESSFULLY----");

    // System.out.println("Order Amount: Rs."+ order.getTotalAmount());

  }
  private void OrderResponse() {
    showOrder();
    int ordId;
    int cusId;
    int venId;
    System.out.println("enter the Order Id");
    ordId = option.nextInt();
    System.out.println("enter the customer Id");
    cusId = option.nextInt();
    System.out.println("enter the vendor Id");
    venId = option.nextInt();

    String y = "Accepted";
    String n = "Rejected";
    System.out.println("accept or reject order");
    String response = option.next().toUpperCase();
    if (response.equals("Y")) {
      System.out.println(" accepted");
      OrderFactory.acceptOrder(ordId, cusId, venId, y);
    }
    if (response.equals("N")) {
      System.out.println(" rejected");
      OrderFactory.acceptOrder(ordId, cusId, venId, n);

    }
  }
/**
 * main method  is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
