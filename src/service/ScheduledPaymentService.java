// package com.nwb.cust.service;

// ScheduledPaymentService.java
package service;
import java.util.List;

import java.util.Optional;

// import com.nwb.cust.model.*;
// import com.nwb.cust.repo.*;

import model.*;
import repo.*;
/**
 * Service for managing scheduled payments with business logic.
 */
public class ScheduledPaymentService {
    private ScheduledPaymentRepository repository;

    public ScheduledPaymentService(ScheduledPaymentRepository repository) {
        this.repository = repository;
    }

    public ScheduledPayment createPayment(ScheduledPayment payment) {
        return repository.save(payment);
    }

    public Optional<ScheduledPayment> getPayment(int id) {
        return repository.findById(id);
    }

    public void deletePayment(int id) {
        repository.delete(id);
    }

    public List<ScheduledPayment> getAllPayments() {
        return repository.findAll();
    }

    public ScheduledPayment updatePayment(ScheduledPayment payment) {
        deletePayment(payment.getScheduledPaymentId());
        return repository.save(payment);
    }
}
