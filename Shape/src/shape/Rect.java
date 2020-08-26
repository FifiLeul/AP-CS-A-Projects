/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;
import TurtleGraphics.Pen;

/**
 *
 * @author mercyougothis
 */
public class Rect implements Shape
{
    private double xPos, yPos;
    private double height, width;
    
    public Rect()    
    {
        xPos = 0;
        yPos = 0;
        height = 1;
        width = 1;
    }
    
    public Rect(double xLoc, double yLoc, double w, double h)
    {
        xPos = xLoc;
        yPos = yLoc;
        width = w;
        height = h;
    }
    
    @Override
    public double area()
    {
        return height * width;
    }
    
    @Override
    public void draw(Pen p)
    {
        p.up();
        p.move(xPos, yPos);
        p.down();
        p.setDirection(0);
        p.move(width);
        p.turn(-90);
        p.move(height);
        p.turn(-90);
        p.move(width);
        p.turn(-90);
        p.move(height);
    }
    
    @Override
    public double getXPos()
    {
        return xPos;
    }
    
    @Override
    public double getYPos()
    {
        return yPos;
    }
    
    @Override
    public void move(double xLoc, double yLoc)
    {
        xPos = xLoc;
        yPos = yLoc;
    }
    
    @Override
    public void stretchBy(double factor)
    {
        height *= factor;
        width *= factor;
    }
    
    @Override 
    public String toString()
    {
        
        String str = "RECTANGLE\n"
                + "Width & Height : " + width + " & " + height + "\n"
                + "(X,Y) Position : (" + xPos + "," + yPos + ")\n"
                + "Area: " + String.format("%.2f", area()) + "\n"
                + "Perimeter: " + String.format("%.2f", getPerimeter()) +"\n";
        return str;
    }
    
    @Override
    public double getPerimeter()
    {
        return (width * 2) + (height * 2);
    }
}
