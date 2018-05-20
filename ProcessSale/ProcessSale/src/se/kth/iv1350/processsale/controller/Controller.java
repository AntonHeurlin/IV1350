package se.kth.iv1350.processsale.controller;

import se.kth.iv1350.processsale.integration.*;
import se.kth.iv1350.processsale.model.*;


/**
 * represents a controller which handles method- calls between the user-interface and lower layers of the system.
 */
public class Controller {
    private Transaction currentTransaction;
    private ItemRegister currentItemRegistry;
    private DbHandler dbHandler;
    private TotalRevenue totalRevenue;

    /**
     * Constructor for an instance of an Object of the Class Controller.
     */
    public Controller(DbHandler dbHandler) {
        this.currentTransaction = null;
        this.currentItemRegistry = new ItemRegister();
        this.dbHandler = dbHandler;
        this.totalRevenue = new TotalRevenue();
    }

    /**
     * Method initiates a new transaction but doesn't add any items to it
     */
    public void startTransaction(){
        this.currentTransaction = new Transaction();
    }

    /**
     * adds an item to the transaction currently being handled
     * @param barcode is the identifier of the object the cashier have tried to add to
     *                a transaction which is later checked against itemDTOs in the itemRegister.
     * @throws ItemException if an item identifier does not have a match in the item register.
     */
    public TransactionDTO enterItem(int barcode) throws ItemException {
        ItemDTO currentItem = currentItemRegistry.searchItem(barcode);
        return currentTransaction.addItem(currentItem);
    }

    /**
     * this method calculates how much change a customer shall receive after paying for a transaction with a certain
     * amount, it also creates a receipt and sends information to dbHandler which further sends the information to externalSystems.
     * @param paymentAmount a specific amount that a customer has payed the cashier which he has entered into the user-interface.
     * @return the receipt for a finalized transaction which contains both a string with information about the transaction in question
     * and the changeAmount a customer shall receive in return after paying a specific amount.
     */
    public Receipt pay(double paymentAmount){
        this.totalRevenue.updateTotalRevenueAmount(this.currentTransaction.getTotalCost());
        Receipt currentReceipt = new Receipt(this.currentTransaction, paymentAmount);
        this.sendTransactionInformation(this.currentTransaction);
        return currentReceipt;
    }

    /**
     * Sends information to the DbHandler about the current transaction which it turns into specific DTO packages which shall be delivered
     * to externalSystems.
     * @param currentTransaction this is the transaction which has been handled and is now ready to be finalized and logged into external database
     *                           systems.
     */
    private void sendTransactionInformation(Transaction currentTransaction){
        this.dbHandler.SendAccountingInformation(currentTransaction);
        this.dbHandler.SendInventoryInformation(currentTransaction);
    }

    public void addTotalRevenueObserver(TotalRevenueObserver observer){
        this.totalRevenue.addTotalRevenueObserver(observer);
    }

    /**
     *
     * @return the current transaction being handled by a cashier.
     */
    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    /**
     *
     * @return the current item register containing information about which Items are in store.
     */
    public ItemRegister getCurrentItemRegistry() {
        return currentItemRegistry;
    }

    /**
     *
     * @return DbHandler which handles sending information to external systems.
     */
    public DbHandler getDbHandler() {
        return dbHandler;
    }
}
