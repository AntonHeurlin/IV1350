package se.kth.iv1350.processsale.model;

import java.util.ArrayList;
import java.util.List;

public class TotalRevenue {
    private double totalRevenueAmount;
    private List<TotalRevenueObserver> totalRevenueObservers = new ArrayList<>();

    public TotalRevenue(){
        this.totalRevenueAmount = 0;
    }

    public void addTotalRevenueObserver(TotalRevenueObserver observer) {
        totalRevenueObservers.add(observer);
    }

    public void updateTotalRevenueAmount(Cost transactionCost){
        this.totalRevenueAmount += transactionCost.getTotalCost();
        notifyObservers();
    }

    private void notifyObservers(){
        for (TotalRevenueObserver totalRevenueObserver : this.totalRevenueObservers) {
            totalRevenueObserver.totalRevenueUpdated(this.totalRevenueAmount);
        }
    }

}
