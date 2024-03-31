package Customers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GasConnection extends Customer {

    public int numberOfCylinder;
    String date;
    static int connectionNumber = 100;
    {
        connectionNumber += 1;
    }
    public Date lastDate = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public GasConnection(String name, String street, String area, String pincode, String mobile, int numberOfCylinder) {
        super(name, street, area, pincode, mobile);
        this.numberOfCylinder = numberOfCylinder;
    }

    public void getLastDate() {
        System.out.println("Enter the last Date");
        date = new Scanner(System.in).nextLine();
        try {
            lastDate = dateFormat.parse(date);
        } catch (ParseException e) {
            System.out.println("Error in last Date: " + e);
        }
    }
}
