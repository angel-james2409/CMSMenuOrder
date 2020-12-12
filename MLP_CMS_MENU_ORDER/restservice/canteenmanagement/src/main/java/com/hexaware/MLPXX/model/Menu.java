package com.hexaware.MLPXX.model;
import java.util.Objects;

/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Menu {
/**
 * foodId to store foodId.
 */
  private int foodId;
  private String foodName;
  private String foodType;
  private double price;
  /**
   * Default Constructor.
   */
  public Menu() {

  }
/**
 * @param argFoodId to initialize food id.
 * used to get details through constructor.
 * @param argFoodName to initialize food name.
 * used to get details through constructor.
 * @param argFoodType to initialize food price.
 * used to get details through constructor.
 * @param argPrice to initialize food price.
 * used to get details through constructor.
 */
  public Menu(final int argFoodId,
      final String argFoodName, final String argFoodType, final double argPrice) {
    this.foodId = argFoodId;
    this.foodName = argFoodName;
    this.foodType = argFoodType;
    this.price = argPrice;

  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Menu menu = (Menu) obj;
    if (Objects.equals(foodId, menu.foodId)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(foodId);
  }
  /**
   * @return this food ID.
   */
  public final int getFoodId() {
    return foodId;
  }
  /**
   * @param argFoodId gets the food id.
   */
  public final void setFoodId(final int argFoodId) {
    this.foodId = argFoodId;
  }
/**
   * @return this menu category.
   */
  public final String getFoodName() {
    return foodName;
  }
/**
   * @param argFoodName gets the menu category1.
   */
  public final void setFoodName(final String argFoodName) {
    this.foodName = argFoodName;
  }
/**
   * @return this menu category.
   */
  public final String getFoodType() {
    return foodType;
  }
/**
   * @param argFoodType gets the menu category1.
   */
  public final void setFoodType(final String argFoodType) {
    this.foodName = argFoodType;
  }
  /**
   * @return this menu item.
   */
  public final double getPrice() {
    return price;
  }
/**
 * @param argFoodPrice gets the menu item.
 */
  public final void setPrice(final double argFoodPrice) {
    this.price = argFoodPrice;
  }
  @Override
    public final String toString() {
    return String.format("%5s %10s %15s %15s", foodId, foodName, foodType, price);
  }
}
