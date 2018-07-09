package com.example.onkar.cafepart2;

public class OrderItem {
    String id;
    String tableNo;
    String order;
    String status;

    public OrderItem() {
    }

    public OrderItem(String id, String tableNo, String order, String status) {
        this.id = id;
        this.tableNo = tableNo;
        this.order = order;
        this.status = status;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
