/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

import java.util.ArrayList;

/**
 *
 * @author mercyougothis
 */
public class Sorts 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int[] test1 = new int[]{3,4,5,2};
        int[] test2 = new int[]{4, 3, 2, 1};
        int[] test3 = new int[]{1, 3, 2,4, 90,1, 22,4,5,132,532, 6};
        System.out.println("test1: " + print(insertion(test1)) + "\n" +   // result should be: 2, 3, 4, 5
                           "test2: " + print(insertion(test2)) + "\n" + // result should be: 1, 2, 3, 4
                           "test3: " + print(insertion(test3)) + "\n");// result should be: 1, 1, 2, 3, 4, 4, 5, 6, 90, 132, 532
    }
    public static String print(int[] sorted)
    {
        String result  = "";
        for(int j = 0 ; j < sorted.length; j++)
            if(j == sorted.length - 1)
                result += sorted[j]+ ", ";
            else
                result += sorted[j] + ", ";
       return result;
    }
    public static String print(ArrayList<Integer> sorted)
    {
        String result  = "";
        for(int j = 0 ; j < sorted.size(); j++)
            if(j == sorted.size() - 1)
                result += sorted.get(j)+ ", ";
            else
                result += sorted.get(j) + ", ";
       return result;
    }
    public static int[] selection(int comp[]) //big o is quadratic, times by length of arrays in for loop, ang get comp.length^2
    {
        int least = 0;
        //System.out.println(print(comp));
        for(int j = 0 ; j < comp.length-1; j++)
        {
            least = j;
            for(int i = j+1; i < comp.length; i++)
            {
                if(comp[least] > comp[i])
                    least = i; 
            }
            int temp = comp[j];
            comp[j] = comp[least];
            comp[least] = temp; 
            //System.out.println("\t" + print(comp));
        }
        return comp;
    }
    public static int[] bubble(int comp[]) // quadratic
    {
        for(int j = 0 ; j < comp.length; j++)
        {
            for(int i = j; i < comp.length; i++)
            {
                if(comp[j] > comp[i])
                {
                   int temp = comp[i];
                   comp[i] = comp[j];
                   comp[j] = temp;
                }
            }       
        }
        return comp;
    }
    public static ArrayList<Integer> insertion(int comp[])
    {
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        
        for(int j = 0; j< comp.length; j ++)
        {
            int greatestIndex = 0;
          for(int i = 0; i < sorted.size(); i++)
          {
              for(int p = i; p < sorted.size(); p ++)
              {
                  if(sorted.get(p) < sorted.get(i))
                  {
                      int temp = sorted.get(p);
                      sorted.set(p, sorted.get(i));
                      sorted.set(i, temp);
                      System.out.println(print(sorted));
                  }
              }
          }
        }
        
         return sorted;
    }
    
}
