import Customers.*;
import gasBooking.*;
import gasSupplier.*;

import java.text.SimpleDateFormat;
import java.util.*;

import static gasSupplier.gasAgency.*;

public class Main {
    static int count;
    static int bcount = 0, ccount = 0, dcount = 0, pcount = 0;
    static String dpname;

    public static void cylinderCount(Delivery[] obj) {
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        for (Delivery delivery : obj) {
            count = 0;
            System.out.println("In the month of " + (months[delivery.dt_2.getMonth()]) + " : ");
            System.out.println(" * In " + delivery.area);
            if (delivery.status.equals("D")) {
                count = delivery.numberOfCylinder;
            }
            System.out.println(" - " + count + "cylinders delivered");
        }
        System.out.println("\n");
    }

    public static void checkLateDelivery(Delivery[] obj) {
        String[] months = new String[]{"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
        int[] month = new int[12];
        for (Delivery delivery : obj) {
            if (delivery.status.equals("D") && delivery.amount == 783.75) {
                month[delivery.dt_2.getMonth()] += 1;
            }
        }
        System.out.println("----------------Late Delivery-----------------");
        for (int i = 0; i < 12; i++) {
            if (month[i] != 0) {
                System.out.println(" + In " + month[i] + "there are " + month[i]);
            }
        }
        System.out.println("\n");
    }


    public static void numOfSingleCylinder(Delivery[] obj) {
        System.out.println("-----------------Single Cylinder Holder -------------------");
        for (int i = 0; i < obj.length; i++) {
            System.out.println("* Customer Name " + obj[i].name);
            System.out.println("* Mobile No " + obj[i].mobile);
            System.out.println("* Gas Connection No " + (i + 101));
        }
    }

    public static void deliveryDetails(Delivery[] obj) {
        System.out.println("----------------Delivery Details--------------------");
        System.out.println("enter the name of delivery person: ");
        dpname = new Scanner(System.in).next();
        for (Delivery delivery : obj) {
            if (delivery.status.equals("D") && delivery.delPersonName.equals(dpname))
                System.out.println("* Customer Name " + delivery.name);
            System.out.println(" - " + delivery.street + " , " + delivery.area + " , " + delivery.pincode);
        }
        System.out.println("\n");
    }

    public static void printReport(Delivery[] obj) {
        System.out.println("----------------Delivery Report--------------------");
        for (int i = 0; i < obj.length; i++) {
            if (obj[i].status.equals("D")) {
                dcount++;
            } else if (obj[i].status.equals("B")) {
                bcount++;
            } else if (obj[i].status.equals("C")) {
                ccount++;
            } else if (obj[i].status.equals("P")) {
                pcount++;
            } else {
                System.out.println("Status Invalid");
            }
        }
        System.out.println(" * Booked - " + bcount + " booked");
        System.out.println(" * Delivered - " + dcount + " delivered");
        System.out.println(" * Cancelled - " + ccount + " cancelled");
        System.out.println(" * Pending - " + pcount + " pending");
    }


    public static void printInvoice(Delivery[] obj){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        String invoiceDate = sdf.format(d);
        for(int i = 0;i < obj.length;i++){
            if(obj[i].status.equals("D")){
                System.out.println("---------------------------------------------------");
                System.out.println("---------------------INVOICE-----------------------");
                System.out.println("---------------------------------------------------");
                System.out.println("Gas Agency Code : " + agencyCode + "\t\t\t" + " Date of Invoice :" + invoiceDate);
                System.out.println("Gas Agency Name : " + agencyName + "\t\t\t" + " Agency Phone Number :" + phNumber);
                System.out.println("* Gas Connection No : " + (i + 101)+ "\t\t" + " Customer Name :" + obj[i].name);
                System.out.println("* Booking Date : " + sdf.format(obj[i].dt_1) + "\t\t" + " Customer Mobile No :" + obj[i].mobile);
                System.out.println("---------------------------------------------------");
                System.out.println("Amount : " + obj[i].amount);
                System.out.println("Refund : " + obj[i].refund);
                System.out.println("Total Amount : " + (obj[i].amount - obj[i].refund));
                System.out.println("---------------------------------------------------");
                System.out.println("Delivery Person Name : " + obj[i].delPersonName + "\t\t" + " Delivery Person No :" + obj[i].DelMobileNo);
                System.out.println("Delivery Date : " + sdf.format(obj[i].dt_2));
                System.out.println("---------------------------------------------------");
                System.out.println("\n\n");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("---------------------------------------------------");
        System.out.println("-------------------GAS AGENCY----------------------");
        System.out.println("---------------------------------------------------");
        Delivery[] deliveryObject = new Delivery[5];
        deliveryObject[0] = new Delivery("ABC", "4th Avenue", "Alpha-2", "201308","990230768",1);
        deliveryObject[1] = new Delivery("AB", "5th Avenue", "Alpha-3", "201308","990230768",2);
        deliveryObject[2] = new Delivery("AC", "6th Avenue", "Alpha-4", "201308","990230768",1);
        deliveryObject[3] = new Delivery("BC", "7th Avenue", "Alpha-5", "201308","990230768",2);
        deliveryObject[4] = new Delivery("A", "8th Avenue", "Alpha-6", "201308","990230768",1);

        for (Delivery delivery : deliveryObject) {
            delivery.delPersonDetails();
            delivery.getLastDate();
            delivery.getDates();
            delivery.validate();
            delivery.amountCalc();
            delivery.verifyOtp();
        }
        System.out.println("\n");
        cylinderCount(deliveryObject);
        checkLateDelivery(deliveryObject);
        numOfSingleCylinder(deliveryObject);
        deliveryDetails(deliveryObject);
        printReport(deliveryObject);
        printInvoice(deliveryObject);
    }
}