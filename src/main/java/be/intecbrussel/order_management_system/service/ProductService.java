package be.intecbrussel.order_management_system.service;

import be.intecbrussel.order_management_system.dao.ProductDao;
import be.intecbrussel.order_management_system.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ProductService {
    Connection connection = DriverManager.getConnection("jdbc:mysql://moktok.intecbrussel.org:33061/sahar",
            "sahar", "sahar2021");


    private ProductDao productDao;

    public ProductService() throws SQLException {
        this.productDao = new ProductDao(connection);
    }

    public void saveProducts(Product product)throws SQLException{
        productDao.saveOrderedProducts(product);
    }
    public List<Product> getAllProducts()throws SQLException{
      return  productDao.getAllProductsFromDB();
    }

}
