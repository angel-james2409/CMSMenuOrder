package com.hexaware.MLPXX.factory;

import com.hexaware.MLPXX.persistence.MenuDAO;
import com.hexaware.MLPXX.persistence.DbConnection;
import java.util.List;

import com.hexaware.MLPXX.model.Menu;
/**
 * MenuFactory class used to fetch menu data from database.
 * @author hexware
 */
public class MenuFactory {
  /**
   *  Protected constructor.
   */
  protected MenuFactory() { }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static MenuDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(MenuDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Menu[] showMenu() {
    List<Menu> menu = dao().show();
    return menu.toArray(new Menu[menu.size()]);
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   * @param id to initialize id.
   */
  public static Menu findMenu(final int id) {
    Menu menu = dao().find(id);
    return menu;
  }
}
