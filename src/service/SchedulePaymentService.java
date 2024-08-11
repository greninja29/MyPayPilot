// package com.nwb.cust.service;

// import com.nwb.cust.model.ScheduledPayment;
package service;
import model.*;
import repo.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SchedulePaymentService {

    private ScheduledPaymentService service;

    public SchedulePaymentService(ScheduledPaymentService service) {
        this.service = service;
    }

    public void schedulePayment() {
        Scanner scanner = new Scanner(System.in);
        ScheduledPayment payment = new ScheduledPayment();
        System.out.println("Enter Payment Details:");

        System.out.print("Payee Name: ");
        payment.setPayeeName(scanner.nextLine());
        System.out.print("Payee Address: ");
        payment.setPayeeAddress(scanner.nextLine());
        System.out.print("Payee Bank Details: ");
        payment.setPayeeBankDetails(scanner.nextLine());
        System.out.print("Payment Frequency: ");
        payment.setPaymentFrequency(scanner.nextLine());

        System.out.print("Scheduled Date (yyyy-MM-dd): ");
        try {
            payment.setScheduledDate(new SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine()));
        } catch (Exception e) {
            System.out.println("Invalid date format. Setting to current date.");
            payment.setScheduledDate(new Date());
        }

        System.out.print("Amount: ");
        payment.setAmount(scanner.nextDouble());
        scanner.nextLine(); // Consume newline
        System.out.print("Payment Mode: ");
        payment.setPaymentMode(scanner.nextLine());
        System.out.print("Payer Account Number: ");
        payment.setPayerAccountNumber(scanner.nextLine());

        service.createPayment(payment);
        System.out.println("Payment scheduled successfully! with id: " + payment.getScheduledPaymentId());
    }
}
