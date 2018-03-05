package com.company;

import com.company.Controller.Controller;
import com.company.Model.Model;
import com.company.View.View;

public class Main {

    public static void main(String[] args) {
	    Model model = new Model();
        Controller controller = new Controller(model);

        View view = new View(model, controller);
        model.addObserver(view);
        controller.setView(view);
        view.show();
    }
}
