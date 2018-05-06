package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Transaction;

/**
 * represents the class which handles method calls between data bases and other layers of the system.
 */
public class DbHandler {

    /**
     * packages certain information from a specific transaction in order to send it to the external accounting system
     * @param transaction this is a transaction which have been finalized and is now ready to be logged into databases.
     */
    public void SendAccountingInformation(Transaction transaction){
        AccountingInformationDTO accountingInformationDTO = new AccountingInformationDTO(transaction);

    }

    /**
     * packages certain information from a specific transaction in order to send it to the external accounting system
     * @param transaction this is a transaction which have been finalized and is now ready to be logged into databases.
     */
    public void SendInventoryInformation(Transaction transaction){
        InventoryInformationDTO inventoryInformationDTO = new InventoryInformationDTO(transaction);

    }
}
