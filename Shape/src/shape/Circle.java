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
public class Circle implements Shape
{
    protected double xPos, yPos;
    protected double radius;
    
    public Circle()
    {
        xPos = 0;
        yPos = 0;
        radius = 1;
    }
    public Circle(double xLoc, double yLoc, double radius)
    {
        xPos = xLoc;
        yPos = yLoc;
        this.radius = radius;
    }

    
    
    //Overriden Methods
    @Override
    public double area()
    {
        return Math.PI * radius * radius;
    }
    @Override
    public void draw(Pen p)
    {
        double side = 2.0 * Math.PI * radius / 120.0;
        p.up();
        p.move(xPos + radius, yPos - side / 2.0);
        p.setDirection(90);
        p.down();
        for(int i = 0; i < 120; i++)
        {
            p.move(side);
            p.turn(3);
        }
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
        radius *= factor;
    }
    public String toString()
    {
        String str = "CIRCLE\n"
                    +"Radius:" + radius + "\n"
                    +"(X,Y Position: (" + xPos + "," + yPos + ")\n"
                    +"Area: " + String.format("%.2f", area()) + "\n"
                    +"Circumference: " + String.format("%.2f", getPerimeter())+"\n";
        return str;
    }
    @Override
    public double getPerimeter() 
    {
        return Math.PI * radius * 2;
    }
    
}
