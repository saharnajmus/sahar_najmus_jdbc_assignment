package be.intecbrussel.order_management_system.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {
    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }
    public void saveOrderedProducts(int orderId, String productName, int amount, BigDecimal pricePerUnit)throws SQLException {
        PreparedStatement statement =  connection.prepareStatement
                ("INSERT INTO order_products (order_id,product_name,amount,price_per_unit) VALUES (?,?,?,?)");
        statement.setInt(1,orderId);
        statement.setString(2,productName);
        statement.setInt(4,amount);
        statement.setBigDecimal(5,pricePerUnit);

    }
}
