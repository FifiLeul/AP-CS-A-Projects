package war;

import java.awt.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mercyougothis
 */
public class WarGUI 
{
   public static void main(String args[])
   {
       WarModel model = new WarModel();
       WarGUIView view = new WarGUIView(model);
       
       /*JFrame theGUI = new JFrame();
        theGUI.setTitle("GUI");
        theGUI.setSize(100,100);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("cards\\10C.png");
        ImagePanel panel = new ImagePanel(image);
        panel.setSize(theGUI.getWidth(),theGUI.getHeight());
        Container pane = theGUI.getContentPane();
        pane.add(panel);
        theGUI.setVisible(true);*/
   }
}
