package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Transaction;

import java.util.ArrayList;

public class InventoryInformationDTO {
    private ArrayList<ItemDTO> soldItems;

    public InventoryInformationDTO(Transaction transaction){
        this.soldItems = transaction.getRegisteredItems();
    }
}
