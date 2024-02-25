package MyBank;
import java.util.ArrayList;
import java.util.Scanner;
public class Customer {
    Scanner sc = new Scanner(System.in);
    private boolean nomCus=false,hostNom=false;
    private Customer Nomineeperson,Nomineehost;
    private String Name,Customer_id,phone;
    private Account account;
    private Address address;
    private Date_details Dob;
    private static Integer r_id = 0;
    private static String Branch = "Behala",Branch_id = "544-";
    public Customer(){
        r_id++;
        Customer_id = new String(Branch_id+r_id.toString());
    }
    public Customer(String Name,Account account,String phone){
        this();
        this.Name = Name;
        this.phone=phone;
        this.account = account;
        this.account.setAccountNumber(Customer_id+phone.substring(4));
    }
    public Customer(String Name,Date_details Dob,Account account,String phone){
        this(Name,account,phone);
        setDOB(Dob);
    }
    public Customer(String Name,Date_details Dob,Address address,Account account,String phone){
        this(Name,Dob,account,phone);
        setAddress(address);
    }
    public void setName(String Name){
        this.Name=Name;
    }
    public void setDOB(Date_details Dob){
        this.Dob = Dob;
    }
    public void setAddress(Address address){
        this.address = address;
    }
    public void setAccount(Account account){
        this.account=account;
    }
    public void setphone(String phone){
        this.phone = phone;
    }
    public void setNominee(String nomineeperson,String nomperacc,ArrayList<Customer> customers){
        String takechoice;
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getAccount().getAccountNumber().equals(nomperacc)){
                if(customers.get(i).getName().equals(nomineeperson)){
                this.Nomineeperson=customers.get(i);
                nomCus=true;
                this.Nomineeperson.setNomhost(true,this);
                System.out.println("Nominee Details added successfully");
                return;
                }
            }
        }
        while(true){
            System.out.println("Their is no Account listed with the \nname: "+nomineeperson+"\nAccount Number: "+nomperacc+"\nYou have to open a new Account in this bank to add Nominee person\ndo you want to create \npress \"Y\" for Yes \n\"R\" for Retry \n\"N\" for Cancle the adding of Nominee process");
            takechoice=sc.nextLine();
            if(takechoice.equals("Y")){
                this.Nomineeperson=getnewCustomer();
                nomCus=true;
                this.Nomineeperson.setNomhost(true,this);
                System.out.println("Nominee Details added successfully");
                return;
            }
            else if(takechoice.equals("R")){
                System.out.println("Enter The Name Again:");
                nomineeperson=sc.nextLine();
                System.out.println("Enter The Account Number Again:");
                nomperacc=sc.nextLine();
                for(int i=0;i<customers.size();i++){
                    if(customers.get(i).getAccount().getAccountNumber().equals(nomperacc)){
                        if(customers.get(i).getName().equals(nomineeperson)){
                        this.Nomineeperson=customers.get(i);
                        nomCus=true;
                        this.Nomineeperson.setNomhost(true,this);
                        System.out.println("Nominee Details added successfully");
                        return;
                        }
                    }
                }
            }
            else if(takechoice.equals("N")) return;
        }
    }
    public void setNomhost(boolean state){
        this.hostNom=state;
    }
    public void setNomhost(Customer customer){
        this.Nomineehost=customer;
    }
    public void setNomhost(boolean state,Customer customer){
        setNomhost(state);
        setNomhost(customer);
    }
    public void removeNominee(){
        this.Nomineeperson.setNomhost(false,null);
        this.Nomineeperson=null;
        this.nomCus=false;
        System.out.println("Nominee removed successfully");
    }
    //return's  true is anyone makes you a nominee or, not
    public boolean gethostNom(){
        return this.hostNom;
    }
    //return's the customer who is your host nominee
    public Customer gethostNominee(){
        return Nomineehost;
    }
    //return's the customer who is nominee of your account
    public Customer getNominee(){
        return Nomineeperson;
    }
    //return's true if you make anyone nominee of your account
    public boolean getNomineestate(){
        return nomCus;
    }
    public Date_details getDOB(){
        return this.Dob;
    }
    public Address getAddress(){
        return this.address;
    }
    public String getphone(){
        return this.phone;
    }
    public Account getAccount(){
        return this.account;
    }
    public String getName(){
        return this.Name;
    }
    public static Customer getnewCustomer(){
        Customer C = new Customer();
        System.out.println("Enter Your Name");
        C.setName(C.sc.nextLine());
        System.out.println("Enter Your Phone Number");
        C.setphone(C.sc.nextLine());
        Account A = Account.getnewAccount(C.Customer_id+C.phone.substring(4));
        // Address D = Address.getnewAddress();
        // Date_details d = Date_details.getnewDob();
        C.setAccount(A);
        // C.setAddress(D);
        // C.setDOB(d);
        return C;
    }
    public String toString(){
        return "Name: " + Name + "\nCustomer ID: " + Customer_id + Dob + account + address;
    }
}
