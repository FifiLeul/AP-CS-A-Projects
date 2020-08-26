/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapesmain;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author mercyougothis
 */
public abstract class Shape 
{
    //protected makes them available to subclasses
    protected double xCoord;
    protected double yCoord;
    protected double area;
    protected double perimeter;
    
    protected Shape(double x, double y)
    {
        this.xCoord = x;
        this.yCoord = y;
    }
    
    protected Shape(double x, double y, double perimeter, double area)
    {
        //chaining Shape constructor above
        this(x,y);
        this.perimeter = perimeter;
        this.area = area;
    }
    protected Shape()
    {
        //chaining Shape constructor above
        this(0,0,0,0);
    }
    
    //getters
    public double getArea()
    {
        return area;
    }
    public double getPerimeter()
    {
        return perimeter;
    }
    public double getXCoord()
    {
        return xCoord;
    }
    public double getYCoord()
    {
        return yCoord;
    }
    
    //setters
    public void setArea(double area)
    {
        this.area = area;
    }
    public void setPerimeter(double perimeter)
    {
        this.perimeter = perimeter;
    }
    public void setXCoord(double xCoord)
    {
        this.xCoord = xCoord;
    }
    public void setYCoord(double yCoord)
    {
        this.yCoord = yCoord;
    }
    
    //never used, so abstract methods cannot have a body
    public abstract void draw(Graphics g);

}

