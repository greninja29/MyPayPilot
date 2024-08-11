package model;
import java.util.Date;


public class ScheduledPayment {
    private int scheduledPaymentId;
    private String payeeName;
    private String payeeAddress;
    private String payeeBankDetails;
    private String paymentFrequency;
    private Date scheduledDate;
    private double amount;
    private String paymentMode;
    private String payerAccountNumber;

    
    
    
    // Getters and Setters
    public int getScheduledPaymentId() {
        return scheduledPaymentId;
    }

    public void setScheduledPaymentId(int scheduledPaymentId) {
        this.scheduledPaymentId = scheduledPaymentId;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeAddress() {
        return payeeAddress;
    }

    public void setPayeeAddress(String payeeAddress) {
        this.payeeAddress = payeeAddress;
    }

    public String getPayeeBankDetails() {
        return payeeBankDetails;
    }

    public void setPayeeBankDetails(String payeeBankDetails) {
        this.payeeBankDetails = payeeBankDetails;
    }

    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public void setPayerAccountNumber(String payerAccountNumber) {
        this.payerAccountNumber = payerAccountNumber;
    }
    public void schedulePayment(ScheduledPayment payment) {};

    public void cancelScheduledPayment(ScheduledPayment payment)
    {
    	
    };

    public void modifyScheduledPayment(ScheduledPayment payment, Date newDate)
    {
    	
    };

//    public List<Payment> getPaymentHistory(String category, Date fromDate, Date toDate)
//    {
//    	List<Payment> abcd=null;
//    	return abcd;
//    };
//
//    public List<PaymentProgress> getPaymentProgress(String category)
//    {
//    	
//    };

//    public List<PaymentOverview> getPaymentOverview(String category, Date fromDate, Date toDate)
//    {
//    	
//    };

    @Override
    public String toString() {
        return "ScheduledPayment{" +
               "scheduledPaymentId=" + scheduledPaymentId +
               ", payeeName='" + payeeName + '\'' +
               ", payeeAddress='" + payeeAddress + '\'' +
               ", payeeBankDetails='" + payeeBankDetails + '\'' +
               ", paymentFrequency='" + paymentFrequency + '\'' +
               ", scheduledDate=" + scheduledDate +
               ", amount=" + amount +
               ", paymentMode='" + paymentMode + '\'' +
               ", payerAccountNumber='" + payerAccountNumber + '\'' +
               '}';
    }
}
