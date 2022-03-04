package be.intecbrussel.order_management_system.view;

import be.intecbrussel.order_management_system.model.Order;
import be.intecbrussel.order_management_system.model.Product;
import be.intecbrussel.order_management_system.service.OrderService;
import be.intecbrussel.order_management_system.service.ProductService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();
        Order order = new Order(true, "Brussels", LocalDate.of(2022, 03, 12));
        Optional<Integer> order1 = orderService.saveOrder(order);
        if (order1.isPresent()) {
            int id = order1.get();
            Product product1 = new Product("Shirt", 2, BigDecimal.valueOf(20000), id);
            productService.saveProducts(product1);
            Product product2 = new Product("Bag", 2, BigDecimal.valueOf(50000), id);
            productService.saveProducts(product2);
            Product product3 = new Product("Shoes", 2, BigDecimal.valueOf(30000), id);
            productService.saveProducts(product3);
            Product product4 = new Product("Scarf", 2, BigDecimal.valueOf(10000), id);
            productService.saveProducts(product4);

        }

        Order order2 = new Order(true, "Zaventem", LocalDate.of(2022, 05, 30));
        Optional<Integer> order21 = orderService.saveOrder(order2);
        if (order21.isPresent()) {
            int id = order21.get();

            Product product5 = new Product("Shirt", 2, BigDecimal.valueOf(20000), id);
            productService.saveProducts(product5);
            Product product6 = new Product("Bag", 2, BigDecimal.valueOf(50000), id);
            productService.saveProducts(product6);
            Product product7 = new Product("Shoes", 2, BigDecimal.valueOf(30000), id);
            productService.saveProducts(product7);
            Product product8 = new Product("Scarf", 2, BigDecimal.valueOf(10000), id);
            productService.saveProducts(product8);
        }

        Order order3 = new Order(false, "Zaventem", LocalDate.of(2022, 05, 30));
        Optional<Integer> order31 = orderService.saveOrder(order3);
        if (order31.isPresent()) {
            int id = order31.get();
            Product product9 = new Product("Shirt", 2, BigDecimal.valueOf(20000), id);
        productService.saveProducts(product9);
        Product product10 = new Product("Bag", 2, BigDecimal.valueOf(50000), id);
        productService.saveProducts(product10);
        Product product11 = new Product("Shoes", 2, BigDecimal.valueOf(30000), id);
        productService.saveProducts(product11);
        Product product12 = new Product("Scarf", 2, BigDecimal.valueOf(10000), id);
        productService.saveProducts(product12);
        }

        Order order4 = new Order( false, "Zaventem", LocalDate.of(2022, 05, 30));
        Optional<Integer> order41 = orderService.saveOrder(order4);
        if (order41.isPresent()) {
            int id = order31.get();

            Product product13 = new Product("Shirt", 2, BigDecimal.valueOf(20000), id);
        productService.saveProducts(product13);
        Product product14 = new Product("Bag", 2, BigDecimal.valueOf(50000), id);
        productService.saveProducts(product14);
        Product product15 = new Product("Shoes", 2, BigDecimal.valueOf(30000), id);
        productService.saveProducts(product15);
        Product product16 = new Product("Scarf", 2, BigDecimal.valueOf(10000), id);
        productService.saveProducts(product16);
        }
        productService.getAllProducts().forEach(System.out::println);
        orderService.getAllOrders().forEach(System.out::println);   

    }
}
