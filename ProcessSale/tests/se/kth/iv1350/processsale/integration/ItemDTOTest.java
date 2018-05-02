package se.kth.iv1350.processsale.integration;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemDTOTest {

    @Test
    public void itemDescription() {
        ItemRegister itemRegisterTest = new ItemRegister();
        String expected = "(ItemName: " +"Banan" +", ItemPrice: " +12.0 +", ItemBarcode: " +1111 +")";
        assertEquals(expected, itemRegisterTest.getItemRegister()[0].itemDescription());
    }
}