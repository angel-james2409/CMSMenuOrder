package com.hexaware.MLPXX.model;

//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
//import java.util.List;
//import java.util.LinkedList;
//import java.util.Date;


/**
 * Order class used to display order information.
 * @author hexware
 */
public class Order {
  private int id;
  private int menuId;
  private int customerId;
  private Calendar orderDate;
  private Calendar orderTime;
  private double amount;
  private double totalAmount;
  private int quantity;
  private Calendar estimatedDeliveryTime;
  private OrderStatus orderStatus;
/**
   * Enum.
   */
  public enum OrderStatus { ACCEPTED, REJECTED, PENDING, CANCELLED };
/**
   * Default Constructor.
   */
  public Order() {

  }
  /**
 * @param argOrderId to initialize food id.
 * used to get details through constructor.
 * @param argCustomerId to initialize customer id.
 * @param argMenuId to initialize food id.
 * @param argOrderStatus to initialize food Status.
 * @param argOrderTotalamount to initialize ord er amount.
 * @param argOrderQuantity to initialize food quantity.
 * @param argOrderAmount to initialize order date.
 */

  public Order(final int argOrderId,
      final int argCustomerId,
      final int argMenuId,
      final String argOrderStatus,
      final double argOrderTotalamount,
      final int argOrderQuantity,
      final double argOrderAmount) {
    this.id = argOrderId;
    this.customerId = argCustomerId;
    this.menuId = argMenuId;
    this.orderStatus = OrderStatus.valueOf(argOrderStatus);
    this.totalAmount = argOrderTotalamount;
    //this.orderDate = argOrderDate;
    this.quantity = argOrderQuantity;
    //this.orderTime = argOrderTime;
    this.amount = argOrderAmount;
    //this.estimatedDeliveryTime = argOrderEstDelTime;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Order order = (Order) obj;
    if (Objects.equals(id, order.id)
        && Objects.equals(customerId, order.customerId)
        && Objects.equals(menuId, order.menuId)
        && Objects.equals(orderStatus, order.orderStatus)
        && Objects.equals(totalAmount, order.totalAmount)
        && Objects.equals(orderDate, order.orderDate)
        && Objects.equals(quantity, order.quantity)
        && Objects.equals(orderTime, order.orderTime)
        && Objects.equals(amount, order.amount)
        && Objects.equals(estimatedDeliveryTime, order.estimatedDeliveryTime)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    int n = this.id;
    n = n * 2;
    return n;
  }
  @Override
    public final String toString() {
    return String.format("%5s %5s %5s %5s %10s %15s %7s %7s %7s %7s", id, customerId,
     menuId,  orderStatus, totalAmount, orderDate, quantity, orderTime,
     amount, estimatedDeliveryTime);
  }
/**
     * @return this order ID.
     */
  public final int getId() {
    return id;
  }
  /**
     * @param argOrderId gets the order id.
     */
  public final void setId(final int argOrderId) {
    this.id = argOrderId;
  }
  /**
     * @return this customer ID.
     */
  public final int getCustomerId() {
    return customerId;
  }
   /**
     * @param argCustomerId gets the customer id.
     */
  public final void setCustomerId(final int argCustomerId) {
    this.customerId = argCustomerId;
  }
   /**
     * @return this food ID.
     */
  public final int getMenuId() {
    return menuId;
  }
  /**
     * @param argMenuId gets the food id.
     */
  public final void setMenuId(final int argMenuId) {
    this.menuId = argMenuId;
  }
  /**
     * @return this order status.
     */
  public final OrderStatus getOrderStatus() {
    return orderStatus;
  }
  /**
     * @param argOrderStatus gets the order id.
     */
  public final void setOrderStatus(final String argOrderStatus) {
    this.orderStatus = OrderStatus.valueOf(argOrderStatus);
  }
  /**
     * @return this ordertotalamount.
     */
  public final double getTotalAmount() {
    return totalAmount;
  }
  /**
     * @param argOrderTotalamount gets the order id.
     */
  public final void setTotalAmount(final double argOrderTotalamount) {
    this.totalAmount = argOrderTotalamount;
  }
  /**
     * @return this order date.
     */
  public final Calendar getOrderDate() {
    return orderDate;
  }
  /**
     * @param argOrderDate gets the order date.
     */
  public final void setOrderDate(final Calendar argOrderDate) {
    this.orderDate = argOrderDate;
  }
  /**
     * @return this order quantity.
     */
  public final int getQuantity() {
    return quantity;
  }
  /**
     * @param argOrderQuantity gets the order quantity.
     */
  public final void setQuantity(final int argOrderQuantity) {
    this.quantity = argOrderQuantity;
  }
  /**
     * @return this order ordertime.
     */
  public final Calendar getOrderTime() {
    return orderTime;
  }
    /**
       * @param argOrderTime gets the order ordertime.
       */
  public final void setOrderTime(final Calendar argOrderTime) {
    this.orderTime = argOrderTime;
  }
  /**
     * @return this order quantity.
     */
  public final double getAmount() {
    return amount;
  }
    /**
       * @param argOrderAmount gets the order quantity.
       */
  public final void setAmount(final double argOrderAmount) {
    this.amount = argOrderAmount;
  }
  /**
     * @return this order quantity.
     */
  public final Calendar getEstimatedDeliveryTime() {
    return estimatedDeliveryTime;
  }
    /**
       * @param argOrderEstDelTime gets the order quantity.
       */
  public final void setEstimatedDeliveryTime(final Calendar argOrderEstDelTime) {
    this.estimatedDeliveryTime = argOrderEstDelTime;
  }
}
