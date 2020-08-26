/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myarrays;
/**
 *
 * @author mercyougothis
 */
public class MyArrays 
{
    public MyArrays()
    {
        
    }
    public static int linearSearch(Comparable[] arr, Comparable desired)
    {
        for(int j = 0; j < arr.length; j++)
            if(arr[j].compareTo(desired) == 0)
                return j;
        return -1;
    }
    public static int binarySearch(Comparable[] arr, Comparable desired)  
    {
        sort(arr);
        int left = 0;
        int right = arr.length - 1;
         while(left <= right)
         {
             int midpoint = (left + right) / 2;
             if(arr[midpoint].compareTo(desired) == 0)
                 return midpoint;
             else if(arr[midpoint].compareTo(desired) < 0)
                 left = midpoint + 1;
             else
                 right = midpoint - 1;
         }
         return -1;
    }
    public static void sort(Comparable[] arr)
    {
        int n = arr.length;
        
        for(int i = 1; i < n; i ++)
        {
            //System.out.println(print(arr));
            Comparable greatest = arr[0];
            int greatestIndex = 0;
            for(int j = 1; j <= n - i; j++)
            {
                if(arr[j].compareTo(greatest) > 0)
                {
                    greatest = arr[j];
                    greatestIndex = j;
                }
            }
            //System.out.println(print(arr));
            arr[greatestIndex] = arr[n - i];
            arr[n - i] = greatest;
        }
      
    }
}
