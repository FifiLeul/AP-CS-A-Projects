/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package euclideanalgorithm;
import APClasses.APConsole;
import java.util.InputMismatchException;


/**
 *
 * @author Leulm
 */
public class EuclideanAlgorithm 
{
    
   
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("EuclideanAlgorithm");
        int first = 0;
        int second = 0;
        
        console.println("Hello User! Give me two numbers and I will give you their" );
        console.println("greatest common divisor.");
        
        while(1 == 1)
        {
            try
            {
                console.println( "Give me your first number");
                first = console.nextInt();
                
                
                
            }
            catch(InputMismatchException e)
           {
                console.nextLine();
                console.println("Your imput isnt in the format of an integer, please try again");
           }
           try
           {
               console.println("Give me your second number");
                second = console.nextInt();
           }
           catch(InputMismatchException e)
           {
                console.nextLine();
                console.println("Your imput isnt in the format of an integer, please try again");
           }
           int remainder = 0;
        
        while(second!= 0)
        {
            remainder = first % second;
            console.println(first + " = " + "(" + first / second + ") " + second + " + " +  remainder );
            first = second;
            second = remainder;
            
        }
            console.println("Your greatest common divisor is " + getGcd(first, second));
            break;

        }
        
    }
    public static int getGcd(int first, int second)
    {
        int remainder = 0;
        
        while(second!= 0)
        {
            remainder = first % second;
           // System.out.println(first + " = " + "(" + first / second + ") " + second + " + " +  remainder );
            first = second;
            second = remainder;
            
        }
        return first;
    }

    
}
