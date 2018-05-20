package se.kth.iv1350.processsale.view;

import se.kth.iv1350.processsale.model.TotalRevenueObserver;

public class TotalRevenueDisplay implements TotalRevenueObserver {

    public void showTotalRevenueAmount(double totalRevenueAmount){
        System.out.println("TOTAL REVENUE DISPLAY PRINTOUT: " +"\n" +"TOTAL REVENUE AMOUNT: " +totalRevenueAmount +"\n");
    }

    @Override
    public void totalRevenueUpdated(double totalRevenueAmount){
        showTotalRevenueAmount(totalRevenueAmount);
    }

}
