/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dice;

import java.util.Random;

/**
 *
 * @author Fifi Teklemedhin
 */
public class Dice 
{

    /**
     * @param args the command line arguments
     */
    private int numberOfSides;
    private int faceValue;
    private int[] faceVal;
    //constructor
    
    public Dice(int numberOfSides)
    {
        this.numberOfSides = numberOfSides;
        Random getRandomNumber = new Random();
        faceValue = getRandomNumber.nextInt(numberOfSides) + 1;
        
    }
    public Dice()
    {
        this.numberOfSides = 6;
    }
    public Dice(int[] faceValue)
    {
        
    }
    
    //simulates rolling dice
    
    public void rollDice()
    {
        
        Random getRandomNumber = new Random();
        faceValue = getRandomNumber.nextInt(numberOfSides) + 1;
    }
    
    //returns face value of dice
    
    public int getFaceValue()
    {         
        //need it cause other method with face value is private
        return faceValue;
    }
    public int roll(int numberOfTimes)
    {
        Random getRandomNumber = new Random();
        
        
        int[] numOfTimes = new int[numberOfTimes];
        for(int j =0 ;j<numOfTimes.length;j++)
        {
            faceValue = getRandomNumber.nextInt(numberOfSides) + 1;
            numOfTimes[j] = faceValue;
            return numOfTimes[j];
        }
        return 0;
    }
    public int rollSum(int numberOfTimes)
    {
        Random getRandomNumber = new Random();
        int total = 0;
        int[] numOfTimes = new int[numberOfTimes];
        for(int j =0 ;j<numOfTimes.length;j++)
        {
            faceValue = getRandomNumber.nextInt(numberOfSides) + 1;
            numOfTimes[j] = faceValue;
            total+= numOfTimes[j];
        }
        return total;
    }
    public double rollAverage(int numberOfTimes)
    {
         Random getRandomNumber = new Random();
        int total = 0;
        int count = 0;
        int[] numOfTimes = new int[numberOfTimes];
        for(int j =0 ;j<numOfTimes.length;j++)
        {
            count++;
            faceValue = getRandomNumber.nextInt(numberOfSides) + 1;
            numOfTimes[j] = faceValue;
            total+= numOfTimes[j];
        }
        return total/count;
    }
    
    public String toString()
    {
        String toStr = " Current Face Value: " + faceValue + "\n" + "Number of Sides : " + numberOfSides;
        return toStr;
    }
}
