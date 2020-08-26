/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;
import TurtleGraphics.Pen;
import java.awt.Graphics;

/**
 *
 * @author mercyougothis
 */
public class Triangle implements Shape
{
    protected double xPos, yPos;
    protected double secX, secY;
    protected double thirdX, thirdY;
    protected double distAB;
    protected double distBC;
    protected double distAC;
    public Triangle()
    {
        xPos = 1;
        yPos = 1;
    }
    public Triangle(double xPos, double yPos, double secX, double secY, double thirdX, double thirdY)
    {
        this.xPos = xPos;
        this.secX = secX;
        this.thirdX = thirdX;
        
        this.yPos = yPos;
        this.secY = secY;
        this.thirdY = thirdY;
        
        distAB = Math.sqrt((xPos - secX) * (xPos - secX) + (yPos - secY) * (yPos - secY));
        distBC = Math.sqrt((secX - thirdX) * (secX - thirdX) + (secY - thirdY) * (secY - thirdY));
        distAC = Math.sqrt((secX - xPos) * (secX - xPos) + (secY - yPos) * (secY - yPos));
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
    public double area()
    {
        return .5 * (double)(Math.abs(xPos * secY - secX * yPos + secX * thirdY - thirdX * secY + thirdX * yPos - xPos * thirdY));
    }
    @Override
    public void draw(Pen p)
    {
        p.up();
        p.move(xPos, yPos);
        
        p.down();
        p.setDirection(0);
        
        p.move(secX, secY);
        p.move(thirdX, thirdY);
        p.move(xPos, yPos);
        p.up();
        
        
       /* //p.turn(10);
        p.move(distAB);
        
        //p.turn(20);
        //p.turn(Math.cos((distAB * distAB + distAC * distAC - distBC * distBC) /2 *distAB*distAC));
        p.move(distBC);
        
        //p.turn(145);
        //p.turn(Math.cos((distAC * distAC + distBC * distBC - distAB * distAB )/ 2 * distAC * distBC));
        p.move(distAC);*/
    }   
    
            
    @Override
    public void stretchBy(double factor)
    {
       /*secX = distAB * factor;
       secY = distAB * factor;
       
       thirdX = distAC * factor;
       thirdY = distAC * factor;*/
       xPos *=factor;
       yPos *= factor;
       secX *= factor;
       secY *= factor;
       
       thirdX *= factor;
       thirdY *= factor;
    }
    @Override
    public void move(double up, double over)
    {
        //Shifts all vertices over
        double yDiff = this.yPos - yPos;
        double xDiff = this.xPos - xPos;
        
        this.xPos += over;
        this.secX += over;
        this.thirdX += over;
        
        this.yPos += up;
        this.secY += up;
        this.thirdY += up;
    }
    @Override
    public double getPerimeter()
    {
        return distAB + distBC + distAC;
    }
    @Override
    public String toString()
    {
        String str = "TRIANGLE\n"
                + "(X1,Y1): (" + xPos + ","+ yPos + ")\n"
                + "(X2,Y2): (" + secX + ","+ secY + ")\n"
                + "(X3,Y3): (" + thirdX + ","+ thirdY + ")\n"
                + "Area: " + String.format("%.2f", area()) +"\n"
                + "Perimeter: "+ String.format("%.2f", getPerimeter());
        return str;        
    }
}
