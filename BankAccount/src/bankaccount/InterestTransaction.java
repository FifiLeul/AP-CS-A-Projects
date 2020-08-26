/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccount;

/**
 *
 * @author mercyougothis
 */
//vawdrey said to make object that makes different types of transactions -- this will save a lot of time from doing that
//have a num transactions -- storing the actual transactions you have
//have a withdrawal
//a deposit
//a interest transaction that does the same thing as investments
public class InterestTransaction
{
    private double principal;
    private int compoundedNumsYearly = 1;
    private double totalOwed;
    private double owedNow;
    private double rate;
    private int years;
    private String deposited;
    private String withdrawn;
    public InterestTransaction(double principal, double rate, int years, int compoundedNumsYearly)
    {
        this.principal = principal;
        this.rate = rate;
        this.years = years;
        this.compoundedNumsYearly = compoundedNumsYearly;
        owedNow = getTotalOwed();
    }
    
    public String getDeposited()
    {
        if(deposited == null)
             return "";
        return deposited;
    }
    public String getWithdrawn()
    {
        if(withdrawn == null)
             return "";
        return withdrawn;
    }
    public double getTotalOwed()
    {
        double principal2 = principal;
        principal2 *= Math.pow((1 + rate/ (double)compoundedNumsYearly), compoundedNumsYearly * years);
         return principal2;
    }
    public double getInterestRate()
    {
        return rate;
    }
    public int getNumYears()
    {
        return years;
    }
    public double getPrincipal()
    {
        return principal;
    }
    public int getCompoundedNumsYearly()
    {
        return compoundedNumsYearly;
    }
    public double getOwedNow()
    {
        return owedNow;
    }
    
    //setters
    public void setInterestRate(double rate)
    {
        this.rate = rate;
    }
    public void setNumYears(int years)
    {
        this.years = years;
    }
    public void setPrincipal(double principal)
    {
        this.principal = principal;
    }
    public void setCompoundedNumsYearly(int compoundedNumsYearly)
    {
        this.compoundedNumsYearly = compoundedNumsYearly;
    }
    public void setOwedNow(double owedNow)
    {
        this.owedNow = owedNow;
    }
    public void pay(double year)
    {
        double origPrinc = principal;
        double principal2 = principal;
        int yearCount = 0;
        double payed = 0;
        for(int j = 0; j< years; j++)
        {
               yearCount++;
               double quartRate = (rate/compoundedNumsYearly);
               for(int k = 0; k < compoundedNumsYearly; k++)
               {
                   principal2 = principal2 * (1 + rate/(double) compoundedNumsYearly * 100);
               }
               payed +=  principal2 - principal;
     
        }
       owedNow = totalOwed - payed;
       if(payed < 0)
       {
           withdrawn += "$" + payed + ", ";
           totalOwed += payed;
       }
       else
           deposited += "$" + payed + ", ";
    }
    public void getPaymentPlan()
    {
       System.out.println("Your interest plan:");
        System.out.println(String.format("%8s%20s%8s%20s\n" ,"year"," intital principal","interest raised/owed", "end principal"));
        double principal1 = principal;
        double principal2 = principal;
        double intEarned = 0;
        int yearCount = 0;
        double payed = 0;
        for(int j = 0; j< 1; j++)
        {
               yearCount++;
               double quartRate = (rate/compoundedNumsYearly);
               for(int k = 0; k < compoundedNumsYearly; k++)
               {
                   principal2 = principal2 * (1 + rate/(double) compoundedNumsYearly * 100);
               }
               intEarned =  principal2 - principal1;
               System.out.println(String.format("$%-17.2f",intEarned));
               System.out.println(String.format("$%-20.2f", principal1));
               System.out.println(String.format("%-11.2s", yearCount));
               System.out.println(String.format("%-5.2f", principal2));

               System.out.println(""); 
        }
        for(int j = 0; j< years - 1; j++)
        {
               yearCount++;
               principal1 = principal1;
               double quartRate = (rate/compoundedNumsYearly);
               for(int k = 0; k < compoundedNumsYearly; k++)
               {
                   principal2 = principal2 * (1 + rate/(double) compoundedNumsYearly * 100);
                   
               }
               intEarned =  principal2 - principal1;
               System.out.println(String.format("$%-17.2f",intEarned));
               System.out.println(String.format("$%-20.2f", principal1));
               System.out.println(String.format("%-11.2s", yearCount));
               System.out.println(String.format("%-5.2f", principal2));

               System.out.println(""); 
        }
    }
    
    public String toString()
    {
        String str = "Principal: " + principal + "\n"
                    + "Rate: " + rate + "\n"
                    + "# of times compounded: " + compoundedNumsYearly +"\n"
                    + "Years: " + years + "\n"
                    + "Total Owed: $" + String.format("%.2f",getTotalOwed()) + "\n"
                    + "Deposited: " + getDeposited() + "\n"
                    + "Withdrawn: " + getWithdrawn() + "\n"
                    + "Currently Owed: $" + String.format("%.2f", owedNow) + "\n";
        return str;
    }
    
}
