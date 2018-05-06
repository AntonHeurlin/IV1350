package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.integration.ItemDTO;

/**
 * represent a datapackage of necesarry information regarding a specific transaction.
 */
public class TransactionDTO {
    private ItemDTO registeredItem;
    private double runningTotal;
    private double taxAmount;
    private double changeAmount;

    /**
     * Constructor for the TransactionDTO class
     * @param foundItem an instance of an itemDTO which has been found in the itemRegister and matches an physical item
     *                  a customer wants to buy.
     * @param totalCost an instance of an object Cost which have calculated and stored information regarding the cost and payment
     *                  of a specific transaction.
     */
    public TransactionDTO(ItemDTO foundItem, Cost totalCost){
        this.registeredItem = foundItem;
        this.runningTotal = totalCost.getTotalCost();
        this.taxAmount = totalCost.getTaxAmount();
        this.changeAmount = totalCost.getChangeAmount();
    }

    /**
     *
     * @return tax amount of the total cost of a transaction
     */
    public double getTaxAmount() {
        return taxAmount;
    }

    /**
     *
     * @return the change amount a customer shall receive after paying for a transaction.
     */
    public double getChangeAmount() {
        return changeAmount;
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     *
     * @return the Item which has been added a specific transaction.
     */
    public ItemDTO getRegisteredItem() {
        return registeredItem;
    }
}
