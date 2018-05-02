package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Transaction;

public class DbHandler {

    public void SendAccountingInformation(Transaction transaction){
        AccountingInformationDTO accountingInformationDTO = new AccountingInformationDTO(transaction);
    }

    public void SendInventoryInformation(Transaction transaction){
        InventoryInformationDTO inventoryInformationDTO = new InventoryInformationDTO(transaction);

    }
}
