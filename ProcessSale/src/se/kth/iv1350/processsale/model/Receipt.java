package se.kth.iv1350.processsale.model;

import java.time.LocalDateTime;

public class Receipt {
    private final Transaction finalizedTransaction;
    private String receipt;


    public Receipt(Transaction currentTransaction){

        this.finalizedTransaction = currentTransaction;
        this.receipt = null;
    }

    public void generateReceipt(){
        StringBuilder receiptBuilder = new StringBuilder();
        appendLine(receiptBuilder, "ANTONS FRUKTHANDEL");
        endSection(receiptBuilder);

        LocalDateTime TransactionTime = LocalDateTime.now();
        receiptBuilder.append("Transaction completed at:" +"\n");
        appendLine(receiptBuilder, TransactionTime.toString());
        endSection(receiptBuilder);

        receiptBuilder.append("Transaction information: ");
        endSection(receiptBuilder);
        int i;
        for(i = 0; i < finalizedTransaction.getRegisteredItems().length; i++){
            receiptBuilder.append((i+1) +". ");
            appendLine(receiptBuilder, finalizedTransaction.getRegisteredItems()[i].itemDescription());
            endSection(receiptBuilder);
        }
        receiptBuilder.append(this.finalizedTransaction.getTotalCost().finalizeTransaction());
        endSection(receiptBuilder);

        this.receipt = receiptBuilder.toString();
    }

    public String getReceipt(){
        return this.receipt;
    }

    private void appendLine(StringBuilder receiptBuilder, String line){
        receiptBuilder.append(line);
        receiptBuilder.append("\n");
    }

    private void endSection(StringBuilder receiptBuilder){
        receiptBuilder.append("\n");
    }
}

