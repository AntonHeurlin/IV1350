package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Transaction;

/**
 * represents a package of data pertinent to the external accounting system.
 */
class AccountingInformationDTO {
    private double totalCost;
    private double taxAmount;

    /**
     * creates a specific data package which is pertinent to the external accounting system.
     * @param transaction a transaction which has been finalized and is now ready to be logged into databases.
     */
    public AccountingInformationDTO(Transaction transaction){
        this.totalCost = transaction.getTotalCost().getTotalCost();
        this.taxAmount = transaction.getTotalCost().getTaxAmount();
    }

}
