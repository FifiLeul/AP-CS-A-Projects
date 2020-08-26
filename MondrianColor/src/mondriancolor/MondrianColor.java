/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mondriancolor;
import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;
/**
 *
 * @author mercyougothis
 */
public class MondrianColor extends JFrame
{
    public static void main(String[] args) 
    {
        MondrianColor colorPanel = new MondrianColor();
        colorPanel.setVisible(true);
    }
    private JSlider slider = new JSlider(SwingConstants.HORIZONTAL, 0, 10, 0);
    private ColorPanel panel = new ColorPanel(Color.white);
    private int level = 0;
    
    public MondrianColor()
    {
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(slider);
        
        Container container = getContentPane();
        container.add(panel, BorderLayout.CENTER);
        container.add(sliderPanel, BorderLayout.SOUTH);
        
        slider.addChangeListener(new SliderListener());
    }
     private class SliderListener implements ChangeListener
     {
         public void stateChanged(ChangeEvent e)
         {
             int value = slider.getValue();
             if(value != level)
             {
                 level = value;
                 panel.setLevel(level);
             }
         }
     }
    
    
}
