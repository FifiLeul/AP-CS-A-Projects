/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student2;
import APClasses.APConsole;
/**
 *
 * @author mercyougothis
 */
public class Student2 
{
    private String name;
    private int[] tests;
    //Default: name is "" and 3 scores are 0
    public Student2()
    {
        this("");
    }
    public Student2(String nm)
    {
        this(nm, 3);
    }
    public Student2(String nm, int n)
    {
        name = nm;
        tests = new int[n];
        for(int i = 0; i < tests.length;i++)
        {
            tests[i] = 0;
        }
    }
    public Student2(String nm, int[] t)
    {
        name = nm; tests = new int[t.length];
        for(int i = 0; i < tests.length;i++)
        {
            tests[i] = t[i];
        }
    }
    public Student2(Student2 s)
    {
        this(s.name, s.tests);
    }
    public void setName(String nm)
    {
        name = nm;
    }
    public String getName()
    {
        return name;
    }
    public void setScore(int i, int score)
    {
        tests[i-1] = score;
    }
    public int getScore(int i)
    {
        return tests[i-1];
    }
    public double getAverage()
    {
        int sum = 0; 
        for(int score : tests)
        {
            sum += score;
        }
        if((double)sum/ tests.length < 1)
        {
            Double av = (double)sum/ tests.length;
            String avStr = String.format("%.2f", av);
            return Double.parseDouble(avStr);
        }
        return (double)sum/ tests.length;
    }
    public int getHighScore()
    {
        int highScore = 0;
        for(int score : tests)
        {
            highScore = Math.max(highScore, score);
        }
        return highScore;
    }
    public String toString()
    {
        String str = "Name:      " + name + "\n";
        for(int i = 0; i < tests.length; i++)
        {
            str += "test " + i + ": " + tests[i] + "\n";
        }
         str += "Average " + getAverage();
         return str;
    }
    public String validateData()
    {
        if(name.equals("") )
        {       
            return "Sorry: name required";
        }
        
        for(int score: tests)
        {
            if(score < 0 || score > 100)
            {
               String str = "Sorry: must have " + 0 + "<= test score <=" + 100;
               return str;
            }
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
}
