package testscoresappconsole;
public class TestScoresModel 
{
    private Student[] students;
    private int indexSelectedStudent;
    private int studentCount;
    
    public TestScoresModel()
    {
        //initialize the data
        indexSelectedStudent = -1;
        studentCount = 0;
        students = new Student[10];
    }
    
    //Mutator methods for adding and replacing students
    
    public int getStudentCount()
    {
        return studentCount;
    }
    public String add(Student s)
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
    
    public String replace(Student s)
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
            s = students[indexSelectedStudent];
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
            s = students[indexSelectedStudent];
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
                indexSelectedStudent = Math.min(studentCount - 1, indexSelectedStudent + 1);
               // indexSelectedStudent++;
                s = students[indexSelectedStudent];  
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
            s = students[indexSelectedStudent];
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
    public Student getHighScore()
    {
        if(studentCount == 0)
        {
            return null;
        }
        else
        {
          Student s = students[0];
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
            result = result + students[i] + "\n\n";
        }
        return result;
    }
    public String getNames()
    {
        String names = "";
        for(int j = 0; j < studentCount; j++)
        {
            if(j == 0)
                names += students[j].getName();
            else
                names += ", " + students[j].getName(); 
        }
        return names;
    }
    public boolean noTests()
    {
        int count = 0;
        for(int j = 0; j < studentCount; j++)
        {
            if(students[j].getNumTests() == 0)
            {
                count++;
            }
        }
        if(count == studentCount)
        {
            return true;
        }
        return false;
    }
}