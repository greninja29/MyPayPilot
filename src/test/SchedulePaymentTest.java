package test;
import model.*;
import repo.*;
import service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Ignore;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SchedulePaymentTest {

    private ScheduledPaymentService scheduledPaymentService;
    private ModifyPaymentService modifyPaymentService;
    private CancelPaymentService cancelPaymentService;
    private ScheduledPaymentRepository repository;

    @BeforeEach
    void setUp() throws Exception {
        repository = new ScheduledPaymentRepository(); 
        scheduledPaymentService = new ScheduledPaymentService(repository);
        modifyPaymentService = new ModifyPaymentService(scheduledPaymentService);
        cancelPaymentService = new CancelPaymentService(scheduledPaymentService);
    }

    // Test for SchedulePaymentService
    @Test
    void testSchedulePayment() throws Exception {
        ScheduledPayment payment = new ScheduledPayment();
        payment.setPayeeName("John Doe");
        payment.setPayeeAddress("123 Elm St");
        payment.setPayeeBankDetails("Bank A, Account 12345");
        payment.setPaymentFrequency("Monthly");
        payment.setScheduledDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-08-09"));
        payment.setAmount(100.00);
        payment.setPaymentMode("Bank Transfer");
        payment.setPayerAccountNumber("A123456789");

        ScheduledPayment createdPayment = scheduledPaymentService.createPayment(payment);

        assertNotNull(createdPayment);
        assertEquals(payment.getScheduledPaymentId(), createdPayment.getScheduledPaymentId());
        assertTrue(createdPayment.getScheduledPaymentId() > 0);
    }

    @Test
    void testGetPayment() {
        ScheduledPayment payment = new ScheduledPayment();
        payment.setPayeeName("Jane Doe");
        payment.setScheduledDate(new Date());
        ScheduledPayment createdPayment = scheduledPaymentService.createPayment(payment);

        Optional<ScheduledPayment> result = scheduledPaymentService.getPayment(createdPayment.getScheduledPaymentId());

        assertTrue(result.isPresent());
        assertEquals(createdPayment.getScheduledPaymentId(), result.get().getScheduledPaymentId());
    }

    
    // Test for ModifyPaymentService
    @Ignore
    @Test
    void testModifyScheduledPayment() throws Exception {
    	ScheduledPayment payment = new ScheduledPayment();
        payment.setPayeeName("aa");
        payment.setPayeeAddress("aa");
        payment.setPayeeBankDetails("aa");
        payment.setPaymentFrequency("aa");
        payment.setScheduledDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-07-01"));
        payment.setAmount(200.00);
        payment.setPaymentMode("aa");
        payment.setPayerAccountNumber("aa");
        ScheduledPayment createdPayment = scheduledPaymentService.createPayment(payment);

        modifyPaymentService.modifyScheduledPayment();

        Optional<ScheduledPayment> modifiedPayment = scheduledPaymentService.getPayment(createdPayment.getScheduledPaymentId());

        System.out.println("Test Modify Scheduled Payment:");
        if (modifiedPayment.isPresent()) {
            ScheduledPayment updatedPayment = modifiedPayment.get();
            System.out.println("Modified details for ID:"+updatedPayment.getScheduledPaymentId());
            assertEquals("aa", updatedPayment.getPayeeName());
            assertEquals("aa", updatedPayment.getPayeeAddress());
            assertEquals("aa", updatedPayment.getPayeeBankDetails());
            assertEquals("aa", updatedPayment.getPaymentFrequency());
            assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("2024-07-01"), updatedPayment.getScheduledDate());
            assertEquals(250.00, updatedPayment.getAmount()); // Assert the updated amount
            assertEquals("aa", updatedPayment.getPaymentMode());
            assertEquals("aa", updatedPayment.getPayerAccountNumber());
        } else {
            fail("Payment not found after modification.");
        }
    }

    // Test for CancelPaymentService
    @Test
    void testCancelScheduledPayment() throws Exception{
    	ScheduledPayment payment = new ScheduledPayment();
        payment.setPayeeName("aa");
        payment.setPayeeAddress("aa");
        payment.setPayeeBankDetails("aa");
        payment.setPaymentFrequency("aa");
        payment.setScheduledDate(new SimpleDateFormat("yyyy-MM-dd").parse("2024-07-01"));
        payment.setAmount(200.00);
        payment.setPaymentMode("aa");
        payment.setPayerAccountNumber("aa");
        ScheduledPayment createdPayment = scheduledPaymentService.createPayment(payment);


        cancelPaymentService.cancelScheduledPayment();

        Optional<ScheduledPayment> result = scheduledPaymentService.getPayment(createdPayment.getScheduledPaymentId());

        System.out.println("Test Cancel Scheduled Payment:");
        if (result.isPresent()) {
            System.out.println("Payment still exists.");
        } else {
            System.out.println("Payment successfully canceled.");
        }
        assertFalse(result.isPresent());
    }
}
