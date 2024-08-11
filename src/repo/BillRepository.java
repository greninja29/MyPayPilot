// package com.nwb.cust.repo;
// import com.nwb.cust.model.*;
package repo;
import model.*;
// import com.nwb.cust.model.Bill;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class BillRepository {
    private List<Bill> bills = new ArrayList<>();
    SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
    
    public BillRepository() {
        // Adding some dummy data with payment statuses and categories
        try {
            bills.add(new Bill("1", "Electricity", "Utilities", sdf.parse("07-25-2024"), 150.75, "Paid"));
            bills.add(new Bill("2", "Water", "Utilities", sdf.parse("08-12-2024"), 75.50, "Pending"));
            bills.add(new Bill("3", "Internet", "Communications", sdf.parse("08-05-2024"), 50.25, "Failed"));
            bills.add(new Bill("4", "Rent", "Housing", sdf.parse("01-08-2024"), 500.00, "Paid"));
            bills.add(new Bill("5", "Gas", "Utilities", sdf.parse("07-28-2024"), 120.00, "Pending"));
            bills.add(new Bill("6", "Gas", "Utilities", sdf.parse("08-10-2024"), 120.00, "Pending"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Bill> getBills() {
        return bills;
    }
}