package com.hexaware.MLPXX.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.hexaware.MLPXX.model.Menu;
import com.hexaware.MLPXX.factory.MenuFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/menu")
public class MenuRest {
  /**
   * Returns Menu details.
   * @return the menu details
   */
  @GET
  @Path("/menuList")
  @Produces(MediaType.APPLICATION_JSON)
  public final Menu[] listMenu() {
    final Menu[] menu = MenuFactory.showMenu();
    return menu;
  }
  /**
   * Returns Menu details.
   * @return the menu details
   * @param id  for id
   */
  @GET
  @Path("/findnew/{menuid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Menu findMenu(@PathParam("menuid") final int id) {
    Menu menu = MenuFactory.findMenu(id);
    return menu;
  }
}
