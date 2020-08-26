/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testscoresunlimited;

import java.util.ArrayList;

/**
 *
 * @author mercyougothis
 */
public class TestScoresModel 
{
    private ArrayList <Student> students;
    private int indexSelectedStudent;
    private int studentCount;
    private int indexInFile = -1;
    
    public TestScoresModel()
    {
        //initialize the data
        indexSelectedStudent = -1;
        studentCount = 0;
        students = new ArrayList<Student>();
    }
    
    //Mutator methods for adding and replacing students
    public void setIndexInFile(int n)
    {
        indexInFile = n;
    }
    public int getIndexInFile()
    {
        return indexInFile;
    }
    public boolean hasIndex()
    {
        return getIndexInFile() == -1;
    }
    public String add(Student s)
    { 
        students.add(students.size(), s);
        indexSelectedStudent = studentCount;
        studentCount++;
        return null;
    }
    public void delete(Student s)
    {
        students.remove(s);
    }
    public int indexOf(Student s)
    {
        return students.indexOf(s);
    }
    public String replace(Student s)
    {
        if(indexSelectedStudent == -1)
        {
            return "Must add a student first";
        }
        else
        {
            
            students.set(indexSelectedStudent, s);
            return null;
        }
    }
    
    //Navigation methods
    public Student first()
    {
        Student s = null;
        if(studentCount == 0)
        {
            indexSelectedStudent = -1;
        }
        else
        {
            indexSelectedStudent = 0;
            s = students.get(indexSelectedStudent);
        }
        return s;
    }
    
    public Student previous()
    {
        Student s = null;
        if(studentCount == 0)
        {
            indexSelectedStudent = -1;
        }
   
        else
        {
            indexSelectedStudent = Math.max(0, indexSelectedStudent - 1);
            s = students.get(indexSelectedStudent);
        }
        
        return s;
    }
    
    public Student next()
    {
        Student s = null;
        if(studentCount == 0)
        {
            indexSelectedStudent = -1;
        }
        else
        {
            /*if(studentCount == indexSelectedStudent + 1)
            {
                return null;
            }*/
            /*else if(studentCount - 1 > indexSelectedStudent)
            {
                s = students[indexSelectedStudent];
            }*/
            
                indexSelectedStudent = Math.min(studentCount - 1, indexSelectedStudent + 1);
               // indexSelectedStudent++;
                s = students.get(indexSelectedStudent);
            
             
        }
        return s;
    }
    public Student last()
    {
        Student s = null;
        if(studentCount == 0)
        {
            indexSelectedStudent = -1;
        }
        else
        {
            indexSelectedStudent = studentCount - 1;
            s = students.get(indexSelectedStudent);
        }
        return s;
    }
    
    //Accessors to observe data
    public Student currentStudent()
    {
        if(indexSelectedStudent == -1)
        {
            return null;
        }
        else
        {
            return students.get(indexSelectedStudent);
        }
    }  
    public int size()
    {
        return studentCount;
    }
    public int currentPosition()
    {
        return indexSelectedStudent;
    }
    public double getClassAverage()
    {
        if(studentCount == 0)
        {
            return 0;
        }
        double sum = 0;
        for(int i = 0; i < studentCount; i++)
        {
            sum += students.get(i).getAverage();
        }   
        return (double)(sum/studentCount);
        
    }
    public Student getHighScore()
    {
        if(studentCount == 0)
        {
            return null;
        }
        else
        {
          Student s = students.get(0);
            for(int j  = 0; j < studentCount; j++)
            {
                if(s.getHighScore() < students.get(j).getHighScore())
                {
                   s = students.get(j); 
                }
            }
            return s;
        }
        
    }
    public String toString()
    {
        String result = "";
        for(int i = 0; i < studentCount; i++)
        {
            result = result + students.get(i).toString() + "\n";
        }
        return result;
    }
    public String toString(int i)
    {
        String str = getStudentCount() + "";
        for(int j = 0; j < getStudentCount(); j++)
        {
            str += "\n" + students.get(j).getName() + ": "+ students.get(j).getTestsandAv();
        }
        return str;
    }
     public int getIndexSelectedStudent()
    {
        return indexSelectedStudent;
    }
     public int getStudentCount()
     {
         return studentCount;
     }
}