package MyBank;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

import java.util.ArrayList;
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    public static void main(String[] args) throws Exception {
        // Account account = new Account(2000);
        // Date_details Dob = new Date_details("23","03","2003");
        // Address address = new Address("8/18A,R.N.Tagore Road","Thakurpukur,South 24 Parganas,Kolkata","West Bengal","700063");
        // Customer c1 = new Customer("Chakra",Dob,address,account,"8910344048");
        // System.out.println(c1);
        Main m = new Main();
        while(true){
            System.out.println(
                "\n================:Home:================\n"+
                "1. Open New Account\n"+
                "2. Open Multiple New Account\n"+
                "3. Open Existing Account\n"+
                "0. Exit"
            );
            switch(sc.next().charAt(0)){
                case '1'->{
                    System.out.println("\n**(:Enter Details:)**");
                    m.customers.add(m.newAccount());
                }
                case '2'->{
                    int count;
                    System.out.println("\n**(:Enter count of new accounts:)**");
                    count=sc.nextInt();
                    for(int i=0;i<count;i++){
                        System.out.println("Enter Details of Person: " + (i+1));
                        m.customers.add(m.newAccount());
                    }
                }
                case '3'->m.existingAccount();
                case '0'->System.exit(0);
                default-> System.out.println("Wrong Input");
            }
        }
    }
    private Customer newAccount(){
        Customer C = Customer.getnewCustomer();
        return C;
    }
    private void existingAccount(){
        Scanner S = new Scanner(System.in);
        boolean f=true,f2=false,fa1=false;
        Customer C;
        String Name,Phone,accountnumber,choice;
        System.out.println("\n(:Log In:)\n"+"Enter Account Holder Name");
        Name=S.nextLine();
        System.out.println("Enter Phone Number Connected with your account");
        Phone=S.nextLine();
        for(int i=0;i<this.customers.size();i++){
            if(this.customers.get(i).getphone().equals(Phone)){
                if(this.customers.get(i).getName().equals(Name)){
                    fa1=true;
                    C=this.customers.get(i);
                    while(f){
                        System.out.println(
                            "\n================:Account:================\n" +
                            "1. Get Account Details\n"+
                            "2. Diposite\n"+
                            "3. Withdraw"
                        );
                        if(!C.getNomineestate())System.out.println("4. Add Nominee");
                        else System.out.println("4. Remove Nominee\n5. Get Nominee Details");
                        System.out.println("0. Return");
                        switch(S.next().charAt(0)){
                            case '1'->System.out.println("\n:(Account Details):\n\n"+C);
                            case '2'->{
                                if(C.gethostNom()){
                                    System.out.println(
                                        C.getName()+
                                        C.getAccount()+
                                        "\n\nNominee Account\n"+
                                        C.gethostNominee().getName()+
                                        C.gethostNominee().getAccount()+
                                        "\nEnter the account number in which you want to diposit"
                                    );
                                    S.nextLine();
                                    while(!f2){
                                        accountnumber=S.nextLine();
                                        for(int j=0;j<customers.size();j++){
                                            if(customers.get(j).getAccount().getAccountNumber().equals(accountnumber)){
                                                System.out.println("Enter The Amount");
                                                customers.get(j).getAccount().diposite(sc.nextFloat());
                                                f2=true;
                                            }
                                        }
                                        if(!f2){
                                            System.out.println(
                                                "You entered wrong Account Number"+
                                                "Enter \"R\" for Retry"+
                                                "\"N\" for Cancle"
                                            );
                                            choice=S.nextLine();
                                            if(choice.equals("N")||choice.equals("n"))f2=true;
                                        }
                                    }
                                }
                                else {
                                    System.out.println("Enter The Amount");
                                    C.getAccount().diposite(sc.nextFloat());
                                }
                                f2=false;
                            }
                            case '3'->{
                                if(C.gethostNom()){
                                    System.out.println(
                                        C.getName()+
                                        C.getAccount()+
                                        "\n\nNominee Account\n"+
                                        C.gethostNominee().getName()+
                                        C.gethostNominee().getAccount()+
                                        "\nEnter the account number from which you want to withdraw"
                                    );
                                    S.nextLine();
                                    while(!f2){
                                        accountnumber=S.nextLine();
                                        for(int j=0;j<customers.size();j++){
                                            if(customers.get(j).getAccount().getAccountNumber().equals(accountnumber)){
                                                System.out.println("Enter The Amount");
                                                customers.get(j).getAccount().withdraw(sc.nextFloat());
                                                f2=true;
                                            }
                                        }
                                        if(!f2){
                                            System.out.println(
                                                "You entered wrong Account Number"+
                                                "Enter \"R\" for Retry"+
                                                "\"N\" for Cancle"
                                            );
                                            choice=S.nextLine();
                                            if(choice.equals("N")||choice.equals("n"))f2=true;
                                        }
                                    }
                                }
                                else {
                                    System.out.println("Enter The Amount");
                                    C.getAccount().withdraw(sc.nextFloat());
                                }
                                f2=false;
                            }
                            case '4'->{
                                String name,accno;
                                if(C.getNomineestate())C.removeNominee();
                                else{
                                    System.out.println("\nEnter Nominee Account Details\n"+"Enter The Account Holder Name");
                                    S.nextLine();
                                    name=S.nextLine();
                                    System.out.println("Enter The Account Number");
                                    accno=S.nextLine();
                                    C.setNominee(name,accno,this.customers);
                                }
                            }
                            case '5'->{
                                if(C.getNomineestate())System.out.println("\nNominee Person Details:\n"+C.getNominee());
                                else System.out.println("Wrong input");
                            }
                            case '0'->{
                                f=false;
                                i=this.customers.size();
                            }
                            default->System.out.println("Wrong input");
                        }
                    }
                }
            }
        }
        if(!fa1)System.out.println("Wrong Account Holder Name or,Phone Number");
    }
}
