package MyBank;
import java.util.Scanner;
public class Date_details {
    private static Scanner sc = new Scanner(System.in);
    private String date,month,year;
    public Date_details(){
        this.year="";
        this.month="";
        this.date="";
    }
    public Date_details(String date,String month,String year){
        if(Integer.parseInt(date)>31){
            System.out.println("Invalid date");
            setDate(date);
        }
        else this.date=date;
        if(Integer.parseInt(month)>12){
            System.out.println("Invalid month");
            setMonth(month);
        }
        else this.month=month;
        this.year=year;
    }
    public Date_details(Date_details refDob){
        this.year=refDob.year;
        this.month=refDob.month;
        this.date=refDob.date;
    }
    public void setYear(String year){
        this.year=year;    
    }
    public void setMonth(String month){
        if(Integer.parseInt(month)<=12)
            this.month=month;
        else do{
            System.out.println("Please enter a valid month number");
            this.month=sc.nextLine();
        }while(Integer.parseInt(this.month)>12);
    }
    public void setDate(String date){
        if(Integer.parseInt(date)<=31)
            this.date=date;
        else do{
            System.out.println("Please enter a valid date");
            this.date=sc.nextLine();
        }while(Integer.parseInt(this.date)>31);
    }
    public String getYear(){
        return this.year;    
    }
    public String getMonth(){
        return this.month;
    }
    public String getDate(){
        return this.date;
    }
    public String toString(){
        return "\nDOB(DD/MM/YY): "+date+"/"+month+"/"+year;
    }
    public static Date_details getnewDob() {
        Date_details D =new Date_details();
        System.out.println("Enter Birth Date");
        D.setDate(sc.nextLine());
        System.out.println("Enter Birth Month");
        D.setMonth(sc.nextLine());
        System.out.println("Enter Birth Year");
        D.setYear(sc.nextLine());
        return D;
    }
}
