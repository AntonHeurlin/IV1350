package se.kth.iv1350.processsale.model;

import org.junit.Test;
import se.kth.iv1350.processsale.integration.ItemDTO;
import se.kth.iv1350.processsale.integration.ItemException;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class ReceiptTest {

    @Test
    public void testReceipt() throws ItemException {
        Transaction testTransaction = new Transaction();
        ItemDTO testItem = new ItemDTO("Hoegaarden", 27, 1111);
        ItemDTO testItem2 = new ItemDTO("Kronenberg Blanc ", 18, 1212);
        testTransaction.addItem(testItem);
        testTransaction.addItem(testItem2);
        int payment = 150;
        LocalDateTime transactionTime = LocalDateTime.now();
        Receipt testReceipt = new Receipt(testTransaction, payment);
        System.out.println("Expected result should contain:" +"\n" +"Time & Date: " +transactionTime +"\n" +testItem +"\n" +testItem2 +"\n TotalCost + TaxAmount: "
                +testTransaction.getTotalCost().getTotalCost()  +", " +testTransaction.getTotalCost().getTaxAmount());
        System.out.println(testReceipt.getReceipt());
        System.out.println();
        assertTrue(testReceipt.getReceipt().contains("Hoegaarden"));
        assertTrue(testReceipt.getReceipt().contains("Kronenberg Blanc"));
    }
}