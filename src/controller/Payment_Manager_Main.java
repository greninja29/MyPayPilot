package controller;
import model.*;
import repo.*;
import service.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Payment_Manager_Main {

    public static void main(String[] args) {
        PaymentsRepository paymentsRepository = new PaymentsRepository();
        BillRepository billRepository = new BillRepository();

        // Create PaymentManager with both repositories
        PaymentManager manager = new PaymentManager(paymentsRepository, billRepository);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

        try {
            Date startDate = sdf.parse("01-01-2024");
            Date endDate = sdf.parse("12-31-2024");
            String billName = "Electricity";

            List<Payments> paymentHistory = manager.getPaymentHistory(billName, startDate, endDate);

            System.out.println("\nPayment History:");
            for (Payments payment : paymentHistory) {
                double totalAmount = payment.getAmount(); // Assuming 'amount' refers to the total amount due from Bill class
                Date dueDate = null;
                
                // Find the corresponding Bill to get the due date
                for (Bill bill : billRepository.getBills()) {
                    if (bill.getName() != null && bill.getName().equalsIgnoreCase(billName)) {
                        dueDate = bill.getDueDate();
                        break;
                    }
                }

                System.out.println("Bill Name: " + payment.getName());
                System.out.println("Due Date: " + (dueDate != null ? sdf.format(dueDate) : "Not Available"));
                System.out.println("Paid On: " + sdf.format(payment.getPaymentDate()));
                System.out.println("Payment Mode: " + payment.getPaymentMode());
                System.out.println("Total Amount: " + totalAmount);
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // For payment progress overview
        try {
            List<Payments> payments = manager.getPaymentProgress("Electricity");
            System.out.println("\nPayment Progress Overview:");
            Date currentDate = new Date();
            for (Payments payment : payments) {
                double amountDue = payment.getAmount() - payment.getAmountPaid();
                long diffInMillis = currentDate.getTime() - payment.getDueDate().getTime();
                long overdueDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

                System.out.println("Bill Name: " + payment.getName());
                System.out.println("Due Date: " + sdf.format(payment.getDueDate()));
                System.out.println("Amount Due: " + amountDue);
                System.out.println("Total Amount: " + payment.getAmount());
                System.out.println("Overdue By: " + overdueDays + " days");
                System.out.println("Payment Progress: " + payment.getStatus());
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // For payments overview
        try {
            Date fromDate = sdf.parse("07-01-2024");
            Date toDate = sdf.parse("08-31-2024");

            List<Bill> billsInRange = manager.paymentsOverview("Utilities", fromDate, toDate);

            Date currentDate = new Date();
            System.out.println("\nPayment Overview:");
            for (Bill bill : billsInRange) {
                long diffInMillis = bill.getDueDate().getTime() - currentDate.getTime();
                long dueDays = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

                System.out.println("Name: " + bill.getName());
                System.out.println("Due Date: " + sdf.format(bill.getDueDate()));
                System.out.println("Amount: " + bill.getAmount());
                System.out.println("Payment Status: " + bill.getPaymentStatus());
                System.out.println("Due in Days: " + dueDays);
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
