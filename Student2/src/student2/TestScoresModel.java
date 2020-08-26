/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student2;

/**
 *
 * @author mercyougothis
 */
public class TestScoresModel 
{
    private Student2[] students;
    private int indexSelectedStudent;
    private int studentCount;
    
    public TestScoresModel()
    {
        //initialize the data
        indexSelectedStudent = -1;
        studentCount = 0;
        students = new Student2[10];
    }
    
    //Mutator methods for adding and replacing students
    
    public String add(Student2 s)
    {
        if(studentCount == students.length)
        {
            return "Sorry: student list is full";
        }
        else
        {
            students[studentCount] = s;
            indexSelectedStudent = studentCount;
            studentCount++;
            return null;
        }
    }
    
    public String replace(Student2 s)
    {
        if(indexSelectedStudent == -1)
        {
            return "Must add a student first";
        }
        else
        {
            students[indexSelectedStudent] = s;
            return null;
        }
    }
    
    //Navigation methods
    public Student2 first()
    {
        Student2 s = null;
        if(studentCount == 0)
        {
            indexSelectedStudent = -1;
        }
        else
        {
            indexSelectedStudent = 0;
            s = students[indexSelectedStudent];
        }
        return s;
    }
    
    public Student2 previous()
    {
        Student2 s = null;
        if(studentCount == 0)
        {
            indexSelectedStudent = -1;
        }
   
        else
        {
            indexSelectedStudent = Math.max(0, indexSelectedStudent - 1);
            s = students[indexSelectedStudent];
        }
        
        return s;
    }
    
    public Student2 next()
    {
        Student2 s = null;
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
                s = students[indexSelectedStudent];
            
             
        }
        return s;
    }
    public Student2 last()
    {
        Student2 s = null;
        if(studentCount == 0)
        {
            indexSelectedStudent = -1;
        }
        else
        {
            indexSelectedStudent = studentCount - 1;
            s = students[indexSelectedStudent];
        }
        return s;
    }
    
    //Accessors to observe data
    public Student2 currentStudent()
    {
        if(indexSelectedStudent == -1)
        {
            return null;
        }
        else
        {
            return students[indexSelectedStudent];
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
            sum += students[i].getAverage();
        }   
        return (double)(sum/studentCount);
        
    }
    public Student2 getHighScore()
    {
        if(studentCount == 0)
        {
            return null;
        }
        else
        {
          Student2 s = students[0];
            for(int j  = 0; j < studentCount; j++)
            {
                if(s.getHighScore() < students[j].getHighScore())
                {
                   s = students[j]; 
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
            result = result + students[i] + "\n";
        }
        return result;
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