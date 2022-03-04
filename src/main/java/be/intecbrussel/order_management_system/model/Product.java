package be.intecbrussel.order_management_system.model;

import java.math.BigDecimal;

public class Product {
    private String productName;
    private int amount;
    private BigDecimal pricePerUnit;
    private int orderId;

    public Product() {
    }

    public Product(String productName, int amount, BigDecimal pricePerUnit, int orderId) {
        this.productName = productName;
        this.amount = amount;
        this.pricePerUnit = pricePerUnit;
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", amount=" + amount +
                ", pricePerUnit=" + pricePerUnit +
                ", orderId=" + orderId +
                '}';
    }
}
