package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Transaction;

public class InventoryInformationDTO {
    private ItemDTO[] soldItems;

    public InventoryInformationDTO(Transaction transaction){
        this.soldItems = transaction.getRegisteredItems();
    }
}
