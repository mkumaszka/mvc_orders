package com.company.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class OrderHeader extends Observable{

    private int id;
    private LocalDate orderDate;
    private List<OrderDetail> orderDetailList;

    OrderHeader(int id, LocalDate orderDate, List<OrderDetail> orderDetailList){
        this.id = id;
        this.orderDate = orderDate;
        this.orderDetailList = orderDetailList;
    }

    OrderHeader(int id, LocalDate orderDate){
        this.id = id;
        this.orderDetailList = new ArrayList<>();
    }

    public OrderHeader(int id) {
        this.id = id;
        this.orderDetailList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        setChanged();
        notifyObservers();
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public void removeOrder() {
        //Usunac z bazy + wszystkie orderdetails ktore do niego nalezą
        setChanged();
        notifyObservers(id);
    }

    @Override
    public String toString() {
        return "ID Zamowienia: " + getId();
    }

    public void addOrderDetail() {
        OrderDetail orderHeader = new OrderDetail(getNextId(),this.getId());
        orderDetailList.add(orderHeader);
        setChanged();
        notifyObservers();
    }

    private int getNextId() {
        return orderDetailList.size();
    }

    public void removeOrderDetail(int arg) {
        orderDetailList.remove(arg);
    }
}
