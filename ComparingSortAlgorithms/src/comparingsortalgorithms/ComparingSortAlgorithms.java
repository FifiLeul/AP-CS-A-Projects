/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package comparingsortalgorithms;
import java.util.*;
/**
 *
 * @author zb175513
 */
public class ComparingSortAlgorithms {

    /**
     * @param args the command line arguments
     */
    private static int bubbleComps;
    private static int bubbleExs;
    private static int quickComps;
    private static int quickExs;
    
    
    public static void main(String[] args) {
        Random gen = new Random();
        Scanner reader = new Scanner(System.in);
        while(true){
            System.out.print("Enter the array length [0 to quit]: ");
            int arrayLength = reader.nextInt();
            if(arrayLength<=0)
                break;
            
            int[] a1 = new int[arrayLength];
            int[] a2 = new int[arrayLength * 100];
            
            for(int i = 0; i <a1.length;i++){
                a1[i] = gen.nextInt(100001);
            }
            for(int i = 0; i<a2.length;i++){
                a2[i]=gen.nextInt(100001);
            }
            
            Date d1 = new Date();
            
            bubbleComps = 0;
            bubbleExs =0;
            bubbleSort(a1);
            Date d2 = new Date();
            long elapsedTime1 = d2.getTime() - d1.getTime();
            
            quickComps =0;
            quickExs = 0;
            d1 = new Date();
            quickSort(a2,0,a2.length-1);
            d2 = new Date();
            long elapsedTime2 = (d2.getTime()-d1.getTime());
            
            System.out.printf("       %12s %14s%n","Bubble Sort","Quick Sort");
            System.out.printf("Length %8d %16d%n",arrayLength,arrayLength*100);
            System.out.printf("Time   %8d %16d%n",elapsedTime1,elapsedTime2);
            System.out.printf("Comps  %8d %16d%n",bubbleComps,quickComps);
            System.out.printf("Exs    %8d %16d%n%n",bubbleExs,quickExs);
            
        }
    }
    
    
    private static void bubbleSort(int[] a){
        for(int i = 0; i <a.length-1; i++){
            for(int j = 1+1; j <a.length-1;j++){
                bubbleComps++;
                if(a[i] > a[j]){
                    bubbleExs++;
                    int temp = a[i];
                    a[i] = a[j];
                    a[j]= temp;
                }
            }
        }
    }
    
    private static void quickSort(int[]a, int left, int right){
        if(left >= right) 
            return;
        int i = left;
        int j = right;
        int pivotValue = a[(left+right)/2];
        
        quickComps++;
        while(i<j){
           quickComps++;
           while(a[i]<pivotValue){
               quickComps++;
               i++;
           } 
           while(pivotValue<a[j]){
               quickComps++;
               j--;
           }
           if(i<=j){
               quickExs++;
               int temp = a[i];
               a[i]=a[j];
               a[j]=temp;
               i++;
               j--;
           }
        }
        quickSort(a,left,j);
        quickSort(a,i,right);
        
              
    }
}
