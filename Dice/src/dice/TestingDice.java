/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;
    

/**
 *
 * @author Leulm
 */
public class TestingDice 
{
    public static void main(String[] args) 
    {
       Dice die1 = new Dice();
       Dice die2 = new Dice(12);
       
       die1.roll(1);
       System.out.println(die1.toString());
       
       System.out.println(die2.rollAverage(2));
       System.out.println(die2.rollSum(2));
       System.out.println(die2.toString());
       /*System.out.println("The intial value of our die is: " + die1.getFaceValue());
       die1.rollDice();
       System.out.println("The value after rolling our die is: " + die1.getFaceValue());*/
       
       
    }
}
