package se.kth.iv1350.processsale.startup;

import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.integration.DbHandler;
import se.kth.iv1350.processsale.view.View;

/**
 * A class which contains the main method. it initiates the startup of the point of sale
 */
public class Main {

    /**
     *  Starts the system "process sale" and executes a sample transaction.
     * @param args takes no argument
     */
    public static void main(String [] args){
        DbHandler dbHandler = new DbHandler();
        Controller controller = new Controller(dbHandler);
        View view = new View(controller);
        view.sampleExecution();
    }
}

