/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testscoresunlimited;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.stage.FileChooser;

/**
 *
 * @author mercyougothis
 */
public class FileModel 
{ 
    ArrayList <File> files = new ArrayList <File> ();
    public FileModel()
    {
        
    }
    public void save(TestScoresModel m, int index) 
    {
        
        File file  = new File("" + files.size() + ".txt");
        if(files.isEmpty())
            files.add(file);
        else
            files.set(index,file);
        PrintWriter p;
        try 
        {
            p = new PrintWriter(file);
            p.print(m.toString(1));
            p.close();
        } 
        catch (FileNotFoundException ex) 
        {
            //System.out.println("File not found (save)");
        } 

    }
    public int getSize()
    {
        return files.size();
    }
    public void add(TestScoresModel m)
    {
        File file  = new File("" + files.size() + ".txt");
        files.add(file);
    }
    public TestScoresModel open(int index) 
    {
        TestScoresModel model = new TestScoresModel();
        //FileChooser f = new FileChooser();
        File file = files.get(index);
        //System.out.println("File name: " + file.getPath());
        Scanner reader = new Scanner("");
        try
        {
            reader = new Scanner(file);
        }
        catch(FileNotFoundException e)
        {
            //System.out.println("File not found (open)");
        }
        String str = getAllText(reader);
        //int gets # of students
        int numStudents = 0;
        if(reader.hasNextInt())
            numStudents = reader.nextInt();
        int count = 0;
        for(int j = 0; j < 3; j++)
        {
            int[] tests = new int[3];
            //gets the first line
             String strLine = str.substring(0, str.indexOf("\n"));
             String name = str.substring(0, str.indexOf(":"));
             String num = "";
             //goes through line for test scores, char by char
             for(int i = 0; i < strLine.length(); i++)
             {                 
                 if(Character.isDigit(str.charAt(i)))
                 {
                     //so you know which # it is at for tests[]
                     count++;
                     num = Character.toString(str.charAt(i));
                     //gets an entire #, not just first digit
                     while(Character.isDigit(str.charAt(i)))
                     {
                         num += Character.toString(str.charAt(i));
                         i++;
                     }
                     tests[count] = Integer.parseInt(num);
                 }
             }
             str = str.replace(strLine, "");
             model.add(new Student(name, tests));
        }
        return model;
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
