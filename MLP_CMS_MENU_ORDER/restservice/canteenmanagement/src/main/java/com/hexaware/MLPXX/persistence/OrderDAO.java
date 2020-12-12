package com.hexaware.MLPXX.persistence;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
//import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
//import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.sql.Time;
import java.util.Date;
import java.util.List;

//import java.util.List;
import com.hexaware.MLPXX.model.Order;
/**.
 * OrderDAO class used to fetch data from data base.
 * @author hexware
 */
public interface OrderDAO {
    /**.
     * @return the all the Menu record.
     */
  @SqlQuery("Select * from Orders")
    @Mapper(OrderMapper.class)
    List<Order> show();
    /**.
     * update order table
     * @param order for order
     * @param date for date
     * @param orderTime for time
     * @param estimatedTime for time
     * @param status for status
     */
  @SqlUpdate("insert into Orders (ORDERS_DATE, ORDERS_STATUS, "
      + "CUSTOMER_ID,ORDERS_TIME, ORDERS_ESTIMATED_TIME, "
      + "ORDER_QUANTITY, ORDERS_AMOUNT, MENU_ID )"
      + "values(:odate, :ostatus, :o.customerId, :otime, "
      + ":oesttime, :o.quantity, :o.totalAmount, :o.menuId )")
    //@Mapper(MenuMapper.class)
    void insert(@BindBean("o") Order order,
      @Bind("odate") Date date, @Bind("otime") Time orderTime,
      @Bind("oesttime") Time estimatedTime, @Bind("ostatus") String status);

  @SqlUpdate("Update Orders set ORDERS_STATUS =(:orderStatus) where ORDERS_ID=(:o.orderId) and CUSTOMER_ID=(:o.customerId) ")
      @Mapper(OrderMapper.class)
    int Order(@BindBean("o") Order order,
      @Bind("odate") Date date, @Bind("otime") Time orderTime,
      @Bind("oesttime") Time estimatedTime, @Bind("ostatus") String status);
}
