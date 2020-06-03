package com.nikita;

import com.nikita.controller.Controller;

public class Main {
    public static void main(String[] args) {
        Controller controller = Controller.getController();
        controller.action();
    }
}
