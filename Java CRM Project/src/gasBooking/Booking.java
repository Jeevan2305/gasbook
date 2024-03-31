package gasBooking;

import Customers.*;
import java.util.*;
import java.text.*;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection {

    public double otp = 5678, amount = 825.0, refund = 0;

    public String dt, delDate, Status, DelMobileNo = "7838048546", status;

    public Date dt_1, dt_2;

    public Booking(String name, String street, String area, String pincode, String mobile, int numberOfCylinder) {
        super(name, street, area, pincode, mobile, numberOfCylinder);
    }

    public void getDates() {
        System.out.println("Enter the booking Date");
        dt = new Scanner(System.in).next();
        dt_1 = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            dt_1 = dateFormat.parse(dt);
        } catch (ParseException e) {
            System.out.println("Error in getDates Function: " + e);
        }

        // delivery details
        System.out.println("Enter delivery dates: ");
        delDate = new Scanner(System.in).next();
        try {
            dt_2 = dateFormat.parse(delDate);
        } catch (ParseException e) {
            System.out.println("Error parsing Second Date: " + e);
        }

        // find the difference between two dates
        try {
            long difference = dt_2.getTime() - dt_1.getTime();
            long newDifference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
            if (newDifference > 7) {
                status = "P";
            }
        } catch (Exception e) {
            System.out.println("Error while finding difference : " + e);
        }
    }

    public void validate() {
        // get the difference between two dates
        long elapsedms = dt_1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(elapsedms, TimeUnit.MILLISECONDS);

        System.out.println("difference between two dates is : " + diff);
        if (numberOfCylinder == 1) {
            // for a single cylinder
            if (diff < 30) {
                System.out.println("Booking cannot be done");
                // numberOfCyliners = 0;
                status = "C";
            } else {
                // System.out.println("status: booked");
                status = "B";
                lastDate = dt_1;
            }
        } else if (numberOfCylinder == 2) {
            if (diff < 50) {
                System.out.println("booking cannot be done");
                // numberOfCyliners = 0;
                status = "C";
            } else {
                // System.out.println("status: booked");
                status = "B";
                lastDate = dt_1;
            }
        }
    }
}
