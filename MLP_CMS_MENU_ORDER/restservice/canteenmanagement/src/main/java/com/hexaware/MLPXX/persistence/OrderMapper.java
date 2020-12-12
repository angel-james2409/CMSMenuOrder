package com.hexaware.MLPXX.persistence;


import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.Calendar;

import com.hexaware.MLPXX.model.Order;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * MenuMapper class used to fetch menu data from database.
 * @author hexware
 */
public class OrderMapper implements ResultSetMapper<Order> {
  /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Order map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
        /**
         * @return Orders
         */
    //System.out.println(rs.getInt("customer_id"));
    return new Order(rs.getInt("orders_id"),
         rs.getInt("customer_id"), rs.getInt("menu_id"),
         rs.getString("orders_status"),
         rs.getDouble("orders_amount"),
         rs.getInt("order_quantity"), 0);
  }
}
