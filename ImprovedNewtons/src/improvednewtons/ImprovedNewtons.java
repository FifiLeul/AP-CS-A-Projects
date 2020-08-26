/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package improvednewtons;
import APClasses.APConsole;
import java.util.InputMismatchException;
/**
/**
 *
 * @author Leulm
 */
public class ImprovedNewtons 
{
    
    /**
     * @param args the command line arguments
     */
     public static void main(String[] args)
    {
        APConsole console = new APConsole("Improved Newton's Algorithm");
        int reps = -1;
        double nums = -1;
        int start = -1;
        double guess = 1;
        double sqrt = 0;
        int acc = 0;
        
        console.println("Hello user, give me a number and decimal points of accuracy" + "\n" + "and I will approximate the square root.");
        while(start == -1)
        {
             try
            {
                console.println("Enter your number");
                nums = console.nextDouble();
                if(nums <= 0)
                {
                    console.println("You need to put in a positive number");
                    continue;
                }
                start++;
            }
             catch(InputMismatchException e)
            {
                
                console.nextLine();
                console.println("Your number isn't in the format of an number.");
            }
        }
        start = -1;
        while(start == -1)
        {
             try
            {
                console.println("Enter the number of decimal points of accuracy desired");
                acc = console.nextInt();
                if(acc < 0)
                {
                    console.println("You need to put in a positive number");
                    continue;
                }
                //acc = acc / 100;
                start++;
            }
             catch(InputMismatchException e)
            {
                
                console.nextLine();
                console.println("Your number isn't in the format of an integer.");
            }
        }
        start = -1;
        
        
        
        console.println("");
        
        String str = sqrt + "";
        String str2 = "";
        String[] storeSqrt = new String[10000000];
        int count = 1;
        /*for(int count = 0; count < 10; count++)
        {
            sqrt = (guess + nums / guess) / 2;
            guess = sqrt;
        }
        */
        double shifter = 1;
        for(int j = 0; j < acc;j++)
        {
            shifter *= 10;
        }
        double storeSqr[] = new double[7]; 
        while(! str.equals(str2))
        {
            double modSqrt = Math.round(sqrt);
            modSqrt = shifter * sqrt;
            sqrt = (guess + nums / guess) / 2;
            guess = sqrt;
            double modSqrt2 = Math.round(sqrt);
            modSqrt2 = shifter * sqrt;
            
            str = modSqrt + "";
            str = str.substring(0, str.indexOf("."));
            
            str2 = modSqrt2 + "";
            str2 = str2.substring(0, str2.indexOf("."));
            System.out.println("Count: "+ count + "\nBefore: " + modSqrt + "\n" + "After: " + modSqrt2 + "\n");
            if(str.equals(str2))
            {
                break;
            }
            console.printf("Approximation " + count + " : %." + acc + "f\n", sqrt);
            count++;
        }count--;
        
        console.printf("\nThe approximate square root of "+ nums + " is : %." + acc + "f after " + count + " iterations", sqrt );

            
            
           
//            console.println("The approximate square root after " + i + " iterations is " + guess + ".");
        
        
    }
     
}   