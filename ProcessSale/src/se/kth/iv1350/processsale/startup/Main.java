package se.kth.iv1350.processsale.startup;

import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.view.View;

public class Main {

    public static void main(String [] args){
        Controller controller = new Controller();
        View view = new View(controller);
        view.sampleExecution();
    }
}
