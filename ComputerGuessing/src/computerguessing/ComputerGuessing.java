/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computerguessing;

/**
 *
 * @author ft196725
 */
import APClasses.APConsole;
import java.util.InputMismatchException;
import java.util.Random;
public class ComputerGuessing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("Computer Guessing");
        console.println("Computer or human guessing? press 1 or 2");
        int choice = console.nextInt();
        if(choice == 1)
        {
            console.println("Think of a # from 0 - 100 and I will guess it\n Give me a > if its too high, < if its too low,\nand = if I got it right");
            String reply = "";
            int highestUnder = 0;
            int lowestOver = 101;
            int count = 1;
            Random rand = new Random();
            int guess = (int)(Math.random() * 99 + 1);

            console.println(guess);
            reply = console.nextLine();

            while(!reply.equals("="))
            {
                while(!reply.equals(">") && !reply.equals("<"))
                {
                    console.println("Give me a > or <");
                    reply = console.nextLine();
                }
                
                if(reply.equals("<") && guess == 100)
                {
                    console.println("That doesn't make sense. Give me a > or =");
                    reply = console.nextLine();
                }
                
                else if(reply.equals("<"))
                {
                    
                    if(lowestOver - highestUnder == 1) 
                    {
                        console.println("You are giving me bad information. Try again.");
                        reply = console.nextLine();
                    }
                    else if(guess > highestUnder)
                    {
                        if(guess >= lowestOver)
                        {
                            console.println("That doesn't make sense. You gave me bad info. Try again");
                            reply = console.nextLine();
                        }
                        highestUnder = guess;
                        count++;
                    }
                }
                if(reply.equals(">") && guess == 0)
                {
                    console.println("That doesn't make sense. Give me a < or =");
                    reply = console.nextLine();
                }
                else if(reply.equals(">"))
                {
                     /*if(lowestOver - highestUnder == 1)    throw new IllegalArgumentException("You are giving me bad information");*/
                    if(lowestOver - highestUnder == 1) 
                    {
                        console.println("You are giving me bad information. Try again.");
                    }
                    else if(guess < lowestOver)
                    {
                        lowestOver = guess;
                        count++;
                    }
                }
                
                try
                {
                    guess = rand.nextInt(lowestOver - highestUnder) + highestUnder;
                }
                catch(IllegalArgumentException e)
                {
                    console.println("You are giving me bad information. Try again");
                    reply = console.nextLine();
                }

                console.println(guess);
                reply = console.nextLine();
            }
            if(reply.equals("="))
            {
                console.println("Yes! I got it in " + count + " tries.");
            }

        }
        
        if(choice == 2)
        {
            int secretNumber = (int)(Math.random() * 99 + 1);
            int guess;
            int count = 0;
            int hint = 100;
            int highestNumber = 101;
            int lowestNumber = 0;
            boolean success = false;

            console.println("Enter a guess (1 - 100): " );
            while(!success)
            {
                try
                {
                   do
                   {

                     guess = console.nextInt();

                     if(guess < 0 || guess >= 101)
                     {
                         console.println("YOUR GUESS IS OUT OF BOUNDS. Try a different number");
                         break;
                     }
                     if(guess != secretNumber  )
                     {

                         if(guess < secretNumber)
                         {
                             if(guess < lowestNumber)
                             {
                                 console.println("Hey.You already know that the number is higher than " + lowestNumber);
                                 count++;
                             }
                             if(guess > lowestNumber)
                             {
                                 lowestNumber = guess;
                                 console.println(" The secret number is greater than your guess. Try again");
                                 count++;
                             }

                         }

                         else if(guess > secretNumber )
                         {
                             if(guess > highestNumber)
                             {
                                 console.println("You already know the number is lower than " + highestNumber);
                                 count++;

                             }
                             if(guess < highestNumber)
                             {
                                 highestNumber = guess;
                                 count++;
                                 console.println("The secret number is less than your guess. Try again");
                             }
                         }


                     }

                     else if(guess == secretNumber)
                     {
                         console.println("Your guess is correct! You took " + count + " guesses to win!");
                         count++;
                      }
                     else if(guess < secretNumber)
                     {
                         console.println("Your guess is less than the secret number. Try again");
                         count++;
                     }
                     else if(guess > secretNumber)
                     {
                         console.println("Your guess is greater than the secret number. Try again");
                         count++;
                     }

                }
                while(guess != secretNumber); 
                }  

            catch(InputMismatchException e)
            {
                console.nextLine();
                console.println("I only accept whole numbers. Try again!");
            }

        }

    }
            
        }
    
}