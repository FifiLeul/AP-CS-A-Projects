/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towersofhanoi;
import java.util.Scanner;

public class TowersOfHanoi
{
    private static int count;
    public static void main(String[] args) 
    {
        count = 0;
        /*Scanner reader = new Scanner(System.in);
        System.out.print("Enter the number of rings: ");
        int numberOfRings = reader.nextInt();
        move(numberOfRings, 1, 3, 2);*/
        //System.out.println("number of calls to move: " + count);
        for(int j = 0 ; j <= 20; j++)
        {
            count = 0;
            move(j, 1,3,2);
            System.out.println(j + ": "+ count);
        }
        //System.out.println(count);
    }
    
    private static void move(int n , int i , int j, int k)
    {
       count++;
       if(n > 0)
       {
           move(n-1,i,k,j);
           //System.out.println("Move ring " + n + " from peg " + i + " to " + j);
           move(n-1, k, j, i);
       }
    }
    
    
}
