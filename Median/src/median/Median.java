/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package median;

/**
 *
 * @author mercyougothis
 */
import APClasses.APConsole;
import java.util.Arrays;
import java.util.InputMismatchException;
public class Median
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("Median");
        double nums[] = new double[10];
        double greatest = 0;
        int count = 0;
  
        console.println("Give me 10 #s and I'll give you the median");
        while(count != 10)
        {
           try
            {
                console.println("Enter your #");
                nums[count] = console.nextDouble();
                //numStr = nums[count] + ", ";
                count++;
            }
             catch(InputMismatchException e)
            {
                
                console.nextLine();
                console.println("That's not a number");
            }
        }
        
       Arrays.sort(nums);
       //double median = (( nums[nums.length/2] +  nums[(nums.length/2) + 1] ) / (double) 2) - (double)1;
       System.out.println(nums[5] + "");
       System.out.println(nums[6] + "");
       double median = (nums[5]  + nums[4])/ (double)2; 
       console.println("     Median: " + median);
    }
    
}
