package model;
import java.util.Date;
public class Payments extends Bill {
    private int paymentId;
    private Date paymentDate;
    private String paymentMode;
    private String payerAccountNumber;
    private double amountPaid;
    private String status;

    public Payments(int paymentId, Date paymentDate, String paymentMode, String payerAccountNumber, double amountPaid, String status, String name, Date dueDate, double amount, String paymentStatus) {
        super("",name, "", dueDate, amount, paymentStatus);
        this.paymentId = paymentId;
        this.paymentDate = paymentDate;
        this.paymentMode = paymentMode;
        this.payerAccountNumber = payerAccountNumber;
        this.amountPaid = amountPaid;
        this.status = status;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getStatus() {
        return status;
    }

    public void makePayment() {
        // Implement payment logic here
    }

    public void cancelPayment() {
        // Implement cancel payment logic here
    }
}