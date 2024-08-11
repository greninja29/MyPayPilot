
package test;
import model.*;
import repo.*;
import service.*;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class PaymentManagerTest {

    private PaymentManager manager;
    private PaymentsRepository paymentsRepository;
    private BillRepository billRepository;
    private SimpleDateFormat sdf;

    @BeforeEach
    public void setUp() throws Exception {
        paymentsRepository = new PaymentsRepository();
        billRepository = new BillRepository();
        manager = new PaymentManager(paymentsRepository, billRepository);
        sdf = new SimpleDateFormat("MM-dd-yyyy");
    }

    @Test
    public void testGetPaymentHistory() throws Exception {
        Date startDate = sdf.parse("01-01-2024");
        Date endDate = sdf.parse("12-31-2024");
        String billName = "Electricity";

        List<Payments> paymentHistory = manager.getPaymentHistory(billName, startDate, endDate);

        assertNotNull(paymentHistory);
        assertFalse(paymentHistory.isEmpty());
        for (Payments payment : paymentHistory) {
            assertEquals(billName, payment.getName());
            assertTrue(!payment.getPaymentDate().before(startDate) && !payment.getPaymentDate().after(endDate));
        }
    }

    @Test
    public void testGetPaymentProgress() {
        String billName = "Electricity";

        List<Payments> paymentProgress = manager.getPaymentProgress(billName);

        assertNotNull(paymentProgress);
        assertFalse(paymentProgress.isEmpty());
        for (Payments payment : paymentProgress) {
            assertEquals(billName, payment.getName());
        }
    }

    @Test
    public void testPaymentsOverview() throws Exception {
        Date fromDate = sdf.parse("07-01-2024");
        Date toDate = sdf.parse("08-31-2024");
        String category = "Utilities";

        List<Bill> billsInRange = manager.paymentsOverview(category, fromDate, toDate);

        assertNotNull(billsInRange);
        assertFalse(billsInRange.isEmpty());
        for (Bill bill : billsInRange) {
            assertEquals(category, bill.getBillCategory());
            assertTrue(!bill.getDueDate().before(fromDate) && !bill.getDueDate().after(toDate));
        }
    }

    @Test
    public void testEmptyPaymentHistory() throws Exception {
        Date startDate = sdf.parse("01-01-2023");
        Date endDate = sdf.parse("12-31-2023");
        String billName = "Nonexistent";

        List<Payments> paymentHistory = manager.getPaymentHistory(billName, startDate, endDate);

        assertNotNull(paymentHistory);
        assertTrue(paymentHistory.isEmpty());
    }

    @Test
    public void testEmptyPaymentProgress() {
        String billName = "Nonexistent";

        List<Payments> paymentProgress = manager.getPaymentProgress(billName);

        assertNotNull(paymentProgress);
        assertTrue(paymentProgress.isEmpty());
    }

    @Test
    public void testEmptyPaymentsOverview() throws Exception {
        Date fromDate = sdf.parse("01-01-2025");
        Date toDate = sdf.parse("12-31-2025");
        String category = "Nonexistent";

        List<Bill> billsInRange = manager.paymentsOverview(category, fromDate, toDate);

        assertNotNull(billsInRange);
        assertTrue(billsInRange.isEmpty());
    }
}

