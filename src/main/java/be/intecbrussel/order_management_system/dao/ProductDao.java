package be.intecbrussel.order_management_system.dao;

import be.intecbrussel.order_management_system.model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private Connection connection;

    public ProductDao(Connection connection) {
        this.connection = connection;
    }
    public void saveOrderedProducts(Product product)throws SQLException {
        PreparedStatement statement =  connection.prepareStatement
                ("INSERT INTO order_products (order_id,product_name,amount,price_per_unit) VALUES (?,?,?,?)");
        statement.setInt(1,product.getOrderId());
        statement.setString(2,product.getProductName());
        statement.setInt(3,product.getAmount());
        statement.setBigDecimal(4,product.getPricePerUnit());

        statement.execute();
    }
    public List<Product> getAllProductsFromDB() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM order_products");

        List<Product> result = new ArrayList<>();
        while (rs.next()) { // parsing
            Product product = new Product();
           product.setOrderId(rs.getInt("order_id"));
            product.setProductName(rs.getString("product_name"));
            product.setAmount(rs.getInt("amount"));
            product.setPricePerUnit(rs.getBigDecimal("price_per_unit"));
            result.add(product);
        }

        return result;
    }

}
