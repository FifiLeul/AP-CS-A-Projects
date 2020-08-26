/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundedtemperature;

/**
 *
 * @author mercyougothis
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUIWindow extends JFrame
{
    //<<<<<< Model >>>>>>>>
    private Thermometer thermo = new Thermometer();
    
    //<<<<<< View >>>>>>>>
    
    //declares and instantiates the widgets
    private JLabel fLabel = new JLabel("Degrees Farenheit");
    private JLabel cLabel = new JLabel("Degrees Celsius");
    private JTextField fField = new JTextField("32.0");
    private JTextField cField = new JTextField("0.0");
    private JButton fButton = new JButton("Convert >>>");
    
    //constructor
    public GUIWindow()
    {
        //set up panels to organie widgets and add them to window
        
        JPanel dataPanel = new JPanel(new GridLayout(2,2,12,6));
        dataPanel.add(fLabel);
        dataPanel.add(cLabel);
        dataPanel.add(fField);
        dataPanel.add(cField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(fButton);
        
        Container container = getContentPane();
        container.add(dataPanel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);
        
        //attatch a listener to the convert button
        fButton.addActionListener(new FahrenheitListener());
    }
    
    //<<<<<<<<< controller >>>>>>>>>>>>>
    
    private class FahrenheitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
           try
           {
               String input = fField.getText();
               double f = Double.parseDouble(input);
               thermo.setFahrenheit(f);
               double celsius = thermo.getCelsius();
               String inputStr = "";
               cField.setText(" " + String.format("%.2f",celsius));
           }
           
           catch(NumberFormatException p)
           {
               JOptionPane.showMessageDialog(GUIWindow.this,"Bad number format", "Temperature Converter", JOptionPane.ERROR_MESSAGE);
           }
            
        }
    }
    
    private class CelsiusListener implements ActionListener
    {
           public void actionPerformed(ActionEvent e)
        {
            String input = cField.getText();
            double c = Double.parseDouble(input);
            thermo.setCelsius(c);
            double f = thermo.getCelsius();
            fField.setText(" " + String.format("%.2f",f));
            
        }    
    }
    
}
