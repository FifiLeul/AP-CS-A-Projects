/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avandgreater;

/**
 *
 * @author mercyougothis
 */
import APClasses.APConsole;
import java.util.InputMismatchException;
public class AvAndGreater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       APConsole console = new APConsole("AvAndGreater");
       String aboveAv = "";
       double nums[] = new double[10];
       int count = 0;
       
       console.println("give me 10 #s and i will give you the average\nand all the numbers greater");
       
       while(count != 10)
        {
           try
            {
                console.println("Enter your #");
                nums[count] = console.nextDouble();
                count++;
            }
             catch(InputMismatchException e)
            {
                
                console.nextLine();
                console.println("That's not a number");
            }
        }

       for(int j = 0; j < 10; j++)
       {
           if(nums[j] > getAverage(nums) && !aboveAv.contains(nums[j] + ""))
           {
                aboveAv += nums[j] + ", ";
                
           }
       }
       if(aboveAv.length() >= 2)
       {
           aboveAv = aboveAv.substring(0,aboveAv.length()-2);
       }
       console.println("     Average: " + getAverage(nums));
       console.println("     Numbers Greater: " + aboveAv);
    }
    public static double getAverage(double[] nums)
    {
        double av = 0;
        double count = 0;
        for(int j = 0 ; j< nums.length;j++)
        {
            av += nums[j];
            count++;
        }
        av/= (double) count;
        return av;
    }
    
}
