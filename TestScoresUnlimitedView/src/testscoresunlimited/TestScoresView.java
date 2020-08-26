/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testscoresunlimited;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mercyougothis
 */
public class TestScoresView extends JFrame
{
    private TestScoresModel model;
    private String data;
    private int countAddedFiles = 0;
    private FileModel fileModel = new FileModel();
    private JMenuItem newMI = new JMenuItem("New");
    private JMenuItem open = new JMenuItem("Open");
    private JMenuItem save = new JMenuItem("Save");
    private JMenuItem add = new JMenuItem("Add");
    private JMenuItem modify = new JMenuItem("Modify");
    private JMenuItem delete = new JMenuItem("Delete");
    private JMenuItem highScore = new JMenuItem("Highest Score");
    private JMenuItem avScore = new JMenuItem("Class Average");
    
    private JButton firstButton = new JButton("<<");
    private JButton previousButton = new JButton("<");
    private JButton nextButton = new JButton(">");
    private JButton lastButton = new JButton(">>");
    
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
        
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(newMI);
        fileMenu.add(open);
        fileMenu.add(save);
        
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(add);
        editMenu.add(modify);
        editMenu.add(delete);
        
        JMenu dataMenu = new JMenu("Data");
        dataMenu.add(highScore);
        dataMenu.add(avScore);
        
        JMenuBar bar = new JMenuBar();
        bar.add(fileMenu);
        bar.add(editMenu);
        bar.add(dataMenu);
        
        setJMenuBar(bar);
        
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel(new GridLayout(5,4,10,5));
        JPanel southPanel = new JPanel();
        Container container = getContentPane();
        //container.add(northPanel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);
        container.add(southPanel, BorderLayout.SOUTH);
        
        //Data access buttons
        
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
        
        newMI.addActionListener(new NewListener());
        open.addActionListener(new OpenListener());
        save.addActionListener(new SaveListener());
        add.addActionListener(new AddListener());
        modify.addActionListener(new ModifyListener());
        delete.addActionListener(new DeleteListener());
        highScore.addActionListener(new HighScoreListener());
        avScore.addActionListener(new ClassAverageListener());
            //Bottom buttons
        firstButton.addActionListener(new FirstStudentListener());
        previousButton.addActionListener(new PreviousListener());
        nextButton.addActionListener(new NextListener());
        lastButton.addActionListener(new LastStudentListener());
        
        setTitle("Student Test Scores Unlimited");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args) 
    {
       TestScoresModel model = new TestScoresModel();
       TestScoresView view = new TestScoresView(model);       
    }
    
    //Updates fields with info from the model
    private void displayInfo(Student m)
    {
        Student s = m;
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
    public String getData()
    {
        return model.toString();
    }
    //Creates and returns new student from menu info
    private Student getInfoFromScreen()
    {
        Student s = new Student(nameField.getText());
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
           Student s = getInfoFromScreen();
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
               displayInfo(model.currentStudent());
           }
       }
       //attempt to add student and display error or update fields
       
    }
    private class NewListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {  
           //gets inputs,validate, and display error and quit if invalid
           model = new TestScoresModel();
           displayInfo(model.currentStudent());
       }  
    }
    private class OpenListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       { 
           /*System.out.println("Give me the index");
           Scanner reader = new Scanner(System.in);
           int index = -1;
           if(reader.hasNextInt())
               index = reader.nextInt();
           if(index <= fileModel.getSize() && index >= 0)*/
               model = fileModel.open(0);
           displayInfo(model.currentStudent());
       }
       //attempt to add student and display error or update fields
       
    }
    private class SaveListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {  
           try 
           {
               if(model.hasIndex())
                fileModel.save(model,model.getIndexInFile());
               else  
               {
                   model.setIndexInFile(countAddedFiles);
                   fileModel.add(model);
                   countAddedFiles++;
               }
           } 
           catch (Exception ex)
           {
               Logger.getLogger(TestScoresView.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       //attempt to add student and display error or update fields
    }
    private class DeleteListener implements ActionListener
    {
       public void actionPerformed(ActionEvent e)
       {  
         model.delete(model.currentStudent());
         displayInfo(model.currentStudent());
       }
       //attempt to add student and display error or update fields
       
    }
    private class ModifyListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try
            {
                Student s = getInfoFromScreen();
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
                 displayInfo(model.currentStudent());
                
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
            /*Student s = model.currentStudent();
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
                displayInfo(model.currentStudent());
            }
            
        }
    }
    private class NextListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           // model.next();
            if(model.getStudentCount() == 0 || model.indexOf(model.currentStudent()) == model.size())
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
                displayInfo(model.currentStudent());
            }
            
        }
    }
    private class LastStudentListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            model.last();
            if(model.getIndexSelectedStudent() == -1 || model.indexOf(model.currentStudent()) == model.size())
            {
                JOptionPane.showMessageDialog(TestScoresView.this, "There are no students");
            }
            else
            {
                //JOptionPane.showMessageDialog(TestScoresView.this, model.last().getName());
                displayInfo(model.currentStudent());
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
                displayInfo(model.currentStudent());
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
    public boolean isNum(String str)
    {
        for(int j = 0; j < str.length(); j++)
        {
            if(!Character.isDigit(str.charAt(j)))
                return false;
        }
        return true;
    }
    
}
