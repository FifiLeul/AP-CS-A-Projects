/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magicsquare;
import APClasses.APConsole;
import java.util.InputMismatchException;
/**
 *
 * @author mercyougothis
 */
public class MagicSquare 
{
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("Magic Square");
        int[][] array = new int[4][4];
        int count = 0;
        console.println("Give me 16 ints an I will tell you if they make a magic square");

        for(int j = 0; j < 4; j++)
        {
            for(int i = 0; i < 4;i++)
            {
                console.println("\nGive me an int");
                try
                {
                    array[j][i] = console.nextInt();
                }
                catch(InputMismatchException e)
                {
                    console.nextLine();
                    console.println("I only accept whole numbers. Try again");
                    continue;
                }
            }
        }
        for(int i = 0; i < array.length;i++)
        {
            String row = "";
            for(int j = 0; j < array[i].length;j++)
            {
                //row+= array[i][j] + " ";
                 row += String.format("%5d", array[i][j]) + " ";
                
            }
            console.printf("%4s\n", row);
            //console.println(row);
        }
        if(isMagicSquare(array))
        {
            console.println("You have a magic square!");
        }
        else
            console.println("Sorry, that's not a magic square :-(");
    }
    
    public static Boolean isMagicSquare(int[][] array)
    {
        if(rowsEqual(array) && columnsEqual(array))
        {
            return true;
        }
        else
            return false;
    }
    public static Boolean rowsEqual(int[][] array)
    {
        int vals[] = new int[array.length];
        int count = 1;
        for(int j = 0; j < array.length;j++)
        {
            for(int i = 0; i < array[j].length; i++)
            {
                //System.out.println(array[j][i]);
                vals[j] += array[j][i];
            }
        }
        for(int j = 1; j < vals.length; j++)
        {
            if(vals[j] == vals[0])
            {
                count++;
            }
        }
        if(count == vals.length)
        {
            return true;
        }
        else
            return false;
        
    } 
    public static Boolean columnsEqual(int[][] array)
    {
        int vals[] = new int[array.length];
        int count = 1;
        for(int j = 0; j < array[0].length;j++)
        {
            for(int i = 0; i < array.length; i++)
            {
                vals[j] += array[i][j];
            }
        }
        for(int j = 1; j < vals.length; j++)
        {
            if(vals[j] == vals[0])
            {
                count++;
            }
        }
        if(count == vals.length)
        {
            return true;
        }
        else
            return false;
        
    }
}

