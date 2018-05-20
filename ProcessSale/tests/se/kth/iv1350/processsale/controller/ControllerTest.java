package se.kth.iv1350.processsale.controller;

import org.junit.Test;
import se.kth.iv1350.processsale.integration.DbHandler;
import se.kth.iv1350.processsale.integration.ItemDTO;
import se.kth.iv1350.processsale.integration.ItemException;
import se.kth.iv1350.processsale.model.Transaction;

import static org.junit.Assert.*;

public class ControllerTest {

    @Test
    public void testStartTransaction() {
        DbHandler dbHandler = new DbHandler();
        Controller controller = new Controller(dbHandler);
        controller.startTransaction();
        Transaction testTransaction = new Transaction();
        assertEquals(testTransaction.getRegisteredItems(), controller.getCurrentTransaction().getRegisteredItems());
    }

    @Test
    public void testEnterItem() throws ItemException {
        DbHandler dbHandler = new DbHandler();
        Controller controller = new Controller(dbHandler);
        controller.startTransaction();
        controller.enterItem(1111);
        ItemDTO bananTest = new ItemDTO("Banan", 12, 1111);
        assertEquals(bananTest.getItemName(), controller.getCurrentTransaction().getRegisteredItems().get(0).getItemName());
        assertEquals(bananTest.getItemBarcode(), controller.getCurrentTransaction().getRegisteredItems().get(0).getItemBarcode());
        assertEquals(bananTest.getItemPrice(), controller.getCurrentTransaction().getRegisteredItems().get(0).getItemPrice(), 0.000);
        assertEquals(bananTest.getItemPrice(), controller.getCurrentTransaction().getTotalCost().getTotalCost(), 0.000);
    }

    @Test
    public void testPay() throws ItemException {
        DbHandler dbHandler = new DbHandler();
        Controller controller = new Controller(dbHandler);
        controller.startTransaction();
        controller.enterItem(1111);
        int payment = 150;
        int expectedChange = 150-12;
        controller.pay(payment);
        assertEquals(expectedChange, controller.pay(payment).getChangeAmount(), 0.000);
    }
}