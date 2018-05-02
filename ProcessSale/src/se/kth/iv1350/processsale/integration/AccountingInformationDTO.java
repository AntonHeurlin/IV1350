package se.kth.iv1350.processsale.integration;

import se.kth.iv1350.processsale.model.Transaction;

public class AccountingInformationDTO {
    private double totalCost;
    private double taxAmount;

    public AccountingInformationDTO(Transaction transaction){
        this.totalCost = transaction.getTotalCost().getTotalCost();
        this.taxAmount = transaction.getTotalCost().getTaxAmount();
    }

}
