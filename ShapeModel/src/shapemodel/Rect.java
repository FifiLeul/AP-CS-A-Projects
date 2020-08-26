/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapemodel;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author mercyougothis
 */
public class Rect implements Shape
{
    private int x, y, width, height;
    private Color color;
    
    public Rect(int x, int y, int width, int height, Color color)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    @Override
    public void draw(Graphics g) 
    {
        Color oldColor = g.getColor();
        g.setColor(color);
        
        g.drawRect(x, y, width, height);
        
        g.setColor(oldColor);
    }

    @Override
    public boolean containsPoint(int x, int y)
    {
        //makes sure it is bigger / smaller than one x coord, it still is in the bounds of the other
        if( x < this.x  && x < this.x + width || x > this.x && x > this.x + width )
            return false;
        if( y < this.y  && y < this.y + height || y > this.y && x > this.y + height )
            return false;
        return true;         
    }

    @Override
    public void move(int xAmount, int yAmount)
    {
        x += xAmount;
        y += yAmount;
        /*width += xAmount;
        height += yAmount;*/
    }

    @Override
    public void fill(Graphics g)
    {
        Color oldColor = g.getColor();
        g.setColor(color);

        g.fillRect(x, y, width, height);
        g.setColor(oldColor);
    }
    @Override
    public void setFilled(boolean b) 
    {
        
    }
    
}
