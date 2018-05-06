package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.controller.Controller;
import se.kth.iv1350.processsale.model.Receipt;
import se.kth.iv1350.processsale.model.TransactionDTO;

/**
 * This class acts as a placeholder for the entire view.
 */
public class View {
    private Controller controller;

    /**
     * Constructor method for the view, creates an instance of view
     * @param contr this is a specific object-instance of the class controller which handles method-calls from the user interface
     *              down to lower layers of the program.
     */
    public View(Controller contr){
        this.controller = contr;
    }

    /**
     * This method executes a the chain of actions and method-calls which simulates a process of sale.
     */
    public void sampleExecution(){
        System.out.println("----Starts a new Transaction----" +"\n");
        this.controller.startTransaction();
        System.out.println("----Cashier Enters Items----" +"\n");
        TransactionDTO transactionInformation = this.controller.enterItem(1111);
        printTransactionInfo(transactionInformation);
        transactionInformation = this.controller.enterItem(1212);
        printTransactionInfo(transactionInformation);
        transactionInformation = this.controller.enterItem(1313);
        printTransactionInfo(transactionInformation);
        transactionInformation = this.controller.enterItem(1414);
        printTransactionInfo(transactionInformation);
        System.out.println("----Cashier signals he is done scanning----" +"\n");
        finalizeTransaction(transactionInformation);
        System.out.println("----The Customer pays, Cashier enters payment amount into system.----" +"\n");
        Receipt receipt = this.controller.pay(150);
        System.out.println("Customer shall get: " +receipt.getChangeAmount() +":- in change" +"\n");
        System.out.println("----Cashier gives the customer a receipt----" +"\n");
        System.out.println(receipt.getReceipt());

    }


    private void printTransactionInfo(TransactionDTO transactionInformation){
        System.out.println("An item: " +"(ItemName: " +transactionInformation.getRegisteredItem().getItemName() +", Cost: " +transactionInformation.getRegisteredItem().getItemPrice()
                +":-, itemBarcode: " +transactionInformation.getRegisteredItem().getItemBarcode() +")" +" has been added to the Transaction"
                +"\n" +"Total cost of Transaction: " +transactionInformation.getRunningTotal() +":-\n");
    }


    private void finalizeTransaction(TransactionDTO transactionInformation){
        System.out.println("Transaction ready to be completed. Amount to pay: " +transactionInformation.getRunningTotal()
                +":- [Included tax amount: " +(int)(transactionInformation.getTaxAmount()) +":-]" +"\n");
    }

}
