/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapemodel;
import java.awt.*;
/**
 *
 * @author mercyougothis
 */
public class Circle implements Shape
{
    private int centerX, centerY, radius;
    private Color color;
    
    public Circle(int x, int y, int r, Color c)
    {
        centerX = x;
        centerY = y;
        radius = r;
        color = c;
    }
    
    @Override
    public void draw(Graphics g)
    {
        Color oldColor = g.getColor();
        g.setColor(color);
       
        //Translates cirlces center to rectangles origin for drawing
        g.drawOval(centerX - radius, centerY - radius,radius * 2, radius * 2);
        g.setColor(oldColor);
    }
    
    @Override
    public void fill(Graphics g)
    {
        Color oldColor = g.getColor();
        g.setColor(color);
        //translates circles center to rectangles origin for drawing
        g.fillOval(centerX - radius, centerY - radius, radius* 2, radius * 2);
        g.setColor(oldColor);
        
    }
    public void setColor(Color color)
    {
        this.color = color;
    }
    @Override
    public boolean containsPoint(int x, int y)
    {
        int xSquared = (x - centerX) * (x - centerX);
        int ySquared = (y - centerY) * (y - centerY);
        int radiusSquared = radius * radius;
        return xSquared + ySquared - radiusSquared <= 0;
    }
    @Override
    public void move(int xAmount, int yAmount)
    {
        centerX = centerX + xAmount;
        centerY = centerY + yAmount;
    }
    
     @Override
    public void setFilled(boolean b)
    {
        
    }
}
