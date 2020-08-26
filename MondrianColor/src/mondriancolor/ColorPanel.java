/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mondriancolor;
import javax.swing.*;
import java.awt.*;
import java.util.Random;
/**
 *
 * @author mercyougothis
 */
public class ColorPanel extends JPanel
{
    private int level;
    private Random gen;
    
    public ColorPanel(Color backColor)
    {
        setBackground(backColor);
        setPreferredSize(new Dimension(300,200));
        level = 0;
        gen = new Random();
    }
    public void setLevel(int newLevel)
    {
        level = newLevel;
        repaint();
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        mondrian(g,0,0,getWidth(), getHeight(), level);
    }
    private void mondrian(Graphics g, int x1, int y1, int x2, int y2, int level)
    {
        if(level > 0)
        {  
            Random rand = new Random();
            g.setColor(new Color (rand.nextInt(255),rand.nextInt(255),rand.nextInt(255)));
            g.fillRect(x1, y1, x2 - x1, y2 - y1);
            int vertical  = gen.nextInt(2);

            if(vertical == 0)
            {
                mondrian(g, x1, y1, (x2 - x1) / 3 + x1, y2, level -1);
                mondrian(g, (x2 - x1) /3 + x1, y1, x2, y2, level - 1);
            }
           else
           {    mondrian(g, x1, y1, x2, (y2 - y1) / 3 + y1, level - 1);
                mondrian(g, x1, (y2 - y1) / 3 + y1, x2, y2, level - 1);
           }
      }
    }
}
