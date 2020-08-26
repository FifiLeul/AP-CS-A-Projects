/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appractice;

/**
 *
 * @author mercyougothis
 */
public class APPractice
{
    public static void main(String[] args)
    {
        //sorts:
        int[] arr = new int[]{3,1,4,2,5,0};
        int[] arr2 = new int[] {45,45,12,8,2,4,6,9,2};
        //int[] arr3 = new int[]{13,87,31,8913,8,32,6,2,8,0,8,6,45826};
        int[] arr4 = new int[]{6,5,3,1,8,7,2,4};
        System.out.println("BUBBLE: \t" + toString(bubble(arr)));
        System.out.println("SELECTION: \t" + toString(selection(arr2)));
        System.out.println("INSERTION: \t" + toString(insertion(arr4)));
        
        //searches:
        int num = 0;
        int[] arr3 = new int[]{1,2,3,4,5,0,6};
        
        System.out.println("LINEAR: " + linear(arr3, num));
        System.out.println("BINARY: " + binary(arr3, num));
    }
   public static int linear(int[] arr, int num)
   {
      for(int j = 0 ; j < arr.length; j++)
          if(arr[j] == num)
               return j;
      return -1;
   }
      
   public static int binary(int[] arr, int num)
   {
       int left = 0; int right = arr.length - 1;
       
       while(left <= right)
       {
           int mid = (left + right)/2;
           if(arr[mid] < num)
               right = mid - 1;
           else if(arr[mid] > num)
               left = mid + 1;
           else if(arr[mid] == num)
               return mid;
       }
       return -1;
       
   }
        
   public static int[] insertion(int arr[])
   {
       for(int j = 0; j < arr.length - 1; j++)
       {
           if(arr[j] < arr[j + 1])
           {
               for(int i = 0; i < j; i++)
               {  if(arr[i] > arr[j])
                   {
                       int store = arr[i];
                       arr[i] = arr[j];
                       arr[j] = store;
                   }
               }
           }
           else if(arr[j] > arr[j + 1])
           {
              int store = arr[j + 1];
              arr[j + 1] = arr[j];
              arr[j] = store; 
           }
       }
       return arr;
   }
    
   public static int[] bubble(int arr[])
   {
       int count = arr.length-1;
       for(int j = 0; j < arr.length; j++)
       {
           for(int i = 0; i < count; i++)
           {
               if(arr[j] > arr[i])
               {
                   int stored = arr[j];
                   arr[j] = arr[i];
                   arr[i] = stored;
               }
           }
           count--;
       }
       return arr;
   }
        
   public static int[] selection(int arr[])
   {
      int count = arr.length-1;
      
      for(int j = 0; j < arr.length; j ++)
      {
          int greatest = 0;
          for(int i = 0 ; i < count+1; i++)
          {
              if(arr[greatest] < arr[i])
                  greatest = i;
          }
          int stored = arr[greatest];
          System.out.println(count);
          arr[greatest] = arr[count];
          
          arr[count] = stored;
          count--;
      }
      return arr;
   }
       
    public static String toString(int arr[])
    {
        String s = "";
        for(int j =0 ; j < arr.length; j++)
            s += arr[j] + ", ";
        
        return s;
    }
}
