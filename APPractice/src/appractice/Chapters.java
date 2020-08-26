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
public class Chapters 
{
    public static void main (String args[])
    {
        int x = 0;
        System.out.println("x: "  + x);
        change(x,5);
        System.out.println("Changed x: " + x);
    }
    public static void change(int x, int y)
    {
        x = y;
    }
}
