package com.company.Controller;

import com.company.Model.OrderDetail;
import com.company.View.OrderDetailView;

import java.util.Scanner;

public class OrderDetailController {

    OrderDetail model;
    OrderDetailView view;

    public OrderDetailController(OrderDetail orderDetailModel) {
        this.model = orderDetailModel;
    }

    public void setView(OrderDetailView orderView) {
        this.view = orderView;
    }

    public boolean execute(String command) {
        if ("change name".equals(command)) {
            changeName();
            return true;
        }
        if ("change price".equals(command)) {
            changePrice();
            return true;
        }
        if ("remove".equals(command)) {
            model.remove();
            return true;
        }
        return false;
    }

    private void changePrice() {
        try (Scanner scanner = new Scanner(System.in)) {
            String price;
            System.out.println("Podaj cene: ");
            price = scanner.nextLine();
            model.setPrice(Float.parseFloat(price));
        }
    }

    private void changeName() {
        try (Scanner scanner = new Scanner(System.in)) {
            String name;
            System.out.println("Podaj nazwe produktu: ");
            name = scanner.nextLine();
            model.setProductName(name);
        }
    }

}
