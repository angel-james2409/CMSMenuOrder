package com.hexaware.MLPXX.util;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
//import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import com.hexaware.MLPXX.model.Order;
import com.hexaware.MLPXX.factory.OrderFactory;
import com.hexaware.MLPXX.model.Order;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/order")
public class OrderRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */

  @GET
  @Path("/orderList")
  @Produces(MediaType.APPLICATION_JSON)
  public final Order[] listOrder() {
    final Order[] orders = OrderFactory.showOrder();
    return orders;
  }
  /**
   * Returns Menu details.
   * @return the string
   * @param id for id
   * @param qty for quantity
   */
  @POST
  @Path("/insertnew/{menuid}/{quantity}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public static String insertOrder(@PathParam("menuid") final int id, @PathParam("quantity") final int qty) {
    OrderFactory.insertOrder(id, qty);
    return "----ORDER PLACED SUCCESSFULLY----";
  }
}
