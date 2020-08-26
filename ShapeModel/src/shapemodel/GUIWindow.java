/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapemodel;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author mercyougothis
 */
public class GUIWindow 
{
    public static void main(String[] args)
    {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("GUI program");
        theGUI.setSize(300,300);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*ImageIcon image = new ImageIcon("puppy.jpg");
        ColorPanel panel = new ColorPanel(Color.black, image);
        Container pane = theGUI.getContentPane();
        pane.add(panel);*/
        
        ColorPanel panel = new ColorPanel(Color.WHITE);
        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);
                
    }
}
