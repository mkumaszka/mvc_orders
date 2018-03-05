package com.company.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Model extends Observable implements Observer  {

    List<OrderHeader> orderHeaderList;

    public Model(){
        orderHeaderList = getOrderHeadersFromDatabase();
    }

    private List<OrderHeader> getOrderHeadersFromDatabase() {
        return new ArrayList<>();
    }

    public void changeOrderDate(int index, LocalDate date){
        orderHeaderList.get(index).setOrderDate(date);
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }

    public void addNewOrder() {
        OrderHeader orderHeader = new OrderHeader(getNextId());
        orderHeaderList.add(orderHeader);
        setChanged();
        notifyObservers();
    }

    private int getNextId() {
        return orderHeaderList.size();
    }

    public void removeOrder(int index) {
        orderHeaderList.remove(index);
    }

    public List<OrderHeader> getOrderList() {
//        orderHeaderList = getOrderHeadersFromDatabase();   -> za kazdym razem pobieramy od nowa z bazy
        return orderHeaderList;
    }
}
