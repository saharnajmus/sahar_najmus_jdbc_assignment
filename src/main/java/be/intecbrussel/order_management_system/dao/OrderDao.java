package be.intecbrussel.order_management_system.dao;

import be.intecbrussel.order_management_system.model.order_table.Order;

import java.sql.*;
import java.time.Instant;
import java.util.Optional;

public class OrderDao {
    private Connection connection;

    public OrderDao(Connection connection) {
        this.connection = connection;
    }


    public void saveOrders(Order order) throws SQLException {
        PreparedStatement statement = connection.prepareStatement
                ("INSERT INTO order_table (order_number,is_send,order_delivery_city,order_date) VALUES (?,?,?,?)");
        statement.setString(1, order.getOrderNumber());
        statement.setBoolean(2, order.isSend());
        statement.setString(3,order.getOrderDeliveryCity());
        statement.setDate(4,Date.valueOf(order.getOrderDate().toString()));

        statement.execute();
    }
    public boolean isExist(String orderNumber)throws  SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT order_number FROM order_table WHERE order_number = orderNumber");

        Optional<String> optionalString = Optional.of(resultSet.getString("order_number"));
        return optionalString.isPresent();
    }
public Optional<String> getLastOrderNumber()throws  SQLException{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT order_number FROM order_table ORDER BY id DESC LIMIT 1");
        if (resultSet.next()){
            return Optional.of(resultSet.getString("order_number"));
        }
        return Optional.empty();
}

}


