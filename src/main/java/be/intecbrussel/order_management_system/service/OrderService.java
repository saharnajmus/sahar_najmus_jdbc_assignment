package be.intecbrussel.order_management_system.service;

import be.intecbrussel.order_management_system.dao.OrderDao;
import be.intecbrussel.order_management_system.model.order_table.Order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class OrderService {
    Connection connection = DriverManager.getConnection("jdbc:mysql://moktok.intecbrussel.org:33061/sahar",
            "sahar", "sahar2021");


    private OrderDao orderDao;

    public OrderService() throws SQLException {
        this.orderDao = new OrderDao(connection);
    }

    public void saveOrder(Order order) throws SQLException {
        //ORD-202203-005
        String nextOrderNumber = getNextOrderNumber();
        order.setOrderNumber(nextOrderNumber);
        // 3. save new order with order number
        orderDao.saveOrders(order);
    }

    private String getNextOrderNumber() throws SQLException {

        Optional<String> lastOrderNumber = orderDao.getLastOrderNumber();
        int lastId = 001;
        if (lastOrderNumber.isPresent()) {

            String orderNumber = lastOrderNumber.get();

            String subPart = orderNumber.substring(orderNumber.lastIndexOf('-') + 1);
            lastId = Integer.parseInt(subPart);
            lastId++;

        }
        int year = LocalDate.now().getYear();
        int month = LocalDate.now().getMonthValue();
        String newOrderNumber = "ORD-" + year + month + "-" + lastId;
        while (orderDao.isExist(newOrderNumber)) {
            lastId++;
            newOrderNumber = "ORD-" + year + month + "-" + lastId;
        }

        return newOrderNumber;


    }

}
