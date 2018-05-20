package se.kth.iv1350.processsale.model;

import org.junit.Test;
import se.kth.iv1350.processsale.integration.ItemDTO;
import se.kth.iv1350.processsale.integration.ItemException;

import static org.junit.Assert.*;

public class TransactionTest {

    @Test
    public void testAddItem() throws ItemException {
        Transaction testTransaction = new Transaction();
        ItemDTO testItem = new ItemDTO("Hoegaarden", 27, 1111);
        testTransaction.addItem(testItem);
        assertEquals(testItem, testTransaction.getRegisteredItems().get(0));
    }

    @Test
    public void testAddItem2() throws ItemException {
        Transaction testTransaction = new Transaction();
        ItemDTO testItem = new ItemDTO("Hoegaarden", 27, 1111);
        ItemDTO testItem2 = new ItemDTO("Kronenberg Blanc ", 18, 1212);
        testTransaction.addItem(testItem);
        testTransaction.addItem(testItem2);
        assertEquals(testItem2, testTransaction.getRegisteredItems().get(1));
    }

    @Test
    public void testAddItemTotalCost() throws ItemException {
        Transaction testTransaction = new Transaction();
        ItemDTO testItem = new ItemDTO("Hoegaarden", 27, 1111);
        ItemDTO testItem2 = new ItemDTO("Kronenberg Blanc ", 18, 1212);
        testTransaction.addItem(testItem);
        testTransaction.addItem(testItem2);
        double testTotalCost = 27.0 + 18.0;
        double testTaxAmount = (27.0 + 18.0) * 0.30;
        assertEquals(testTotalCost, testTransaction.getTotalCost().getTotalCost(), 0.000);
        assertEquals(testTaxAmount, testTransaction.getTotalCost().getTaxAmount(), 0.000);

    }

}