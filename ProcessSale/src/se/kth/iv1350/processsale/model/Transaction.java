package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.integration.ItemDTO;

import java.util.ArrayList;


public class Transaction {
    private ArrayList<ItemDTO> registeredItems;
    private Cost totalCost;

    public Transaction() {
        this.registeredItems = new ArrayList<>();
    }

    /**
     * Method thats adds an object of the type ItemDTO to an array of registeredItems.
     * @param foundItem this item has been found by the Controller in the ItemRegistry and is now being sent to
     *                  transaction in order to add it to a transaction order.
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

    public ArrayList<ItemDTO> getRegisteredItems(){
        return this.registeredItems;
    }


    public Cost getTotalCost(){
        return this.totalCost;
    }


}
