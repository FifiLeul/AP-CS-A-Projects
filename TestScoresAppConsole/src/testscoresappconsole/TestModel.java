/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testscoresappconsole;
import APClasses.APConsole;

public class TestModel 
{
   public static void main (String[] args)
   {
       TestScoresModel model = new TestScoresModel();
       APConsole console = new APConsole("Test Model");
        console.println(model);

        console.println(model.size());
        console.println(model.currentPosition());
        console.println(model.currentStudent());

        for(int j = 1; j <= 3; j++)
        {
            Student s = new Student("S" + j);
        }
        console.println(model.first());

        console.println(model.next());
        console.println(model.previous());

        console.println(model.last());
        console.println(model.next());

        console.println(model.size());
        console.println(model.currentPosition());
        console.println(model.currentStudent());

        int[] grades = {97,88,77};
        Student newStudent = new Student("Beth", grades);
        model.replace(newStudent);
        console.println(model);
        
        for(int j = 6; j < 13; j++)
        {
            Student s = new Student("S"  + j);
            console.println(model.add(s));
        }
   }       
}
