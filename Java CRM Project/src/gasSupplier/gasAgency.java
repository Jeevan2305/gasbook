package gasSupplier;

public interface gasAgency {
    public String agencyName = "Bharat Gas";
    public int agencyCode = 1234;
    public int phNumber = 55783;

    default void show(){
        System.out.println("The agency name is: " + agencyName);
        System.out.println("The agency code is: " + agencyCode);
        System.out.println("The agency phone number is: " + phNumber);
    }
}
