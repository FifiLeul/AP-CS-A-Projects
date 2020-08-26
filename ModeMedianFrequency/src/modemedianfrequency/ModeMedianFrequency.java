/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modemedianfrequency;

/**
 *
 * @author mercyougothis
 */
import APClasses.APConsole;
import java.util.Arrays;
import java.util.InputMismatchException;
public class ModeMedianFrequency
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("ModeMedianFrequency");
        String numStr = "";
        String freqStr[] = new String[10];
        String finalStr = "";
        double nums[] = new double[10];
        double freq[] = new double[10];
        double greatestFreq[] = new double[10];
        int count = 0;
        
        console.println("Give me 10 #s and I'll give you the mode");
        while(count != 10)
        {
           try
            {
                console.println("Enter your #");
                nums[count] = console.nextDouble();
                numStr = nums[count] + ", ";
                count++;
            }
             catch(InputMismatchException e)
            {
                
                console.nextLine();
                console.println("That's not a number");
            }
        }
        
        
        getFrequency(nums, freq, freqStr, numStr);
        finalStr = getMode(freq, freqStr);
        if(finalStr.length() >= 2)
       {
           finalStr = finalStr.substring(0,finalStr.length()-2);
       }
        
        console.println("     Mode(s): " + finalStr);
       
      // console.printf("Number      Frequency\n");
      
          for(int j = 0; j < freqStr.length;j++)
          {
              System.out.println(freqStr[j] + " freq: " + freq[j]);
          }
        
    } 
    public static String getMode(double[] freq, String freqStr[])
    {
        String finalStr = "";
        double count2 = 0;
        for(int j = 0; j < freq.length; j++)
        {
           
           if(freq[j] > count2)
           {
               count2 = freq[j];
           }
        }
        for(int j = 0; j < freq.length; j++)
        {
            if(freq[j] == count2)
            {
                finalStr += freqStr[j] + ", " ;
            }
        }
        return finalStr;
    }
    public static double getMedian(double nums[])
    {
        Arrays.sort(nums);
       double median = (nums[5]  + nums[4])/ (double)2; 
       return median;
    }
    public static void getFrequency(double[] nums, double[] freq, String[] freqStr, String numStr)
    {
        int count = 0;
        for(int j = 0; j < nums.length - 1;j++)
        {
           count = 1;
            for(int k = j + 1; k < nums.length;k++)
            {
                if(nums[j] == nums[k] && !numStr.contains(nums[j] + ""))
                {
                    count++;
                }
            }
            numStr += nums[j] + "";
            freq[j] = count;
            freqStr[j] = nums[j] + "";
            
        }
        String last = nums[9] + "";
       if(numStr.contains(last))
       {
          System.out.println("");
       }
       else
           freq[nums.length] = 1;
    }
    
    
}
