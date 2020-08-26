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
public class Sorts 
{
    public static void main(String[] args)
    {
        int[] arr = new int[]{3,1,4,2,5,0};
        int[] arr2 = new int[] {45,45,12,8,2,4,6,9,2};
        int[] arr3 = new int[]{13,87,31,8913,8,32,6,2,8,0,8,6,45826};
        int[] arr4 = new int[]{6,5,3,1,8,7,2,4};
        System.out.println("BUBBLE: \t" + toString(bubble(arr)));
        System.out.println("SELECTION: \t" + toString(selection(arr2)));
        System.out.println("INSERTION: \t" + toString(insertion(arr4)));
    }
    public static int[] insertion(int arr[])
    {
        for(int j = 0 ; j < arr.length-1; j ++)
        {
            if(arr[j] > arr[j + 1])
            {
                int stored = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = stored;
            }
            if(arr[j] < arr[j + 1])
            {
                for(int i = 0; i < j; i++)
                    if(arr[j] < arr[i])
                    {
                        int stored = arr[j];
                        arr[j] = arr[i];
                        arr[i] = stored;
                    }
            }
        }
        return arr;
    }
    public static int[] bubble(int arr[])
    {
        int count = arr.length;
        for(int j =0 ; j < arr.length; j++)
        {
            for(int i = 0; i < count - 1; i++)
            {
                if(arr[i] > arr[i + 1])
                {
                    int store = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = store;
                }
            }
            count--;
        }
        return arr;
    }
    public static int[] selection(int arr[])
    {
        int count = arr.length-1;
        for(int j = 1; j < arr.length-1; j ++)
        {
            int greatest = 0;
            for(int i = 1; i < count +1; i++)
            {
                if(arr[i] > arr[greatest])
                    greatest = i;
            }
            int store = arr[greatest];
            arr[greatest] = arr[count];
            arr[count] = store;
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
