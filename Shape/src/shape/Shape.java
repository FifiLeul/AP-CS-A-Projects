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
public interface Shape 
{ 
    public double area();
    public void draw(Pen p);
    public double getXPos();
    public double getYPos();
    public void move(double xLoc, double yLoc);
    public void stretchBy(double factor);
    public String toString();
    public double getPerimeter();
}
