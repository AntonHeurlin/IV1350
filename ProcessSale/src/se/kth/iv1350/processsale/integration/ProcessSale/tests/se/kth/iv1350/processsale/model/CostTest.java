package se.kth.iv1350.processsale.model;

import org.junit.Test;
import se.kth.iv1350.processsale.integration.ItemDTO;
import se.kth.iv1350.processsale.integration.ItemException;

import static org.junit.Assert.*;

public class CostTest {

    @Test
    public void testCost() throws ItemException {
        Transaction testTransaction = new Transaction();
        ItemDTO testItem = new ItemDTO("Hoegaarden", 27, 1111);
        ItemDTO testItem2 = new ItemDTO("Kronenberg Blanc ", 18, 1212);
        testTransaction.addItem(testItem);
        testTransaction.addItem(testItem2);
        Cost testCost = new Cost(testTransaction);
        assertEquals(testCost.getTotalCost(), testTransaction.getTotalCost().getTotalCost(), 0.000);
        assertEquals(testCost.getTaxAmount(), testTransaction.getTotalCost().getTaxAmount(),0.000);

    }

    @Test
    public void testCalculateChange() throws ItemException {
        Transaction testTransaction = new Transaction();
        ItemDTO testItem = new ItemDTO("Hoegaarden", 27, 1111);
        ItemDTO testItem2 = new ItemDTO("Kronenberg Blanc ", 18, 1212);
        testTransaction.addItem(testItem);
        testTransaction.addItem(testItem2);
        Cost testCost = new Cost(testTransaction);
        int payment = 150;
        assertEquals(testCost.calculateChange(payment), testTransaction.getTotalCost().calculateChange(payment), 0.000);
    }
}