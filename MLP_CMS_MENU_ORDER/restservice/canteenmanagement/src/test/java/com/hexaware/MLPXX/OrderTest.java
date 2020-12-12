package com.hexaware.MLPXX;

import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;

//import java.util.ArrayList;
import java.util.Calendar;

//import com.hexaware.MLPXX.persistence.OrderDAO;
//import com.hexaware.MLPXX.factory.OrderFactory;
import com.hexaware.MLPXX.model.Order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

// import mockit.Expectations;
// import mockit.MockUp;
// import mockit.Mocked;
// import mockit.Mock;
import mockit.integration.junit4.JMockit;

/**
 * Test class for Order.
 */
@RunWith(JMockit.class)
public class OrderTest {
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
  public final void testOrder() {
    Calendar calendar = Calendar.getInstance();
    //Order m = new Order();
    Order o100 = new Order(1, 2, 3, "PENDING", 200, 2, 100);
    o100.setId(1);
    assertEquals(1, o100.getId());
    o100.setMenuId(2);
    assertEquals(2, o100.getMenuId());
    o100.setOrderDate(calendar);
    assertEquals(calendar, o100.getOrderDate());
    o100.setOrderTime(calendar);
    assertEquals(calendar, o100.getOrderTime());
    o100.setAmount(100);
    assertEquals(100, (int) o100.getAmount());
    o100.setTotalAmount(200);
    assertEquals(200, (int) o100.getTotalAmount());
    o100.setQuantity(2);
    assertEquals(2, o100.getQuantity());
    o100.setEstimatedDeliveryTime(calendar);
    assertEquals(calendar, o100.getEstimatedDeliveryTime());
    o100.setOrderStatus("PENDING");
    assertEquals("PENDING", o100.getOrderStatus().toString());

    assertEquals(o100.hashCode(), new Order(1, 2, 3, "PENDING", 200, 2, 100).hashCode());
    //assertEquals(o100, new Order(1, 2, 3, "PENDING", 200, calendar, 2, calendar, 100, calendar));
  }
  /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   */
//   @Test
//   public final void testListAllEmpty(@Mocked final OrderDAO dao) {
//     new Expectations() {
//       {
//         dao.show(); result = new ArrayList<Order>();
//       }
//     };
//     new MockUp<OrderFactory>() {
//       @Mock
//       OrderDAO dao() {
//         return dao;
//       }
//     };
//     Order[] me = OrderFactory.showOrder();
//     assertEquals(0, me.length);
//   }
//   /**
//    * Tests that a list with some employees is handled correctly.
//    * @param dao mocking the dao class
//    */
//   @Test
//   public final void testListAllSome(@Mocked final OrderDAO dao) {
//     final Order m100 = new Order(2,"Dosa", "Lunch", 50);
//     final Order m101 = new Order(4, "Coke", "Beverage", 40);
//     final ArrayList<Order> mn = new ArrayList<Order>();
//     new Expectations() {
//       {
//         mn.add(m100);
//         mn.add(m101);
//         dao.show(); result = mn;
//       }
//     };
//     new MockUp<OrderFactory>() {
//       @Mock
//       OrderDAO dao() {
//         return dao;
//       }
//     };
//     Order[] mn1 = OrderFactory.showOrder();
//     assertEquals(2, mn1.length);
//     assertEquals(2, mn1[0].getFoodId());
//     assertEquals(4, mn1[1].getFoodId());
//     assertEquals("Dosa", mn1[0].getFoodName());
//     assertEquals("Coke", mn1[1].getFoodName());
//     assertEquals("Lunch", mn1[0].getFoodType());
//     assertEquals("Beverage", mn1[1].getFoodType());
//     // assertEquals(50, mn1[0].getPrice());
//     // assertEquals(40, mn1[1].getPrice());

//     // assertEquals(new Order(100).getFoodId(),
//     //     mn1[0].getFoodId());
//     // assertEquals(new Order(101).getFoodId(),
//     //     mn1[1].getFoodId());
//   }
}
