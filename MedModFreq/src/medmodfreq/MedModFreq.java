
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medmodfreq;
import APClasses.APConsole;
import java.util.InputMismatchException;
/**
 *
 * @author ft196725
 */
public class MedModFreq
{
    public static void main(String[] args)
    {
        APConsole console = new APConsole("Median Mode and Frequency");
        double[] elevNums = new double[10];
        int[] paralellNums = new int[]{1,1,1,1,1,1,1,1,1,1,1};
        int count = 0;
        console.println("Give me 10 numbers and I will give you the median, mode, and frequency for the set");
        
      for(int j = 0; j < 10;j++)
        {
           console.println("Enter a number");
           try
           {
               elevNums[j] = console.nextDouble();
           }
           catch(InputMismatchException p)
           {
              
               console.nextLine();
               console.println("You need to put only numbers in. Try again");
               continue;
           }
        }
           count++;
           console.println("\n" + "your median is: " + getMedian(elevNums));
           
           
      console.println("\n Number      Frequency");   
      paralellNums = getFrequency(paralellNums, elevNums);
      for(int j = 0; j <= 9; j++ )
      {
        if(paralellNums[j] != 0)
        {
          console.printf("%5s", elevNums[j]);  
          console.printf("%10s\n",paralellNums[j]);          
        }
      }
      console.println(getMode(paralellNums, elevNums));
    }
    public static double getMedian(double[] elevNums)
    {
        String median = "";
        int count = 0;
        String med = "";
        
       for(int j = 0; j <= 9; j++)
       {
         count = 0;
         int countNeg = 0;
         med = "";
         double checkNums = 10.0/2;
         double medianDouble = 0;
         
          for(int e = 0; e < 10; e++)
          {  
            if(elevNums[j] >= elevNums[e])
            {
                 count++;
            }
             if(elevNums[j] <= elevNums[e] )
             {
                 countNeg++;
             }
             if(count >= checkNums && countNeg >= checkNums)
             {
                med = elevNums[j] + ", ";
                if(median.contains(med))
                {
                  median = median.replace(med, "");
                }
                median += elevNums[j] + ", ";
                medianDouble = elevNums[j];
                
                //return "your median is: " + median;
                return medianDouble;
             }   
           } 
        }      
         return 0;
    }
    public static String getMode(int[] paralellNums, double[] elevNums)
    {
        String modeStr = "";
        int count = 0;
        for(int  i = 0; i <= 9; i++)
        {
          if(paralellNums[i] > count)
          {
            count = paralellNums[i];
          }
        }
      for(int i = 0; i <= 9; i++)
      {  
        if(paralellNums[i] == count)
        {
            modeStr +=elevNums[i] + ", " ;
        }  
 
      }
      return "Your mode(s) is/are: " + modeStr;
        
    }
    public static int[] getFrequency(int[] paralellNums, double[] elevNums)
    {
        int count = 0;
        for(int j = 0; j <= 9;j++)
      {
          for(int i = j+1; i <= 9; i++)
          {
            if(paralellNums[j] != 0)
            {
              if(elevNums[i] == elevNums[j])
              {
                 paralellNums[j]++;
                 paralellNums[i] = 0;
                 count++;
              }
            }
          }
         
      }
        return paralellNums;
    }
}

