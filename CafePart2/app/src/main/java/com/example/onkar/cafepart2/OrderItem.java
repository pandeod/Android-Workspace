package com.example.onkar.cafepart2;

public class OrderItem {
    String tableNo;
    String order;
    int status;

    public OrderItem()
    {

    }

    public OrderItem(String tableNo, String order, int status) {
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
