/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapemodel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //for mouse events
import java.util.Random;

/**
 *
 * @author mercyougothis
 */
public class ColorPanel extends JPanel
{
  private ShapeModel database;
  private Shape selectedShape; //used to track selected shape
  private int x, y; //used to track mouse coordinates
  
  public ColorPanel(Color backColor)
  {
      setBackground(backColor);
      Random gen = new Random();
      //create 10 cirlces of random color
      database = new ShapeModel(10);
      for(int i = 0; i < 10; i++)
      {
          //Color color = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));
          Color color = new Color(0,0,0);
          Shape s;
          if(gen.nextInt(2) == 1)
              s = new Circle(i * 40, 40, 25, color);
          else
              s = new Rect(i * 40, 100, 50 , 50, color);
          //s.setColor(color);
          s.setFilled(true);
          database.add(s);
          
      }
      selectedShape = null;
      addMouseListener(new PanelListener());
      addMouseMotionListener(new PanelMotionListener());
  }
  
  public void fillShapes(Graphics g)
  {
      if(selectedShape != null)
       
          selectedShape.fill(g);
          
  }
  public void paintComponent(Graphics g)
  {
      super.paintComponent(g);
      database.draw(g);
  }
 
  public class PanelListener extends MouseAdapter
  {
      public void mousePressed(MouseEvent e)
      {
          //select circle if it contains mouse coordinates
          x = e.getX();
          y = e.getY();
          //search returns the shape or null
          selectedShape = database.containsPoint(x, y);
      }
      
      public void mouseReleased(MouseEvent e)
      {
          //deselect delected circle
          x = e.getX();
          y = e.getY();
          selectedShape = null;
      }
  }
  
  private class PanelMotionListener extends MouseMotionAdapter
  {
      public void mouseDragged(MouseEvent e)
      {
          //compute  the distance and move the selected circle  
          int newX = e.getX();
          int newY = e.getY();
          int dX = newX - x;
          int dY = newY - x;
          /*if(dX > 300)
               dX = 300;
          if(dY > 300)
              dY = 300;*/
                       
          if(selectedShape != null)
              selectedShape.move(dX,dY);
  
          x = newX;
          y = newY;
          repaint();
      }
  }
}
