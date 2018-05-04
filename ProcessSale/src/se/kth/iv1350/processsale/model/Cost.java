package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.integration.ItemDTO;

public class Cost {
    private double totalCost;
    private double taxAmount;
    private double changeAmount;

    public final double TAXMODIFIER = 0.30;

    /**
     * Constructor for an Cost object, determines the totalCost based on the specific item that has been registered
     * into an array of registeredItems in a Transaction object.
     * @param currentTransaction this is the current transaction object that is being handled by the controller in a
     *                           a process sale.
     */
    public Cost(Transaction currentTransaction){
        for(ItemDTO item : currentTransaction.getRegisteredItems()){
            this.totalCost += item.getItemPrice();
        }
        calculateTax(this.totalCost);
        this.changeAmount = 0;
    }


    /**
     * Method calculates a given taxAmount depending on a specific total cost amount.
     * @param totalCost the total cost of an specific transaction.
     */
    private void calculateTax(double totalCost){
        this.taxAmount = totalCost * TAXMODIFIER;
    }

    /**
     * This method calculates the amount of change a customer shall get in return after paying for a transaction
     * with a specific amount of money.
     * @param paymentAmount this is the amount the customer has payed for the transaction.
     * @return this returns the value of change, which is the money a customer shall recieve in return, if he payed
     * sufficient funds (solved in another method in a layer above).
     */
    public double calculateChange(double paymentAmount){
        return  this.changeAmount = (totalCost - paymentAmount)*-1;
    }

    public double getTaxAmount(){
        return this.taxAmount;
    }

    public double getChangeAmount(){
        return this.changeAmount;
    }

    public double getTotalCost(){
        return this.totalCost;
    }
}
