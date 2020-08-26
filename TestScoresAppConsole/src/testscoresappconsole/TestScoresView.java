/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//finalized 
package testscoresappconsole;

import java.util.Scanner;
import APClasses.APConsole;
import java.util.InputMismatchException;
public class TestScoresView 
{

	private TestScoresModel model = new TestScoresModel();
        private APConsole console = new APConsole();
		//run();

	
	
public TestScoresView(TestScoresModel m)
{
	model = m;
	run();
}
	
    private void run()
    {
        
        console.println(displayMenu());
        while(true)
        {
        console.println("-----------------------------------------------------");
        console.println("Number of students: " + model.size());
        if(model.currentPosition() == -1)
        {
            console.println("Index of current student: no students created yet" );
        }
        else
        {
            console.println("Index of current student: " + model.currentPosition());
        }
        int command = getCommand("Enter a number [1 - 11], or -1 to see the menu: " ,1,11);
        console.println("");
        if(command == 11)
        {
            console.println("Bye!");
        }
        runCommand(command);
    }
    }
    private void runCommand(int command)
    {
        
        if(command == -1)
        {
           console.println(displayMenu());
        }
        if(command == 1)
        {
                if(model.currentStudent() == null)
                {
                        console.println("I need a student to print");
                }
                else
                {
                        console.println("Student: " + model.currentStudent().getName());
                        console.println("Tests:");
                        for(int i = 1; i <= model.currentStudent().getNumTests()-1; i++)
                        {
                                console.println( "\t"+ i + ": "+ model.currentStudent().getScore(i));
                        }
                }

        }
        if(command == 2)
        {
            if(model.noTests())
            {
                console.println("There are no tests to compare");
            }
                
            String av = String.format("%.2f", model.getClassAverage());
                console.println("Class Average: " + av);
        }
        if(command == 3)
        {
            if(model.getHighScore() == null)
                console.println("There are no students / test scores to compare");
            else
            {
                console.println(model.getHighScore().getName() + " has the highest score");
            }
        }
        if(command == 4)
        {
            if(model.getStudentCount() == 0)
                console.println("No students yet");
            
            else
            {
                console.println("Students: ");
                console.println(model.getNames());
            } 
        }
        if(command == 5)
        {
            if(model.currentStudent() == null)
                    console.println("I need a student to edit");
            else
            {
                console.println("Give me a name");
                Scanner reader = new Scanner(System.in);
                String name = "";
                int score = 0;
                int count = 0;
                int[] scores = new int[100];
                try
                {
                    name = console.nextLine();
                }
                catch(InputMismatchException e)
                {
                    console.nextLine();
                    console.println("Try again");
                }

                console.println("Give me test scores, enter -1 when you're done");
                 while(score != -1)
                {
                    try
                    {
                       scores[count] = console.nextInt();
                       score = scores[count];

                       while(scores[count] < 0 && scores[count] != -1)
                       {
                           console.println("Give me a real score");
                           scores[count] = console.nextInt();
                       }
                       count++;
                    }
                    catch(InputMismatchException e)
                    {
                        console.nextLine();
                        console.println("Give me a positive whole number");
                    }

                }
                int[] finalScores = new int[count-1];
                for(int p = 0; p < count-1; p++)
                {
                    finalScores[p] = scores[p];
                    //console.println(finalScores[p]);
                }
                Student replace = new Student(name, finalScores);
                model.replace(replace);
            }    
            
        }
        if(command == 6)
        {
            console.println("Give me a name");
            Scanner reader = new Scanner(System.in);
            String name = "";
            int score = 0;
            int count = 0;
            int[] scores = new int[100];
            try
            {
                name = console.nextLine();
            }
            catch(InputMismatchException e)
            {
                console.nextLine();
                console.println("Try again");
            }

            console.println("Give me test scores, enter -1 when you're done");
            if(model.getStudentCount() == 10)
            {
                console.println("You can only have 10 students");
            }
            else
            {
                 while(score != -1)
                {
                    try
                    {
                       scores[count] = console.nextInt();
                       score = scores[count];

                       while(scores[count] < 0 && scores[count] != -1)
                       {
                           console.println("Give me a real score");
                           scores[count] = console.nextInt();
                       }
                       count++;
                    }
                    catch(InputMismatchException e)
                    {
                        console.nextLine();
                        console.println("Give me a positive whole number");
                    }

                }
                int[] finalScores = new int[count-1];
                for(int p = 0; p < count-1; p++)
                {
                    finalScores[p] = scores[p];
                    //console.println(finalScores[p]);
                }
                Student add = new Student(name, finalScores);
                model.add(add);   
            }

        }
        if(command == 7)
        {
            if(model.getStudentCount() == 0)
            {
                console.println("Make at least one student first");
            }
            else
            {
                model.first();  
                console.println("First (now current) student: " + model.currentStudent().getName());
            }

        }
        if(command == 8)
        {
            if(model.getStudentCount() == 0)
            {
                console.println("Make at least one student first");
            }
            else
            {
                model.last();  
                console.println("Last (now current) student: " + model.currentStudent().getName());
            }
        }
        if(command == 9)
        {
            if(model.getStudentCount() == 0)
            {
                console.println("There are no more students");
            }
            
            else
            {
                model.next();  
                console.println("Current student: " + model.currentStudent().getName());
            }
        }
        if(command == 10)
        {
            if(model.getStudentCount() == 0)
            {
                console.println("Make at least one student first");
            }
            else
            {
                model.previous();
                console.println("Current student: " + model.currentStudent().getName());
            }   
        }
}

private int getCommand(String prompt, int low, int high)
    {
       
       console.println(prompt);
       int nextInt = 0;
       try
       {
           nextInt = console.nextInt();
       }
       catch(InputMismatchException p)
       {

           console.nextLine();
           console.println("You need to put only numbers in. Try again");
       }
       return nextInt;
    }

    private String displayMenu()
    {
        return "1. Current Student\n2. Class average\n3. Student with highest grade\n4. All students\n5. Edit current student\n6. New student\n7. First student\n8. Last student\n9. Next student\n10.Previous student\n11.Quit program";
        
    }
    


	
}
