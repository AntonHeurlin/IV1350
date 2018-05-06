package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.integration.ItemDTO;

import java.util.ArrayList;

/**
 * Represents a transaction occuring between a customer and a cashier/store
 */
public class Transaction {
    private ArrayList<ItemDTO> registeredItems;
    private Cost totalCost;

    /**
     * Initiates a specific transaction, where one specific transaction between customer and the store a cashier represents.
     */
    public Transaction() {
        this.registeredItems = new ArrayList<>();
    }

    /**
     * Method that's adds an object of the type ItemDTO to a Transaction.
     * @param foundItem this itemDTO is a specific representation of the item a customer wants to buy.
     */
    public TransactionDTO addItem(ItemDTO foundItem){
        if(foundItem == null){
            return null;
        }
        this.registeredItems.add(foundItem);
        this.totalCost = new Cost(this);
        TransactionDTO transactionDTO = new TransactionDTO(foundItem, this.totalCost);
        return transactionDTO;
    }

    /**
     *
     * @return the arraylist of items which have been registered into a transaction
     */
    public ArrayList<ItemDTO> getRegisteredItems(){
        return this.registeredItems;
    }

    /**
     *
     * @return the total cost of a transaction.
     */
    public Cost getTotalCost(){
        return this.totalCost;
    }


}
