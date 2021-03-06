package be.intecbrussel.order_management_system.dao;

import be.intecbrussel.order_management_system.model.Order;
import be.intecbrussel.order_management_system.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        statement.setString(3, order.getOrderDeliveryCity());
        statement.setDate(4, Date.valueOf(order.getOrderDate().toString()));

        statement.execute();
    }

    public boolean isExist(String orderNumber) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT order_number FROM order_table WHERE order_number = ?");
        statement.setString(1, orderNumber);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        return true;
        }
        return false;
    }

    public Optional<String> getLastOrderNumber() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT order_number FROM order_table ORDER BY id DESC LIMIT 1");
        if (resultSet.next()) {
            return Optional.of(resultSet.getString("order_number"));
        }
        return Optional.empty();
    }

    public Optional<Integer> getOrderId(String orderNumber) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT id FROM order_table WHERE order_number = ?");
        statement.setString(1, orderNumber);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
        return Optional.of(resultSet.getInt("id"));
        }
        return Optional.empty();
    }

    public List<Order> getAllOrdersFromDB() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM order_table");

        List<Order> result = new ArrayList<>();
        while (rs.next()) { // parsing
            Order order = new Order();
            order.setOrderNumber(rs.getString("order_number"));
            order.setOrderDeliveryCity(rs.getString("order_delivery_city"));
            order.setSend(rs.getBoolean("is_send"));
            result.add(order);
        }

        return result;
    }

    public List<Object> getFullOrderFromDB() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM order_table RIGHT JOIN order_products op on order_table.id = op.order_id");
        List<Object> result = new ArrayList<>();
        while (rs.next()) { // parsing
            Order order = new Order();
            order.setOrderNumber(rs.getString("order_number"));
            order.setOrderDeliveryCity(rs.getString("order_delivery_city"));
            order.setSend(rs.getBoolean("is_send"));
            Product product = new Product();
            product.setOrderId(rs.getInt("order_id"));
            product.setProductName(rs.getString("product_name"));
            product.setAmount(rs.getInt("amount"));
            product.setPricePerUnit(rs.getBigDecimal("price_per_unit"));

            result.add(order);
            result.add(product);


        }
      return result;
    }
    public List<Order> getNotSentOrdersFromDB()throws SQLException{

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM order_table WHERE is_send = ?");
        statement.setBoolean(1, false);
        ResultSet resultSet = statement.executeQuery();
        List<Order> result = new ArrayList<>();
        while (resultSet.next()) {
            Order order = new Order();
            order.setOrderNumber(resultSet.getString("order_number"));
            order.setOrderDeliveryCity(resultSet.getString("order_delivery_city"));
            order.setSend(resultSet.getBoolean("is_send"));
            result.add(order);
        }

        return result;


    }
    public void deleteLastOrder()throws SQLException{
        PreparedStatement statement = connection.prepareStatement("DELETE FROM order_table WHERE order_number = ?");
        String orderNumber = getLastOrderNumber().get();
        statement.setString(1,orderNumber);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet);

    }

}


