package be.intecbrussel.order_management_system.model.order_table;

import java.time.LocalDate;

public class Order {
private boolean isSend;
private  String orderDeliveryCity;
private LocalDate orderDate;
private String orderNumber;

    public Order(boolean isSend, String orderDeliveryCity, LocalDate orderDate) {
        this.isSend = isSend;
        this.orderDeliveryCity = orderDeliveryCity;
        this.orderDate = orderDate;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public String getOrderDeliveryCity() {
        return orderDeliveryCity;
    }

    public void setOrderDeliveryCity(String orderDeliveryCity) {
        this.orderDeliveryCity = orderDeliveryCity;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
