package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.model.Transaction;

public class View {
    private Controller controller;

    public View(Controller contr){
        this.controller = contr;
    }

    public void sampleExecution(){
        System.out.println("Starts a new Transaction:" +"\n");
        this.controller.startTransaction();
        System.out.println("Cashier Enters an Item" +"\n");
        this.controller.enterItem(1111);
        this.transactionPrintout(this.controller.getCurrentTransaction());
        System.out.println("Cashier Enters a second Item" +"\n");
        this.controller.enterItem(1212);
        this.transactionPrintout(this.controller.getCurrentTransaction());
        System.out.println("Cashier Enters a third Item" +"\n");
        this.controller.enterItem(1313);
        this.transactionPrintout(this.controller.getCurrentTransaction());
        System.out.println("Cashier Enters a fourth Item" +"\n");
        this.controller.enterItem(1212);
        this.transactionPrintout(this.controller.getCurrentTransaction());
        System.out.println("Cashier signals scanning-phase is done." +"\n");
        this.finalizeTransaction(this.controller);
       // this.controller.finalizeTransaction();
        //System.out.println(this.controller.finalizeTransaction() +"\n");
        System.out.println("Cashier enters Payment into system" +"\n");
        this.controller.pay(150);
        System.out.println("The customer shall receieve: " +this.controller.getCurrentTransaction().getTotalCost().getChangeAmount() +":- in change" +"\n");
        System.out.println("Printout of Receipt" +"\n");
        System.out.println(this.controller.getCurrentReceipt().getReceipt());
        //this.controller.getCurrentReceipt().printReceipt();


    }

    public void finalizeTransaction(Controller controller){
        System.out.println("Transaction ready to be completed. Amount to pay: " +this.controller.getCurrentTransaction().getTotalCost().getTotalCost() +":- \n");
    }

    public void transactionPrintout(Transaction transaction){
        System.out.println("Current Transaction:");
        int i;
        for(i = 0; i < transaction.getRegisteredItems().length; i++){
            System.out.println((i+1) +". " +transaction.getRegisteredItems()[i].itemDescription());
        }
        System.out.println(this.controller.finalizeTransaction());
        System.out.println();
    }
}
