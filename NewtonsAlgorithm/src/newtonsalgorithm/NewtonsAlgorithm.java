/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtonsalgorithm;
import APClasses.APConsole;
import java.util.InputMismatchException;
/**
 *
 * @author Leulm
 */
public class NewtonsAlgorithm 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        APConsole console = new APConsole("Newton's Algorithm");
        int reps = -1;
        double nums = -1;
        int start = -1;
        int count = 0;
        double guess = 1;
        double sqrt = 0;
        
        console.println("Hello user, give me a number and a number of iterations" + "\n" + "and I will approximate the square root.");
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
               console.println("Go ahead and enter your number of desired iterations");
               reps = console.nextInt();
               if(reps <= 0)
                {
                    console.println("You need to put in a positive whole number");
                    continue;
                }
               start++;
            }
            catch(InputMismatchException e)
            {
                
                console.nextLine();
                console.println("Your number isn't in the format of an whole number.");
            }
        }
        
        for(int j = 0; j <= reps; j++)
        {
            
            if(j == reps)
            {
                sqrt = (guess + nums / guess) / 2;
                guess = sqrt;
                //console.println("\n\n" + "After " + reps + " iteration(s), the approximate square root of " + nums + " is " + sqrt);
                break;
            }
            sqrt = (guess + nums / guess) / 2;
            guess = sqrt;
            count ++;
            console.println("\n" + "After " + count + " iteration(s), the approximate square root of " + nums + " is " + sqrt);
        }
    }
    
}