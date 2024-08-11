// package com.nwb.cust.repo;

// import com.nwb.cust.model.*;

package repo;
import model.*;

// ScheduledPaymentRepository.java
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;



/**
 * Repository for managing scheduled payments with an in-memory list.
 */
public class ScheduledPaymentRepository {
    private List<ScheduledPayment> payments = new ArrayList<>();
    private int idCounter = 1;

    // Dummy Data
    public ScheduledPaymentRepository() {
        // Adding some dummy data
        ScheduledPayment payment1 = new ScheduledPayment();
        payment1.setScheduledPaymentId(idCounter++);
        payment1.setPayeeName("John Doe");
        payment1.setPayeeAddress("123 Elm St, Springfield");
        payment1.setPayeeBankDetails("Bank A, Account 12345");
        payment1.setPaymentFrequency("Monthly");
        payment1.setScheduledDate(new Date());
        payment1.setAmount(100.00);
        payment1.setPaymentMode("Bank Transfer");
        payment1.setPayerAccountNumber("A123456789");
        payments.add(payment1);
    }

    public ScheduledPayment save(ScheduledPayment payment) {
        if (payment.getScheduledPaymentId() == 0) {
            payment.setScheduledPaymentId(idCounter++);
        }
        payments.add(payment);
        return payment;
    }

    public Optional<ScheduledPayment> findById(int id) {
        return payments.stream().filter(p -> p.getScheduledPaymentId() == id).findFirst();
    }

    public void delete(int id) {
        payments.removeIf(p -> p.getScheduledPaymentId() == id);
    }

    public List<ScheduledPayment> findAll() {
        return new ArrayList<>(payments);
    }
}
