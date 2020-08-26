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
public class Wheel extends Circle
{
    //instance vars from circle are inherited
    private int spokes; // num of spokes in wheel
    
    public Wheel()
    {
        super(); //have to activate the constructor to init instance vars
        spokes = 0;
    }
    
    public Wheel(double xLoc, double yLoc, double radius, int s)
    {
        super(xLoc,yLoc,radius); // activates other constructor and passes values
        spokes = s;
    }
    public void draw(Pen p)
    {
        //draws wheel's rim -- which is a circle
        super.draw(p);
        
        //draws spokes
        for(int i = 1; i <= spokes; i++)
        {
            p.up();
            p.move(xPos, yPos);
            p.setDirection(i * 360.0 / spokes);
            p.down();
            p.move(radius);
        }
    }
    public void setSpokes(int s)
    {
        spokes = s;
    }
    public String toString()
    {
        String str = "WHEEL\n"
                + "Radius: " + radius + "\n"
                +"Spokes: " + spokes + "\n"
                +"(X,Y) Position: (" + xPos + "," + yPos + ")\n"
                +"Area: " + String.format("%.2f", area()) + "\n"
                +"Circumference: " + String.format("%.2f", getPerimeter()) + "\n";
        return str;
    }
    
}
