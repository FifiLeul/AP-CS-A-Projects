/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student;

/**
 *
 * @author mercyougothis
 */
public class Student 
{
    // manages a student's name and three test scores
    private String name;
    private int[] scores;
   
   public Student()
   {
       name = "";
       scores[1] = 0;
       scores[2] = 0;
       scores[3] = 0;
   }
   
   public Student(String nm, int t1, int t2, int t3)
   {
       name = nm;
       scores[1] = t1;
       scores[2] = t2;
       scores[3] = t3;
   }
   public Student(Student s)
   {
       name = s.name;
       scores[1] = s.scores[1];
       scores[2] = s.scores[2];
       scores[3] = s.scores[3];
   }
   
   public void setName(String a)
   {
       name = a;
   }
   public String getName()
   {
      return name; 
   }
   
   public void setScore(int whichTest, int setScore)
   {
       scores[whichTest] = setScore;
   }
   public int getScore(int whichTest)
   {
       return scores[whichTest];
   }
   
   public int getAverage()
   {
       int av = 0;
       for(int j = 0; j < scores.length; j++)
       {
           av += scores[j];
       }
       av /= scores.length;
       return av;
   }
   
   public int getHighestScore()
   {
      int highest = scores[0];
      for(int j = 1; j < scores.length; j++)
      {
          if(highest < scores[j])
          {
              highest = scores[j];
          }
      }
      return highest;
   }
   
   public String toString()
   {
       String str = "Name    " + name + "\n";
       for(int j = 0; j < scores.length; j++)
       {
           str += "Test" + j + scores[j] + "\n";
       }
       str+= "Average:  " + getAverage();
       return str;
   }
}
