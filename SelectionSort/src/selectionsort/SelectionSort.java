 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionsort;

/**
 *
 * @author mercyougothis
 */
import APClasses.APConsole;
import java.util.InputMismatchException;
public class SelectionSort 
{
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("Selection Sort");
       String aboveAv = "";
       Comparable arr[] = new Comparable[10];
       int count = 0;
       
       console.println("Give me 10 ints and I will sort them");
       
       while(count != 10)
        {
           try
            {
                console.println("Enter your #");
                arr[count] = new Integer(console.nextInt() + "");
                count++;
            }
             catch(InputMismatchException e)
            {
                
                console.nextLine();
                console.println("That's not an integer");
            }
        }

        console.println("Original: " + print(arr));
        sort(arr);
        console.println("Sorted: " + print(arr));
        
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
