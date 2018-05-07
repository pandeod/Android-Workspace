package com.example.onkarpande.recycleviewsample;

public class ItemList {
    String uName;
    String id;

    public ItemList(String id,String uName) {
        this.uName = uName;
        this.id=id;
    }

    public String getId() {
        return id;
    }

    public String getuName() {
        return uName;
    }
}
