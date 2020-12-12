package com.hexaware.MLPXX;

import com.hexaware.MLPXX.persistence.MenuDAO;
import com.hexaware.MLPXX.factory.MenuFactory;
import com.hexaware.MLPXX.model.Menu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;
import java.util.ArrayList;

/**
 * Test class for Menu.
 */
@RunWith(JMockit.class)
public class MenuTest {
    /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testMenu() {
    //Menu m = new Menu();
    Menu m100 = new Menu(2, "Dosa", "Lunch", 50);
    Menu m101 = new Menu(4, "Coke", "Beverage", 40);
    assertNotEquals(m100, null);
    assertNotEquals(m101, null);
    m100.setFoodId(2);
    assertEquals(2, m100.getFoodId());
    m100.setFoodName("Dosa");
    assertEquals("Dosa", m100.getFoodName());
    m100.setFoodType("Lunch");
    assertEquals("Lunch", m100.getFoodType());
    m100.setPrice(50);
    assertEquals(50, (int) m100.getPrice());
    assertNotEquals(m101, new Menu(2, "Dosa", "Lunch", 50));
    assertEquals(m100.hashCode(),
        new Menu(2, "Dosa", "Lunch", 50).hashCode());
    assertEquals(m100, new Menu(2, "Dosa", "Lunch", 50));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final MenuDAO dao) {
    new Expectations() {
      {
        dao.show(); result = new ArrayList<Menu>();
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] me = MenuFactory.showMenu();
    assertEquals(0, me.length);
  }
  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {
    final Menu m100 = new Menu(2, "Dosa", "Lunch", 50);
    final Menu m101 = new Menu(4, "Coke", "Beverage", 40);
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m100);
        mn.add(m101);
        dao.show(); result = mn;
      }
    };
    new MockUp<MenuFactory>() {
      @Mock
      MenuDAO dao() {
        return dao;
      }
    };
    Menu[] mn1 = MenuFactory.showMenu();
    assertEquals(2, mn1.length);
    assertEquals(2, mn1[0].getFoodId());
    assertEquals(4, mn1[1].getFoodId());
    assertEquals("Dosa", mn1[0].getFoodName());
    assertEquals("Coke", mn1[1].getFoodName());
    assertEquals("Lunch", mn1[0].getFoodType());
    assertEquals("Beverage", mn1[1].getFoodType());
    // assertEquals(50, mn1[0].getPrice());
    // assertEquals(40, mn1[1].getPrice());

    // assertEquals(new Menu(100).getFoodId(),
    //     mn1[0].getFoodId());
    // assertEquals(new Menu(101).getFoodId(),
    //     mn1[1].getFoodId());
  }
}


