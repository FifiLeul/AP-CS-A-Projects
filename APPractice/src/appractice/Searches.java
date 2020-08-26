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
public class Searches 
{
     public static void main(String[] args)
    {
        int num = 0;
        int[] arr = new int[]{1,2,3,4,5,0,6};
        
        System.out.println("LINEAR: " + linear(arr, num));
        System.out.println("BINARY: " + binary(arr, num));
    }
    public static int linear(int[] arr, int num)
    {
        for(int j = 0 ; j < arr.length; j++)
           if(num == arr[j])
               return j;
        return -1;
    }
    public static int binary(int[] arr, int num)
    {
        //only works on sorted*
        int left = 0; int right = arr.length - 1;
        int mid = 0;
        while(left <= right)
        {
            mid = (left + right) / 2;
            System.out.println("Mid: " + mid + " Left: " + left + " Right: " + right);
            if(arr[mid] == num)
                return mid;
            else if(arr[mid] < num)
                   right = mid - 1;
            else
                   left = mid + 1;
        }
      return -1;
    }
}
