/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerpurchase;

/**
 *
 * @author mercyougothis
 */
import APClasses.APConsole;
import java.util.InputMismatchException;
public class ComputerPurchase 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("Computer Purchase");
        double price = 0;
        double interest = 0;
        double monthlyPayment = 0;
        double interestDue = 0;
        double totalOwedMonthly = 0;
        double balanceOwedBefore = 0;
        double balanceOwedAfter = 0;
        double totalPayed = 0;
        int monthCount = 1;
        
        int start = 0;
        console.println("Hey user, give me your price and I will give you the payment plan");
        while(start != 1)
        {
            try
            {
                price = console.nextDouble();
                while(price < 1)
                {
                    console.println("enter in a positive (non zero) number");
                    price = console.nextDouble();
                }
                start = 1;
            }
            catch(InputMismatchException e)
            {
                console.nextLine();
                console.println("Give me a value please");

            }
        }
        interest = (price * 12) /100;
        price -= (price * 10)/100;
        monthlyPayment = (price *5)/100;
        
        console.println("Month       Owed Before     Interest Owed    Principal Owed    Total Payment    Owed After");
        
        while(price > totalPayed)
        {
            balanceOwedBefore = price - totalPayed;
            interestDue = balanceOwedBefore * (double)1/12;
            totalOwedMonthly = monthlyPayment + interestDue;
            totalPayed += totalOwedMonthly;
            balanceOwedAfter = price - totalPayed;
            String monthStr = monthCount + "";
            console.printf("%3s         $%6.2f         $%6.2f          $%6.2f           $%6.2f          $%6.2f\n", monthStr, balanceOwedBefore, interestDue, monthlyPayment, totalOwedMonthly, balanceOwedAfter);
            monthCount++;
        }
        
        
    }
    /*public double getCompoundedInterest(double principal, double rate, double yearCount)
    {
        double compounded = principal * Math.pow(1 + rate/12, 12 * yearCount) - principal;
        return compounded;
    }*/
    
}
