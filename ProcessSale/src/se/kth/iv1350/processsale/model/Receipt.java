package se.kth.iv1350.processsale.model;

import se.kth.iv1350.processsale.integration.ItemDTO;

import java.time.LocalDateTime;

/**
 * Represents a framework for how a receipt shall look when printing.
 */
public class Receipt {
    private String receipt;
    private double changeAmount;

    /**
     * This method creates a receipt String which shall be used by the user-interface in order to print-out a receipt.
     * @param finalizedTransaction This is a transaction in which all items have been scanned and which is ready to be finalized and payed for.
     * @param paymentAmount This is the amount a specific customer have payed for the transaction in question.
     */
    public Receipt(Transaction finalizedTransaction, double paymentAmount){
        this.changeAmount = finalizedTransaction.getTotalCost().calculateChange(paymentAmount);

        StringBuilder receiptBuilder = new StringBuilder();
        appendLine(receiptBuilder, "ANTONS FRUKTHANDEL");
        endSection(receiptBuilder);

        LocalDateTime TransactionTime = LocalDateTime.now();
        receiptBuilder.append("Transaction completed at:" +"\n");
        appendLine(receiptBuilder, TransactionTime.toString());
        endSection(receiptBuilder);

        receiptBuilder.append("Transaction information: ");
        endSection(receiptBuilder);
        int i = 1;
        for(ItemDTO item : finalizedTransaction.getRegisteredItems()){
            receiptBuilder.append((i) +". ");
            appendLine(receiptBuilder, String.valueOf(item));
            endSection(receiptBuilder);
            i++;
        }
        receiptBuilder.append("[Total cost of Transaction: " +finalizedTransaction.getTotalCost().getTotalCost()
                +":-, included tax amount: " +(int)(finalizedTransaction.getTotalCost().getTaxAmount()) +":-]");
        endSection(receiptBuilder);

        this.receipt = receiptBuilder.toString();
    }

    /**
     *
     * @return the specific change amount a customer shall get in return after paying for a transaction.
     */
    public double getChangeAmount() {
        return changeAmount;
    }

    /**
     *
     * @return the Receipt which has recorded valuable information regarding a transaction.
     */
    public String getReceipt(){
        return this.receipt;
    }

    /**
     * This method adds information to a String and then ends the line which it added text on.
     * @param receiptBuilder the stringBuilder in which the receipt is being constructed.
     * @param line the line which shall be added the receipt information.
     */
    private void appendLine(StringBuilder receiptBuilder, String line){
        receiptBuilder.append(line);
        receiptBuilder.append("\n");
    }

    /**
     * This method prints ends the line in a stringbuilder.
     * @param receiptBuilder the stringbuilder in which the receipt is being constructed
     */
    private void endSection(StringBuilder receiptBuilder){
        receiptBuilder.append("\n");
    }
}

