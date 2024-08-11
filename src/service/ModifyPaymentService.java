// package com.nwb.cust.service;


// import com.nwb.cust.model.ScheduledPayment;
package service;
import model.*;
import model.ScheduledPayment;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Scanner;

public class ModifyPaymentService {

    private ScheduledPaymentService service;

    public ModifyPaymentService(ScheduledPaymentService service) {
        this.service = service;
    }

    public void modifyScheduledPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Payment ID to modify: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Optional<ScheduledPayment> optionalPayment = service.getPayment(id);

        if (optionalPayment.isPresent()) {
            ScheduledPayment payment = optionalPayment.get();
            System.out.println("Current details: " + payment);
            System.out.println("Enter new details (leave blank to keep current):");

            System.out.print("New Payee Name: ");
            String input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPayeeName(input);

            System.out.print("New Payee Address: ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPayeeAddress(input);

            System.out.print("New Payee Bank Details: ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPayeeBankDetails(input);

            System.out.print("New Payment Frequency: ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPaymentFrequency(input);

            System.out.print("New Scheduled Date (yyyy-MM-dd): ");
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                try {
                    payment.setScheduledDate(new SimpleDateFormat("yyyy-MM-dd").parse(input));
                } catch (Exception e) {
                    System.out.println("Invalid date format. Keeping current date.");
                }
            }

            System.out.print("New Amount: ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setAmount(Double.parseDouble(input));

            System.out.print("New Payment Mode: ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPaymentMode(input);

            System.out.print("New Payer Account Number: ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPayerAccountNumber(input);

            service.updatePayment(payment);
            System.out.println("Payment modified successfully!");
        } else {
            System.out.println("Payment not found.");
        }
    }
}
