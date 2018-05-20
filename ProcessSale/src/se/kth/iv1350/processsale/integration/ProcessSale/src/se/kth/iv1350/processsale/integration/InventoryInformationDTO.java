package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Transaction;

import java.util.ArrayList;

/**
 * represents a package of data pertinent to a Inventory System.
 */
class InventoryInformationDTO {
    private ArrayList<ItemDTO> soldItems;

    /**
     * creates a specific package of data pertinent to Inventory System.
     * @param transaction a transaction which has been finalized and is now ready to be logged into databases.
     */
    public InventoryInformationDTO(Transaction transaction){
        this.soldItems = transaction.getRegisteredItems();
    }
}
