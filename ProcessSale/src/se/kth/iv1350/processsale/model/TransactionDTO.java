package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.integration.ItemDTO;

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

    public double getTaxAmount() {
        return taxAmount;
    }

    public double getChangeAmount() {
        return changeAmount;
    }

    public double getRunningTotal() {
        return runningTotal;
    }

    public ItemDTO getRegisteredItem() {
        return registeredItem;
    }
}
