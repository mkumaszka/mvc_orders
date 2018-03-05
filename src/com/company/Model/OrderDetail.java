package com.company.Model;

import java.util.Observable;

public class OrderDetail extends Observable{

    private int id;
    private int orderHeaderID;
    private String productName;
    private float price;

    OrderDetail(int id, int orderHeaderID, String productName, float price){
        this.id = id;
        this.orderHeaderID = orderHeaderID;
        this.productName = productName;
        this.price = price;
    }

    public OrderDetail(int id, int orderHeaderID) {
        this.id = id;
        this.orderHeaderID = orderHeaderID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderHeaderID() {
        return orderHeaderID;
    }

    public void setOrderHeaderID(int orderHeaderID) {
        this.orderHeaderID = orderHeaderID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
        setChanged();
        notifyObservers();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Id pozycji zamowienia: " + id + " Nazwa towaru: " + productName;
    }

    public void remove() {
        //Tu usunac tą pozycje z bazy
        setChanged();
        notifyObservers(id);
    }
}
