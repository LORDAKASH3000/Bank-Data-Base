package MyBank;
import java.util.Scanner;
public class Address {
    private static Scanner sc = new Scanner(System.in);    
    private String streetAddress,city,state,zipcode;
    public Address(){
        streetAddress="";
        city="";
        state="";
        zipcode="";
    }
    public Address(String streetAddress,String city,String state,String zipcode){
        this.streetAddress=streetAddress;
        this.city=city;
        this.state=state;
        this.zipcode=zipcode;
    }
    public Address(Address refAdd){
        this.streetAddress=refAdd.streetAddress;
        this.city=refAdd.city;
        this.state=refAdd.state;
        this.zipcode=refAdd.zipcode;
    }
    public void setStreetAddress(String streetAddress){
        this.streetAddress=streetAddress;    
    }
    public void setCity(String city){
        this.city=city;
    }
    public void setState(String state){
        this.state=state;
    }
    public void setZipcode(String zipcode){
        this.zipcode=zipcode;
    }
    public String getStreetAddress(){
        return this.streetAddress;    
    }
    public String getCity(){
        return this.city;
    }
    public String getState(){
        return this.state;
    }
    public String getZipcode(){
        return this.zipcode;
    }
    public String toString(){
        return "\n\nCustomer Address:-\n\t"+streetAddress+"\n\t"+city+"\n\t"+state+" - "+zipcode;
    }
    public static Address getnewAddress() {
        Address A = new Address();
        System.out.println("Enter Customer Street Address");
        A.setStreetAddress(sc.nextLine());
        System.out.println("Enter Customer City");
        A.setCity(sc.nextLine());
        System.out.println("Enter Customer State");
        A.setState(sc.nextLine());
        System.out.println("Enter Customer Zipcode");
        A.setZipcode(sc.nextLine());
        return A;
    }
}
