package se.kth.iv1350.processsale.integration;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemRegisterTest {

    @Test
    public void testSearchItem() {
        ItemRegister itemRegisterTest = new ItemRegister();
        ItemDTO bananTest = new ItemDTO("Banan", 12, 1111);
        itemRegisterTest.searchItem(1111);
        assertEquals(bananTest.getItemName(), itemRegisterTest.searchItem(1111).getItemName());
        assertEquals(bananTest.getItemBarcode(), itemRegisterTest.searchItem(1111).getItemBarcode());
        assertEquals(bananTest.getItemPrice(), itemRegisterTest.searchItem(1111).getItemPrice(), 0.000);
    }
}