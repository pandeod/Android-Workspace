package com.lightning.exp1_098;

public class MenuItem {
    String _name;
    String _price;
    public MenuItem(){   }
    public MenuItem(String name, String _price){
        this._name = name;
        this._price = _price;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public String getPrice(){
        return this._price;
    }

    public void setPrice(String _price){
        this._price = _price;
    }
}