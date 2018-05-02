package se.kth.iv1350.processsale.controller;

import se.kth.iv1350.processsale.integration.DbHandler;
import se.kth.iv1350.processsale.model.Transaction;
import se.kth.iv1350.processsale.integration.ItemRegister;
import se.kth.iv1350.processsale.integration.ItemDTO;
import se.kth.iv1350.processsale.model.Receipt;

public class Controller {
    private Transaction currentTransaction;
    private ItemRegister currentItemRegistry;
    private ItemDTO currentItem;
    private Receipt currentReceipt;
    private DbHandler dbHandler;
    //private Receipt currentReceipt;
    //public string returnString;

    /**
     * Constructor for an instance of an Object of the Class Controller.
     */
    public Controller() {
        this.currentTransaction = null;
        this.currentItemRegistry = new ItemRegister();
        this.currentItem = null;
        this.currentReceipt = null;
        this.dbHandler = new DbHandler();
        //this.returnString = null;
    }

    /**
     * Method initiates a new transaction but doesnt add any items to it
     */
    public void startTransaction(){
        this.currentTransaction = new Transaction();
    }

    /**
     * adds an item to the transaction currently being handled
     * @param barcode is the identifier of the object the cashier have tried to add to
     *                a transaction.
     */
    public void enterItem(int barcode){
        this.currentItem = currentItemRegistry.searchItem(barcode);
        currentTransaction.addItem(this.currentItem);
    }

    /**
     * method that returns the totalcost of a transaction when the cashier indicates all desired
     * items have been scanned
     * @return total cost of the transaction, also shows tax amount.
     */
    public String finalizeTransaction(){
        return this.currentTransaction.getTotalCost().finalizeTransaction();
        //return this.returnString = "[Total Cost: " +currentTransaction.totalCost.totalCost +", Included tax amount: " +currentTransaction.totalCost.getTaxAmount() +"]";
    }

    /**
     * this method calculates how much change a customer shall recieve after paying for a transaction with a certain
     * amount, it also creates a receipt and sends information to dbHandler which further sends the information to externalSystems.
     * @param paymentAmount
     * @return
     */
    public double pay(double paymentAmount){
        this.currentReceipt = new Receipt(this.currentTransaction);
        this.currentReceipt.generateReceipt();
        this.sendTransactionInformation(this.currentTransaction);
        this.currentTransaction.getTotalCost().calculateChange(paymentAmount);
        return (int)(this.currentTransaction.getTotalCost().changeAmount);
    }

    public void sendTransactionInformation(Transaction currentTransaction){
        this.dbHandler.SendAccountingInformation(currentTransaction);
        this.dbHandler.SendInventoryInformation(currentTransaction);
    }

    public ItemRegister getCurrentItemRegistry() {
        return currentItemRegistry;
    }

    public ItemDTO getCurrentItem() {
        return currentItem;
    }

    public Transaction getCurrentTransaction(){
        return this.currentTransaction;
    }

    public Receipt getCurrentReceipt() {
        return currentReceipt;
    }
}
