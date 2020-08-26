/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sentencestatistics2;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SentenceStatistics2
{

    public static void main(String[] args) 
    {
        File file;
        Scanner reader = new Scanner("");
        try 
        {
            file = new File("Sentence Statistics.txt");
            reader = new Scanner(file);
        } 
        catch (FileNotFoundException ex)
        {
            System.out.println("I need a file");
        }
        int wordCount = 0;
        int sentLength = 0;
        String nextChar = "";
        String sent = "";
        if(reader.hasNextLine())
        {
            sent = reader.nextLine();
        }
        String words[] = new String[sent.length()];
                int count = 0;
        for(int j = 0; j < sent.length() - 1; j++)
        {
            if(isLetter(sent.charAt(j + 1)))
            {
                String word = sent.substring(j, j+1);
             count++;
                for(int i = j + 1; i < sent.length() - j; i++)
                { 
                    if(sent.charAt(i) != ' ')
                    {
                        word += sent.substring(i, i + 1);
                    }
                    j = i;
                }
                words[j] = word;
            }
            if(!isLetter(sent.charAt(j + 1)))
            {
                break;
            }
        }
        double av = 0;
        int length = 0;
        for(int j = 0; j < count; j++)
        {
           length += words[j].length();
        }
        
        if(sent.isEmpty())
        {
            System.out.println("There is no sentence");
        }
        System.out.println("Word count: " + count +"\n"
                          +"Sentence length: " + length + "\n"
                          +"Average Word length: " + length / count);
   

    }
     public static boolean isLetter(char c)
    {
        if(Character.isLetter(c) || c == '-')
        {
            return true;
        }
        return false;
    }
}
    