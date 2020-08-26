/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordfinder;
import java.io.*;
import java.util.Scanner;
import APClasses.APConsole;
import java.util.InputMismatchException;
/**
 *
 * @author mercyougothis
 */
public class WordFinder 
{
    public static void main(String[] args)
    {
        File file;
        Scanner reader = new Scanner("");
        APConsole console = new APConsole("Word Finder");
        String text = "";
        String word = "";
        int wordCount = 0;
        int firstIndex = 0;
        String fileInput = "";
        console.println("Give me a file \n(make sure to include file type)\n");
        boolean goodFile = false;
        while(!goodFile)
        {
            int okayFile = 1;
            try 
            {
                fileInput = console.nextLine();
                file = new File(fileInput);
                reader = new Scanner(file);
                text = getAllText(reader);
                okayFile = 2;
            } 
            catch (FileNotFoundException ex)
            {
                console.println("I need a file name, try again");
                okayFile = 0;
            }
            if(okayFile != 0)
                goodFile = true;
        }
        console.println("Please give me a word to find");
        try
        {
            word = console.nextLine();
        }
         catch(InputMismatchException e)
        {

            console.nextLine();
            console.println("That's not a word. Try again");
        }
        word = word.toLowerCase();
        word = word.replace("'", "’");
        text = text.toLowerCase();
        
 
        while(text.contains(word) /*&& !isLetter(text.charAt(text.indexOf(word + word.length())))*/)
        {
            //makes sure word is not part of another word (ie. 'the' could be part of 'they') 
            
                //checks if there is a char after the word and a space or nothing before
            int nextChar = text.indexOf(text.charAt(text.indexOf(word) + word.length()));
            System.out.println(text.indexOf(word));
            if(text.indexOf(nextChar) <= text.length() && text.indexOf(word) == 1 || text.charAt(text.indexOf(word) - 1) == ' ' || text.charAt(text.indexOf(word) - 1) == '\n' || text.charAt(text.indexOf(word) - 1) == '“')
            {   //checks that char after word is not a letter
                if(!isLetter(text.charAt(nextChar)))
                {
                    //checks if it's first index
                    if(wordCount == 0)
                        firstIndex = text.indexOf(word);
                    //increases wordcount and checks if word appears again in line
                    wordCount++;    
                }
            }   
            //replaces word that is found regardless of whether it is actually the word so it isnt the only index of the word being searched for
            text = text.replaceFirst(word, ""); 
        }
        
        
            console.println("\n\nNumber of Occurences: " + wordCount + "\n"
                       +"First Occurence is at positon: " + firstIndex);

    }
    public static boolean isLetter(char c)
    {
        if(Character.isLetter(c) || c == '-')
        {
            return true;
        }
        return false;
    }
    
    public static String getAllText(Scanner reader)
    {
        String str = "";
        while(reader.hasNextLine())
        {
            str += reader.nextLine() + "\n";
        }
        return str;
    }
    
            
    

}
