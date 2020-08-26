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
public class Tester 
{
    public static void main(String args[])
    {
        MyArrays manager = new MyArrays();
        //these should work because they are objects
        String arr1[] = new String[]{"b","a", "c", "d"};
        Character arr2[] = new Character[]{'a', 'c', 'b', 'd'};
        Double arr3[] = new Double[]{1.0,2.0,3.0,4.0};
        Integer arr4[] = new Integer[]{1,4,3,2};
        //these should not work because they are primitive types
        char arr5[] = new char[]{'a', 'b', 'c', 'd'};
        double arr6[] = new double[]{1.0,2.0,3.0,4.0};
        int arr7[] = new int[]{1,2,3,4};
        
        manager.sort(arr1);//abcd
        manager.sort(arr2);//abcd
        manager.sort(arr3);//1-4
        manager.sort(arr4);//1-4 
        System.out.println("Selection Sort");
        System.out.println(print(arr1));
        System.out.println(print(arr2));
        System.out.println(print(arr3));
        System.out.println(print(arr4));
  
        System.out.println("\nLinear Search");
        System.out.println(display(manager.linearSearch(arr1, "c")));//2
        System.out.println(display(manager.linearSearch(arr2, 'c')));//1
        System.out.println(display(manager.linearSearch(arr3, 2.0)));//1
        System.out.println(display(manager.linearSearch(arr4, 2)));//3
        System.out.println(display(manager.linearSearch(arr4, 8)));//isn't in  the array
        
        //IM NOT SURE HOW TO DO THIS WITHOUT SORTING
        System.out.println("\narrays have been sorted for binary search to work");
        System.out.println(display(manager.binarySearch(arr1, "c")));//2
        System.out.println(display(manager.binarySearch(arr2, 'c')));//2
        System.out.println(display(manager.binarySearch(arr3, 2.0)));//1
        System.out.println(display(manager.binarySearch(arr4, 2)));//1
        System.out.println(display(manager.linearSearch(arr2, 'z')));//isn't in  the array
        
        
   
    }
        
    
    public static String display(int r)
    {
        if(r == -1)
            return "The index does not exist";
        return r + "";
    }
    public static String print(Comparable c[])
    {
        String str = "";
        for(int j = 0 ; j< c.length; j++)
        {
            str += c[j] + ", ";
        }
        return str;
    }
}


