/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pascal.s.triangle;
import APClasses.APConsole;
import java.util.InputMismatchException;

public class PascalsTriangle 
{
    public static void main(String args[])
    {
        APConsole console = new APConsole("Pascal's Triangle");
        int rows = 0;
        int start = -1;
               
        console.println("How many rows of Pascal's Triangle should I print?");
        
        while(start == -1) 
        {    try
            {
               rows = console.nextInt(); 
               while(rows  < 1)
               {
                   console.println("I need to print at least one row");
                   rows = console.nextInt();
               }
               start++;
            }
            catch(InputMismatchException e)
            {
               console.nextLine();
               console.println("Give me a positive integer");   
            }
        }
        //console.println(printPascal(rows));
        int number;
        int[][] stored = getLengthsStored(rows);
        int greatestLength = (getLongestArrayLength(stored) + 1) * 2;
        System.out.println("Longest number has " + getLongestLength(stored) + "places");
        String spacesBetween = "";
        int longest = getLongestLength(stored);
        for(int j = 0; j < longest;j++)
        {
            spacesBetween += " ";
        }
        for(int i = 0 ; i < rows; i++)
        {
            number = 1;
//            int lengthSpaces = (greatestLength - (stored[i].length * 2 + 1))/2;
//            for(int j = 0; j < greatestLength; j++)
//            {
//                //console.print("z");
//                console.printf("%" + lengthSpaces+ "s", " ");
//            }
            String str = stored[rows - 1][stored[rows - 1].length / 2] + "";
            int length = str.length();
            
            for(int j = 0; j < rows - i; j++)
            {
                console.printf("%" + length + "s", "");
            }

            for(int j = 0; j <= i; j++)
            {
//                String numberStr = String.format("%" + longest + "s",number + "");
//                console.printf( numberStr + str.length());
                console.printf("%" + length + "d%" + length + "s", stored[i][j], "");
                //console.print(number + spacesBetween);
                number = number * (i - j) / (j + 1);
            }
            console.println("");
        }
        
        
    }
    
    public static int[][] getLengthsStored(int rows)
    {
        int number = 0;
        int storeLengths[][] = new int[rows][];
        for(int i = 0 ; i < rows; i++)
        {
            number = 1;
            storeLengths[i] = new int[i + 1];
            for(int j = 0; j <= i; j++)
            {
                storeLengths[i][j] = number;
                number = number * (i - j) / (j + 1);
            }
        }
        return storeLengths;
    }
    public static int getLongestLength(int[][] storeLengths)
    {
        int count = 0;
        for(int j = 0; j< storeLengths.length;j++)
        {
            for(int i = 0; i < storeLengths[j].length; i++)
            {
                if(storeLengths[j][i] > count)
                {
                    String str = storeLengths[j][i] + "";
                    count = str.length() + 1;
                }
            }
        }
        return count;
        
    }
    public static int getLongestArrayLength(int[][] storeLengths)
    {
        int greatest= 0;
        for(int j = 0; j < storeLengths.length;j++)
        {
            if(storeLengths[j].length > greatest)
            {
                greatest = storeLengths[j].length;
            }
        }
        return greatest;
    }
}
