/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swapsandcompares;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author mercyougothis
 */
public class SwapsAndCompares
{
    static int bubbleComps = 0;
    static int bubbleSwaps = 0;
    static int nums[] = {10,50,100,150,200,550,750,900,1000,1500,3000,4000, 5000};
    static ArrayList<Integer> storeComps = new ArrayList<Integer>();
    static ArrayList<Integer> storePredictions = new ArrayList<Integer>();
    static int ind = 0;
    public static void main(String[] args) 
    {
        nums = makeArraySizes(20);
        System.out.println("************ARRAY SIZE*****************");
        for(int j = 0 ; j < nums.length; j++)
        {
            bubbleSort(makeArr(nums[j]));
            System.out.println(nums[j]);
        }
        
       System.out.println("************COMPARISONS*****************");
       for(int j = 0 ; j < storeComps.size(); j++)
       {
         System.out.println(storeComps.get(j));
       }
       
       System.out.println("***********PREDICTIONS******************");
       for(int j = 0 ; j < storePredictions.size(); j++)
       {
         System.out.println(storePredictions.get(j));
       }
       
       System.out.println("***********DIFFERENCE******************");
       for(int j = 0 ; j < storePredictions.size(); j++)
       {
         System.out.println(Math.abs(storePredictions.get(j) - storeComps.get(j)));
       }
    }
    public static int[] makeArr(int arrLength)
    {
        int[] a1 = new int[arrLength];
        Random rand = new Random();   
        for(int i = 0; i <a1.length;i++){
            a1[i] = rand.nextInt(100001);
        }
        return a1;
    }
    public static int[] makeArraySizes(int numOfArrays)
    {
        int[] a1 = new int[numOfArrays];
        Random rand = new Random();   
        for(int i = 0; i <a1.length;i++){
            a1[i] = rand.nextInt(7000);
        }
        return a1;
    }
    private static void predict(int[] arr)
    {
        int n = arr.length;
        storePredictions.add((int)Math.pow(n,2) - (4 *n) + 3); 
    }
    private static void bubbleSort(int[] a)
    {
        predict(a);
        bubbleComps = 0;
        for(int i = 0; i <a.length-1; i++)
        {
            for(int j = 1+1; j <a.length-1;j++)
            {
                bubbleComps++;
                if(a[i] > a[j]){
                    bubbleSwaps++;
                    int temp = a[i];
                    a[i] = a[j];
                    a[j]= temp;
                }
            }
        }
        storeComps.add(bubbleComps); 
    }
    
}
