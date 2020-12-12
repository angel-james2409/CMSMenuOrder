package com.hexaware.MLPXX;
import com.hexaware.MLPXX.factory.MenuFactory;
import com.hexaware.MLPXX.model.Menu;
import com.hexaware.MLPXX.persistence.MenuDAO;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
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
public class MenuFactoryTest {
    /**
   * tests for constructor.
   */
  /**
   * Tests that a list with MenuHandled is handled correctly.
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
    Menu[] m = MenuFactory.showMenu();
    assertEquals(0, m.length);
  }

/**
 * tests that empty employee list is handled correctly.
 * @param dao mocking the dao class
 */
  @Test
  public final void testListAllSome(@Mocked final MenuDAO dao) {

    final Menu m2 = new Menu(1, "Dosa", 40);

    final Menu m3 = new Menu(2, "Idly", 40);
    final ArrayList<Menu> mn = new ArrayList<Menu>();
    new Expectations() {
      {
        mn.add(m2);
        mn.add(m3);
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
    assertEquals(1, mn1[0].getFoodId());
    assertEquals(2, mn1[1].getFoodId());
    assertEquals("Dosa", mn1[0].getFoodName());
    assertEquals("Idly", mn1[1].getFoodName());
    assertEquals(40, mn1[0].getPrice());
    assertEquals(40, mn1[1].getPrice());

  }
}
