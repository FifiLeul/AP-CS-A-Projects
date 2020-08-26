/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integerlisting;

/**
 *
 * @author mercyougothis
 */
import APClasses.APConsole;
import java.util.InputMismatchException;
public class IntegerListing 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        APConsole console = new APConsole("Integer Listing");
        int allInts[] = new int[10];
        int count = 0;
        String negInts = "";
        String evenInts = "";
        String oddInts = "";
        
        
        console.println("Give me 10 intgers and I will give you the negatives, evens, odd\n and negatives.");
        
        while(count != 10)
        {
           try
            {
                console.println("Enter your #");
                allInts[count] = console.nextInt();
                count++;
            }
             catch(InputMismatchException e)
            {
                
                console.nextLine();
                console.println("That's not an integer");
            }
        }
        
        for(int j = 0; j < 10; j++)
        {
            if(allInts[j] < 0 && !negInts.contains( allInts[j]+ ""))
            {
                if(j == 10)
                {
                    negInts +=  allInts[j]+ "";
                }
                else
                  negInts +=  allInts[j]+ ", ";
                
            }
            if(allInts[j] % 2 == 0 && !evenInts.contains( allInts[j]+ ""))
            {
                if(j == 10)
                {
                    evenInts +=  allInts[j]+ "";
                } 
                else
                  evenInts +=  allInts[j]+ ", ";
            }
            if(allInts[j] % 2 != 0 && !oddInts.contains( allInts[j]+ ""))
            {
                if(j == 10)
                {
                    oddInts +=  allInts[j]+ "";
                } 
                else
                  oddInts +=  allInts[j]+ ", ";
            }
                
        }
        if(negInts.length() >= 2)
       {
           negInts = negInts.substring(0,negInts.length()-2);
       }
       if(evenInts.length() >= 2)
       {
           evenInts = evenInts.substring(0,evenInts.length()-2);
       }
       if(oddInts.length() >= 2)
       {
           oddInts = oddInts.substring(0, oddInts.length()-2);
       }
        console.println("    Negatives: " + negInts);
        console.println("    Evens: " + evenInts);
        console.println("    Odds: " + oddInts);
        
    }
    
}
