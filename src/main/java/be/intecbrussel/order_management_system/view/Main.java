package be.intecbrussel.order_management_system.view;

import be.intecbrussel.order_management_system.model.order_table.Order;
import be.intecbrussel.order_management_system.service.OrderService;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException {
        OrderService orderService = new OrderService();
        Order order = new Order(true,"Brussels", LocalDate.of(2022,03,12));
        orderService.saveOrder(order);

    }
}
