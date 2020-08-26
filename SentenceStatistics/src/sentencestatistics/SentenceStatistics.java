/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentencestatistics;
import java.io.*;
import APClasses.APConsole;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SentenceStatistics
{

    public static void main(String[] args) 
    {
        File file;
        Scanner reader = new Scanner("");
        
        try 
        {
            file = new File("Sentence Statistics File\\Sentence Statistics.txt");
            reader = new Scanner(file);
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println("I need a file");
        }
        String sentence = "";
        int wordCount = 0; 
        int sentenceLength = 0;
        int beginPosition = 0;
        int endPosition = 0;
        int wordLengths = 0;
        if(reader.hasNextLine())
        {
            String str = reader.nextLine();
            if(str.contains("!") && str.contains("."))
            {
                if(str.lastIndexOf(".") > str.lastIndexOf("!"))
                {
                    sentence = str.substring(0 , str.lastIndexOf("!"));
                    sentenceLength += 1;
                } 
                else
                {
                    sentence = str.substring(0, str.lastIndexOf("."));
                    sentenceLength += 1;
                }
                    
            }
            else if(str.contains("!"))
            {   
                
                sentence = str.substring(0, str.lastIndexOf("!"));
                sentenceLength +=1;
               // System.out.println(sentence);
            }
            else if(str.contains("."))
            {   
                //System.out.println("There is a period!");
                sentence = str.substring(0, str.lastIndexOf("."));
                sentenceLength +=1;
            }
            else
                sentence = str;
        }   
        endPosition = sentence.indexOf(' ');
        
        //continue until a blank isn't seen
        
        while(endPosition != -1)
        {
            if(endPosition > beginPosition)
            {
                wordCount++; 
                String word = sentence.substring(beginPosition, endPosition);
                sentenceLength += word.length();
                wordLengths += getLength(word);
            }
            
            //update the indexes to go to the next word
            beginPosition = endPosition + 1;
            endPosition = sentence.indexOf(' ', beginPosition);
        }
        //if at least one nonnlank char was seen at end of sent, consider it a word
        
        if(beginPosition < sentence.length())
        {
            wordCount++;
            String word = sentence.substring(beginPosition, sentence.length());
            sentenceLength += word.length();
            wordLengths += getLength(word);
        }
        
        if(wordCount == 0 || sentence.isEmpty())
            System.out.println("There are no words");
        else
             System.out.println("Word count: " + wordCount +"\n"
                          +"Sentence length: " + sentenceLength + "\n"
                          +"Average Word length: " + String.format("%.2f", (double)wordLengths/(double)wordCount));
        
    }
     public static boolean isLetter(char c)
    {
        if(Character.isLetter(c) || c == '-')
        {
            return true;
        }
        return false;
    }
    public static int getLength(String word)
    {
        int count = 0;
        for(int j = 0; j < word.length(); j++)
        {
            if(isLetter(word.charAt(j)))
                count++;      
        }
        return count;
    }
}
