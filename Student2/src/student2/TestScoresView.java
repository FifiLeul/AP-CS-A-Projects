/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student2;
import java.awt.*;
import java.awt.event.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author mercyougothis
 */
public class TestScoresView extends JFrame
{
    private TestScoresModel model;
    //window objects
    private JButton addButton = new JButton("add");
    private JButton modifyButton = new JButton("modify");
    private JButton firstButton = new JButton("<<");
    private JButton previousButton = new JButton("<");
    private JButton nextButton = new JButton(">");
    private JButton lastButton = new JButton(">>");
    private JButton highScoreButton = new JButton("highest score");
    private JButton aveScoreButton = new JButton("class average");
    
    private JLabel nameLabel = new JLabel("Name");
    private JLabel test1Label = new JLabel("Test 1");
    private JLabel test2Label = new JLabel("Test 2");
    private JLabel test3Label = new JLabel("Test 3");
    private JLabel averageLabel = new JLabel("average");
    private JLabel countLabel = new JLabel("count");
    private JLabel indexLabel = new JLabel("index");
    
    private JTextField nameField = new JTextField("");
    private JTextField test1Field = new JTextField("0");
    private JTextField test2Field = new JTextField("0");
    private JTextField test3Field = new JTextField("0");
    private JTextField averageField = new JTextField("0");
    private JTextField countField = new JTextField("0");
    private JTextField indexField = new JTextField("-1");
    public TestScoresView(TestScoresModel m)
    {
        model = m;
        
        //attributes of fields
        averageField.setEditable(false);
        countField.setEditable(false);
        indexField.setEditable(false);
        
        averageField.setBackground(Color.white);
        countField.setBackground(Color.white);
        indexField.setBackground(Color.white);
        
        //set up panels to organize widgets and add them to window
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel(new GridLayout(5,4,10,5));
        JPanel southPanel = new JPanel();
        Container container = getContentPane();
        container.add(northPanel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);
        container.add(southPanel, BorderLayout.SOUTH);
        
        //Data access buttons
        northPanel.add(addButton);
        northPanel.add(modifyButton);
        northPanel.add(highScoreButton);
        northPanel.add(aveScoreButton);
        
        //Row 1
        centerPanel.add(nameLabel);
        centerPanel.add(nameField);
        centerPanel.add(countLabel);
        centerPanel.add(countField);
        //Row 2
        centerPanel.add(test1Label);
        centerPanel.add(test1Field);
        centerPanel.add(indexLabel);
        centerPanel.add(indexField);
        //Row 3
        centerPanel.add(test2Label);
        centerPanel.add(test2Field);
        centerPanel.add(new JLabel("")); // for empty cell in grid
        centerPanel.add(new JLabel(""));
        //Row 4
        centerPanel.add(test3Label);
        centerPanel.add(test3Field);
        centerPanel.add(new JLabel(""));
        centerPanel.add(new JLabel(""));
        //Row 5
        centerPanel.add(averageLabel);
        centerPanel.add(averageField);
        centerPanel.add(new JLabel(""));
        centerPanel.add(new JLabel(""));
        //Navigation buttons
        southPanel.add(firstButton);
        southPanel.add(previousButton);
        southPanel.add(nextButton);
        southPanel.add(lastButton);
        //attatch listeners to buttons
            //Top buttons
        addButton.addActionListener(new AddListener());
        modifyButton.addActionListener(new ModifyListener());
        highScoreButton.addActionListener(new HighScoreListener());
        aveScoreButton.addActionListener(new ClassAverageListener());
            //Bottom buttons
        firstButton.addActionListener(new FirstStudentListener());
        previousButton.addActionListener(new PreviousListener());
        nextButton.addActionListener(new NextListener());
        lastButton.addActionListener(new LastStudentListener());
        
        
        //excercise attatchments should go here
        //set window attributes
        setTitle("Student Test Scores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        //run();
    }
    //Updates fields with info from the model
    private void displayInfo()
    {
        Student2 s = model.currentStudent();
        if(s == null)
        {
            nameField.setText("");
            test1Field.setText("0");
            test2Field.setText("0");
            test3Field.setText("0");
            averageField.setText("0");
            countField.setText("0");
            indexField.setText("-1");          
        }
        else
        {
            nameField.setText(s.getName());
            test1Field.setText("" + s.getScore(1));
            test2Field.setText("" + s.getScore(2));
            test3Field.setText("" + s.getScore(3));
            averageField.setText(String.format("%.2f", s.getAverage()));
            countField.setText("" + model.size());
            indexField.setText("" + model.currentPosition());
        }
    }
    //Creates and returns new student from menu info
    private Student2 getInfoFromScreen()
    {
        Student2 s = new Student2(nameField.getText());
        s.setScore(1, Integer.parseInt(test1Field.getText()));
        s.setScore(2, Integer.parseInt(test2Field.getText()));
        s.setScore(3, Integer.parseInt(test3Field.getText()));
        return s;
    }
    
    //controller
    //responds to a clock on the Add button
    private class AddListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {  
           //gets inputs,validate, and display error and quit if invalid
           Student2 s = getInfoFromScreen();
           String message = s.validateData();
           if(message != null)
           {
               JOptionPane.showMessageDialog(TestScoresView.this, message);
           }
           message = model.add(s);
           if(message != null)
           {
             JOptionPane.showMessageDialog(TestScoresView.this, message);  
           }
           else
           {
               displayInfo();
           }
       }
       //attempt to add student and display error or update fields
       
    }
    
    private class ModifyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                Student2 s = getInfoFromScreen();
                String rep = s.validateData();
                
                if(rep != null)
                {
                    JOptionPane.showMessageDialog(TestScoresView.this,"Try again" );
                }
                rep = model.replace(s);
                if(rep != null)
                {
                    JOptionPane.showMessageDialog(TestScoresView.this, "Try again");
                }
                 displayInfo();
                
            }
            catch(Exception p)
            {
                JOptionPane.showMessageDialog(TestScoresView.this, "Bad input", "High Score (modify listener)", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private class HighScoreListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            /*Student2 s = model.currentStudent();
            String highScore;*/
            if(model.getHighScore() == null)
            {
                JOptionPane.showMessageDialog(TestScoresView.this, "I can't get a high score");
            }
            else
            {
                //model.getHighScore().getHighScore gets the high score of the highest scoring student
                JOptionPane.showMessageDialog(TestScoresView.this, model.getHighScore().getName() + " has the highest score (which is a "  + model.getHighScore().getHighScore()+ ")");
            }
         
        }
    }
    
    private class ClassAverageListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {
           double av = model.getClassAverage();
           if(av == 0)
           {
               JOptionPane.showMessageDialog(TestScoresView.this,"0 -- either no students or all 0's" );
           }
           else
           {
               String avStr = String.format("%.2f", av);
               JOptionPane.showMessageDialog(TestScoresView.this, "Class Average: " + avStr);
           }
               
       }
    }
    
    private class PreviousListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           
           if(model.getIndexSelectedStudent() == 0)
           {
               
               JOptionPane.showMessageDialog(TestScoresView.this, "This is the first student");
           }
           model.previous();
           if(model.getIndexSelectedStudent() == -1 )
            {
                JOptionPane.showMessageDialog(TestScoresView.this, "There are no students");
                model.next();
            }
            else
            {
                //JOptionPane.showMessageDialog(TestScoresView.this, model.previous().getName());
                displayInfo();
            }
            
        }
    }
    private class NextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           // model.next();
            if(model.getStudentCount() == 0)
            {
                JOptionPane.showMessageDialog(TestScoresView.this, "There are no more students");
            }
            /*else if(model.next() == null)
            {
                JOptionPane.showMessageDialog(TestScoresView.this, "This is the last student");
            }*/
            else
            {
                model.next();
                displayInfo();
            }
            
        }
    }
    private class LastStudentListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            model.last();
            if(model.getIndexSelectedStudent() == -1)
            {
                JOptionPane.showMessageDialog(TestScoresView.this, "There are no students");
            }
            else
            {
                //JOptionPane.showMessageDialog(TestScoresView.this, model.last().getName());
                displayInfo();
            }
        }
    }
     private class FirstStudentListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            model.first();
            if(model.getIndexSelectedStudent() == -1)
            {
                JOptionPane.showMessageDialog(TestScoresView.this, "There are no students");
            }
            else
            {
                //JOptionPane.showMessageDialog(TestScoresView.this, model.previous().getName());
                displayInfo();
            }
        }
    }
 
    //Menu-driven command loop
    private void run()
    {
        while(true)
        {
            System.out.println("Number of Students: " + model.size());
            System.out.println("Index of current student: " + model.currentPosition());
            
            displayMenu();
            int command = getCommand("Enter a number [1 - 11]: " ,1,11);
            if(command == 11)
                break;
            //runCommand(command);
        }
    }
    
    private void displayMenu()
    {
        System.out.println("1. Current Student\n2. class average\n3. Student with highest grade\n4.all students\n5.edit current student\n6.new student\n7. first student\n8.last student\n9.next student\n10. previous student\n 11. quit program");
        
    }
    private int getCommand(String prompt, int low, int high)
    {
       Scanner reader = new Scanner(System.in);
       System.out.print(prompt);
       int nextInt = 0;
       try
       {
           nextInt = reader.nextInt();
       }
       catch(InputMismatchException p)
       {

           reader.nextLine();
           System.out.println("You need to put only numbers in. Try again");
       }
       return nextInt;
    }
   
}
