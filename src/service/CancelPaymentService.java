// package com.nwb.cust.service;
package service;
import java.util.Scanner;

public class CancelPaymentService {

    private ScheduledPaymentService service;

    public CancelPaymentService(ScheduledPaymentService service) {
        this.service = service;
    }

    public void cancelScheduledPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Payment ID to cancel: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        service.deletePayment(id);
        System.out.println("Payment canceled successfully!");
    }
}
