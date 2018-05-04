package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.integration.ItemDTO;
import se.kth.iv1350.processsale.model.Receipt;
import se.kth.iv1350.processsale.model.Transaction;
import se.kth.iv1350.processsale.model.TransactionDTO;

import java.util.ArrayList;

public class View {
    private Controller controller;

    /**
     * Constructor method for the view
     * @param contr this is a specific object-instance of the class controller which handles call from the user interface
     *              down to lower layers of the program.
     */
    public View(Controller contr){
        this.controller = contr;
    }

    /**
     * This method executes a the chain of actions and method-calls which are gonna be called when a process of sale occurs.
     */
    public void sampleExecution(){
        System.out.println("Starts a new Transaction:" +"\n");
        this.controller.startTransaction();
        System.out.println("Cashier Enters Items" +"\n");
        TransactionDTO transactionInformation = this.controller.enterItem(1111);
        printTransactionInfo(transactionInformation);
        transactionInformation = this.controller.enterItem(1212);
        printTransactionInfo(transactionInformation);
        transactionInformation = this.controller.enterItem(1313);
        printTransactionInfo(transactionInformation);
        transactionInformation = this.controller.enterItem(1414);
        printTransactionInfo(transactionInformation);
        System.out.println("Cashier signals he is done scanning" +"\n");
        finalizeTransaction(transactionInformation);
        Receipt receipt = this.controller.pay(150);
        System.out.println("Customer shall get: " +receipt.getChangeAmount() +":- in change" +"\n");
        System.out.println(receipt.getReceipt());

    }

    /**
     * this is a method that prints out desired information regarding a transaction
     * @param transactionInformation a certain transactionDTO containing information regarding a specific item that has been
     *                               added to a certain transaction and how this effects the transaction running total.
     */
    private void printTransactionInfo(TransactionDTO transactionInformation){
        System.out.println("An item: " +"(ItemName: " +transactionInformation.getRegisteredItem().getItemName() +", Cost: " +transactionInformation.getRegisteredItem().getItemPrice()
                +":-, itemBarcode: " +transactionInformation.getRegisteredItem().getItemBarcode() +")" +" has been added to the Transaction"
                +"\n" +"Total cost of Transaction: " +transactionInformation.getRunningTotal() +":-\n");
    }

    /**
     * A method that prints out a message showing the user that the scanning-phase of a transaction is complete and its now time
     * to finalize the transaction with a payment.
     * @param transactionInformation a certain transactionDTO containing information regarding a specific item that has been
     *      *                         added to a certain transaction and how this effects the transaction running total.
     *                               This transactionDTO contains the information regarding the total cost of a transaction.
     */
    private void finalizeTransaction(TransactionDTO transactionInformation){
        System.out.println("Transaction ready to be completed. Amount to pay: " +transactionInformation.getRunningTotal()
                +":- [Included tax amount: " +(int)(transactionInformation.getTaxAmount()) +":-]" +"\n");
    }

}
