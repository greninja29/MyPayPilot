// package com.nwb.cust.service;
package service;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
// import com.nwb.cust.model.*;
// import com.nwb.cust.repo.*;
import model.*;
import repo.*;

public class PaymentManager {
    private PaymentsRepository paymentsRepository;
    private BillRepository billRepository;

    // Constructor to initialize both repositories
    public PaymentManager(PaymentsRepository paymentsRepository, BillRepository billRepository) {
        this.paymentsRepository = paymentsRepository;
        this.billRepository = billRepository;
    }

    // Method to get payment history
    public List<Payments> getPaymentHistory(String billName, Date startDate, Date endDate) {
        if (paymentsRepository == null || billRepository == null) {
            throw new IllegalStateException("Repositories are not initialized");
        }

        List<Payments> paymentHistory = new ArrayList<>();
        for (Payments payment : paymentsRepository.getPayments()) {
            if (payment.getName() != null && payment.getName().equalsIgnoreCase(billName)) {
                if (!payment.getPaymentDate().before(startDate) && !payment.getPaymentDate().after(endDate)) {
                    paymentHistory.add(payment);
                }
            }
        }
        return paymentHistory;
    }

    // Method to get payment progress
    public List<Payments> getPaymentProgress(String billName) {
        if (paymentsRepository == null) {
            throw new IllegalStateException("PaymentsRepository is not initialized");
        }

        List<Payments> paymentProgress = new ArrayList<>();
        for (Payments payment : paymentsRepository.getPayments()) {
            if (payment.getName() != null && payment.getName().equalsIgnoreCase(billName)) {
                paymentProgress.add(payment);
            }
        }
        return paymentProgress;
    }

    // Method to get payments overview
    public List<Bill> paymentsOverview(String category, Date fromDate, Date toDate) {
        List<Bill> result = new ArrayList<>();
        for (Bill bill : billRepository.getBills()) {
            if (bill.getBillCategory().equalsIgnoreCase(category)) {
                if (!bill.getDueDate().before(fromDate) && !bill.getDueDate().after(toDate)) {
                    result.add(bill);
                }
            }
        }
        return result;
    }
}
