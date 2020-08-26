/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mercyougothis
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GUIWindow extends JFrame
{
    private JLabel radius = new JLabel("Radius");
    private JLabel areaCircle = new JLabel("Area of Circle");
    private JLabel areaSphere = new JLabel("SA of Sphere");
    private JLabel volumeSphere = new JLabel("Volume of Sphere");
    
    private JTextField radiusField = new JTextField("0.0");
    private JTextField areaCircleField = new JTextField("0.0");
    private JTextField areaSphereField = new JTextField("0.0");
    private JTextField volumeSphereField = new JTextField("0.0");
    
    private JButton convertButton = new JButton("Calculate");
    
    public GUIWindow()
    {
        JPanel dataPanel = new JPanel(new GridLayout(2,4,12,12));
        dataPanel.add(radius);
        dataPanel.add(areaCircle);
        dataPanel.add(areaSphere);
        dataPanel.add(volumeSphere);
        
        dataPanel.add(radiusField);
        dataPanel.add(areaCircleField);
        dataPanel.add(areaSphereField);
        dataPanel.add(volumeSphereField);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertButton);
        
        Container container = getContentPane();
        container.add(dataPanel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);
        
        convertButton.addActionListener(new radiusListener());
    }
    
    private class radiusListener implements ActionListener
    {
        
        public void actionPerformed(ActionEvent e)
        {
            double r = 0;
            try
            {
                String input = radiusField.getText();
                r = Double.parseDouble(input);    
            }
            catch(NumberFormatException p)
           {
               JOptionPane.showMessageDialog(GUIWindow.this,"Bad number format", "Circle Info GUI", JOptionPane.ERROR_MESSAGE);
           }
            areaCircleField.setText(" " + String.format("%f",getAreaOfCircle(r)));
            areaSphereField.setText(" " + String.format("%f",getSurfaceAreaSphere(r)));
            volumeSphereField.setText(" " + String.format("%f",getVolumeSphere(r)));
        }

       
    }
    public double getAreaOfCircle(double radius)
    {
        double areaOfCircle = (radius * radius) * (Math.PI);
        return areaOfCircle;
    }
    
    public double getSurfaceAreaSphere(double radius)
    {
        double surfaceAreaSphere = this.getAreaOfCircle(radius) * 4;
        return surfaceAreaSphere;
    }
    
    public double getVolumeSphere(double radius)
    {
        double sphereVol = (double) 4/3 * (radius * radius * radius) * (Math.PI);
        return sphereVol;
    }
    
}
