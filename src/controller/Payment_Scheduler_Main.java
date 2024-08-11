package controller;
import model.*;
import repo.*;
import service.*;
import java.util.Optional;
import java.util.Scanner;

import service.*;
public class Payment_Scheduler_Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static ScheduledPaymentService repositoryService = new ScheduledPaymentService(new ScheduledPaymentRepository());

    private static SchedulePaymentService schedulePaymentService = new SchedulePaymentService(repositoryService);
    private static ModifyPaymentService modifyPaymentService = new ModifyPaymentService(repositoryService);
    private static CancelPaymentService cancelPaymentService = new CancelPaymentService(repositoryService);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nScheduled Payment Management System");
            System.out.println("1. Schedule a Payment");
            System.out.println("2. Modify a Scheduled Payment");
            System.out.println("3. Cancel a Scheduled Payment");
            System.out.println("4. View Payment Details");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    schedulePaymentService.schedulePayment();
                    break;
                case 2:
                    modifyPaymentService.modifyScheduledPayment();
                    break;
                case 3:
                    cancelPaymentService.cancelScheduledPayment();
                    break;
                case 4:
                    viewPaymentDetails();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void viewPaymentDetails() {
        System.out.print("Enter Payment ID to view: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Optional<ScheduledPayment> optionalPayment = repositoryService.getPayment(id);

        if (optionalPayment.isPresent()) {
            System.out.println(optionalPayment.get());
        } else {
            System.out.println("Payment not found.");
        }
    }
}
