package com.company;

import java.time.LocalDate;
import java.util.ArrayList;

public class Invoice {
    private String customerName;
    private LocalDate transactionDate;
    private ArrayList<LineItem> items;

    public Invoice(){

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<LineItem> items) {
        this.items = items;
    }

    public void addItem(LineItem item){
        items.add(item);
    }
}
