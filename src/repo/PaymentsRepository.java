// package com.nwb.cust.repo;
package repo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// import com.nwb.cust.model.*;
import model.*;

public class PaymentsRepository {
    private List<Payments> payments = new ArrayList<>();

    public PaymentsRepository() {
        // Adding some dummy data with Bill fields properly initialized
        payments.add(new Payments(1, new Date(), "Credit Card", "123456", 100.0, "Completed", "Electricity", new Date(), 150.75, "Paid"));
        payments.add(new Payments(2, new Date(), "Bank Transfer", "789101", 200.0, "Pending", "Water", new Date(), 75.50, "Pending"));
        payments.add(new Payments(3, new Date(), "PayPal", "112131", 300.0, "Failed", "Internet", new Date(), 50.25, "Failed"));
        payments.add(new Payments(4, new Date(), "Credit Card", "415161", 400.0, "Completed", "Rent", new Date(), 500.00, "Paid"));
        payments.add(new Payments(5, new Date(), "Bank Transfer", "718192", 500.0, "Completed", "Gas", new Date(), 120.00, "Pending"));
    }

    public List<Payments> getPayments() {
        return payments;
    }
}
