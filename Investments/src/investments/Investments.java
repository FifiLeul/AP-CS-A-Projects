/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package investments;
import java.util.*;
import APClasses.APConsole;

/**
 *
 * @author ft196725
 */
public class Investments 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("Investments");
        String strRate = "";
        String strPrincipal = "";
        String strYears = "";
        String yearCol = "year";
        String princip = " intital principal";
        String interest = "interest raised";
        String endPrincip = "end principal";
        double principal1 = 0;
        double principal2 = 0;
        double rate = 0;
        double intEarned = 0;
        double years = 0;
        int yearCount = 0;
        int start = 1;
        
        console.println("Enter the principal investment");
        while(start == 1)
        {
            strPrincipal = console.nextLine();
           
             if(strPrincipal.contains("-"))
             {
                    console.println("You need to enter a positive number. Try again");
                    continue;
             }
              if(strPrincipal.contains(","))
             {
                  strPrincipal = strPrincipal.replace(",", "");
             }
             if(strPrincipal.contains("$"))
            {
                strPrincipal = strPrincipal.replace("$", "");
               
            }
             
            try
            {
                 principal1 = Double.parseDouble(strPrincipal);
                 start--;

            }
           catch(NumberFormatException g)
           {

               console.println("You need to put only numbers in. Try again");
               continue;

           }

        }
        start = 1;
        console.println("Enter the interest rate");
        
        while(start == 1)
        {
             strRate = console.nextLine();
                if(strRate.contains("-"))
                {
                    
                    console.println("You can't have negative interest. try again.");
                   
                    continue;
                }

             if(strRate.contains("%"))
             {
                strRate = strRate.replace("%", "");
              
             }
            try
            {
                 rate = Double.parseDouble(strRate);
                 start--;
             }
           catch(NumberFormatException g)
           {

               console.println("You need to put only numbers in. Try again");
               continue;

           }
        
        }
         start++;
         console.println("Enter the number of years");
        while(start == 1)
        {
            strYears = console.nextLine();
            if(strYears.contains("-") || strYears.equals("0"))
            {
                console.println("You need to enter a positive non-zero number. Try again");
                continue;
            }
            if(strYears.contains("years"))
            {
                  strYears = strYears.replace("years", "");
            }
            if(strYears.contains("yrs"))
            {
                  strYears = strYears.replace("yrs", "");
            }
            
            try
            {
                 years = Double.parseDouble(strYears);
                 start--;
                
            }
            catch(InputMismatchException e)
            {
                console.println("Enter a postive whole number.");
                continue;
            }
                   
        }
        console.printf("%8s%20s%8s%20s\n", interest ,princip ,yearCol,endPrincip);
        double origPrinc = principal1;
        principal2 = principal1;
        for(int j = 0; j< 1; j++)
        {
               yearCount++;
               double quartRate = (rate/4);
               for(int k = 0; k < 4; k++)
               {
                   principal2 = principal2 * (1 + rate/(double) 400);
               }
               intEarned =  principal2 - principal1;
               console.printf("$%-17.2f",intEarned);
               console.printf("$%-20.2f", principal1);
               console.printf("%-11.2s", yearCount);
               console.printf("%-5.2f", principal2);

               console.println(""); 
        }
        for(int j = 0; j< years - 1; j++)
        {
               yearCount++;
               principal1 = principal2;
               double quartRate = (rate/4);
               for(int k = 0; k < 4; k++)
               {
                   principal2 = principal2 * (1 + rate/(double) 400);
                   
               }
               intEarned =  principal2 - principal1;
               console.printf("$%-17.2f",intEarned);
               console.printf("$%-20.2f", principal1);
               console.printf("%-11.2s", yearCount);
               console.printf("%-5.2f", principal2);

               console.println(""); 
        }
    }
    
}
