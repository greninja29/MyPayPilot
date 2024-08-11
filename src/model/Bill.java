// package com.nwb.cust.model;
package model;
import java.util.Date;

public class Bill {
    private String billId;
    private String name;
    private String billCategory;
    private Date dueDate;
    private double amount;
    private String paymentStatus;

    public Bill(String billId, String name, String billCategory, Date dueDate, double amount, String paymentStatus) {
        this.billId = billId;
        this.name = name;
        this.billCategory = billCategory;
        this.dueDate = dueDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public Bill() {}

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBillCategory() {
        return billCategory;
    }

    public void setBillCategory(String billCategory) {
        this.billCategory = billCategory;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}