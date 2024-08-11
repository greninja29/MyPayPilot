package controller;
import model.*;
import repo.*;
import service.*;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class General_Payment_Creation_Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static ScheduledPaymentService service = new ScheduledPaymentService(new ScheduledPaymentRepository());

    public static void main(String[] args) {
        while (true) {
            System.out.println("Scheduled Payment Management System");
            System.out.println("1. Create Payment");
            System.out.println("2. View Payment");
            System.out.println("3. Update Payment");
            System.out.println("4. Delete Payment");
            System.out.println("5. View All Payments");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createPayment();
                    break;
                case 2:
                    viewPayment();
                    break;
                case 3:
                    updatePayment();
                    break;
                case 4:
                    deletePayment();
                    break;
                case 5:
                    viewAllPayments();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void createPayment() {
        ScheduledPayment payment = new ScheduledPayment();
        System.out.print("Enter Payee Name: ");
        payment.setPayeeName(scanner.nextLine());
        System.out.print("Enter Payee Address: ");
        payment.setPayeeAddress(scanner.nextLine());
        System.out.print("Enter Payee Bank Details: ");
        payment.setPayeeBankDetails(scanner.nextLine());
        System.out.print("Enter Payment Frequency: ");
        payment.setPaymentFrequency(scanner.nextLine());
        System.out.print("Enter Scheduled Date (yyyy-MM-dd): ");
        try {
            payment.setScheduledDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse(scanner.nextLine()));
        } catch (Exception e) {
            System.out.println("Invalid date format. Setting to current date.");
            payment.setScheduledDate(new Date());
        }
        System.out.print("Enter Amount: ");
        payment.setAmount(scanner.nextDouble());
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Payment Mode: ");
        payment.setPaymentMode(scanner.nextLine());
        System.out.print("Enter Payer Account Number: ");
        payment.setPayerAccountNumber(scanner.nextLine());

        ScheduledPayment createdPayment = service.createPayment(payment);
        System.out.println("Payment created with ID: " + createdPayment.getScheduledPaymentId());
    }

    private static void viewPayment() {
        System.out.print("Enter Payment ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Optional<ScheduledPayment> payment = service.getPayment(id);
        if (payment.isPresent()) {
            System.out.println(payment.get());
        } else {
            System.out.println("Payment not found.");
        }
    }

    private static void updatePayment() {
        System.out.print("Enter Payment ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Optional<ScheduledPayment> optionalPayment = service.getPayment(id);
        if (optionalPayment.isPresent()) {
            ScheduledPayment payment = optionalPayment.get();
            System.out.println("Current details: " + payment);
            System.out.print("Enter new Payee Name (leave blank to keep current): ");
            String input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPayeeName(input);
            System.out.print("Enter new Payee Address (leave blank to keep current): ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPayeeAddress(input);
            System.out.print("Enter new Payee Bank Details (leave blank to keep current): ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPayeeBankDetails(input);
            System.out.print("Enter new Payment Frequency (leave blank to keep current): ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPaymentFrequency(input);
            System.out.print("Enter new Scheduled Date (yyyy-MM-dd, leave blank to keep current): ");
            input = scanner.nextLine();
            if (!input.isEmpty()) {
                try {
                    payment.setScheduledDate(new java.text.SimpleDateFormat("yyyy-MM-dd").parse(input));
                } catch (Exception e) {
                    System.out.println("Invalid date format. Keeping current date.");
                }
            }
            System.out.print("Enter new Amount (leave blank to keep current): ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setAmount(Double.parseDouble(input));
            System.out.print("Enter new Payment Mode (leave blank to keep current): ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPaymentMode(input);
            System.out.print("Enter new Payer Account Number (leave blank to keep current): ");
            input = scanner.nextLine();
            if (!input.isEmpty()) payment.setPayerAccountNumber(input);

            ScheduledPayment updatedPayment = service.updatePayment(payment);
            System.out.println("Payment updated: " + updatedPayment);
        } else {
            System.out.println("Payment not found.");
        }
    }

    private static void deletePayment() {
        System.out.print("Enter Payment ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        service.deletePayment(id);
        System.out.println("Payment deleted.");
    }

    private static void viewAllPayments() {
        List<ScheduledPayment> payments = service.getAllPayments();
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
        } else {
            payments.forEach(System.out::println);
        }
    }
}
