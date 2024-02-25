package MyBank;
import java.util.Scanner;
public class Account {
    private String accountNumber=null;
    private float Balance=0;
    private static Scanner sc = new Scanner(System.in);
    public Account(float Balance){
        if(Balance>=1000)this.Balance=Balance;
        else setBalanceNewAccount();
    }
    public void setBalanceNewAccount(){
        System.out.println("Minimum Account Opening Balance is -> 1000Rs.");
        do{
            this.Balance=sc.nextFloat();
        }while(this.Balance<1000);
    }
    public void diposite(float amount){
        System.out.println("Rs" + amount + " Diposite Successful");
        this.Balance+=amount;
    }
    public void withdraw(float amount){
        if(Balance-amount<1000)System.out.println("Withdraw Unsuccessful" + "\nYou can withdraw only : "+(amount-Balance));
        else {
            System.out.println("Rs" + amount + " Withdraw Successful");
            this.Balance-=amount;
        }
    }
    public float getBalance(){
        return this.Balance;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber=accountNumber;
    }
    public String getAccountNumber() {
        return this.accountNumber;
    }
    public String toString(){
        return "\n\nAccount Details:-"+"\n\tAccount Number: " + accountNumber + "\n\tBalance: " + Balance;
    }
    public static Account getnewAccount(String accountNumber) {
        System.out.println("Enter Account Opening Balance");
        Account A = new Account(sc.nextFloat());
        A.setAccountNumber(accountNumber);
        return A;
    }
}
