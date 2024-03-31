package gasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking{
    public String delPersonName;

    int customerOtp;

    public Delivery(String name, String street, String area, String pincode, String mobile, int numberOfCylinder) {
        super(name, street, area, pincode, mobile, numberOfCylinder);
    }

    public void amountCalc() {
        long dayDiff = dt_2.getTime() - dt_2.getTime();
        long newDiff = TimeUnit.DAYS.convert(dayDiff, TimeUnit.MILLISECONDS);

        if (newDiff > 7) {
            refund = 41.25;
            amount = amount - refund;
        }
    }

        public void verifyOtp(){
            if(status.equals("B")){
                System.out.println("Enter OTP: ");
                customerOtp = new Scanner(System.in).nextInt();

                if(customerOtp != otp){
                    status = "C";
                } else{
                    status = "D";
                }
            } else{
                System.out.println("no booking found!!");
            }
        }

        public void delPersonDetails(){
            System.out.println("\n Enter the delivery person name : ");
            delPersonName = new Scanner(System.in).nextLine();
        }
}
