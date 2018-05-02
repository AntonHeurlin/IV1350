package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.integration.ItemDTO;

import java.util.Arrays;


public class Transaction {
    private ItemDTO[] registeredItems;
    private Cost totalCost;

    public Transaction() {
        this.registeredItems = new ItemDTO[1];
        registeredItems[0] = null;
    }

    /**
     * Method thats adds an object of the type ItemDTO to an array of registeredItems.
     * @param foundItem this item has been found by the Controller in the ItemRegistry and is now being sent to
     *                  transaction in order to add it to a transaction order.
     */

    public void addItem(ItemDTO foundItem){
        if(registeredItems[0] == null){
            registeredItems[0] = foundItem;
        }
        else {
            this.updateRegisteredItems(foundItem);
        }
        this.totalCost = new Cost(this);
    }

    /**
     * Method thats updates the registeredItems list if more than one item is added to the transaction object.
     * @param foundItem a item found in the itemRegister that a customer wants to buy.
     */
    private void updateRegisteredItems(ItemDTO foundItem){
        ItemDTO[] updatedItemList = new ItemDTO[registeredItems.length + 1];
        int i;
        for (i = 0; i < registeredItems.length; i++) {
            updatedItemList[i] = registeredItems[i];
        }
        updatedItemList[i] = foundItem;
        this.registeredItems = updatedItemList;
    }

    public ItemDTO[] getRegisteredItems(){
        return this.registeredItems;
    }

    public Cost getTotalCost(){
        return this.totalCost;
    }

}
