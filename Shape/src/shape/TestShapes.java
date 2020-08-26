/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;
import TurtleGraphics.*;
import java.awt.Color;
import java.util.Scanner;

/**
 *
 * @author mercyougothis
 */
public class TestShapes 
{
    public static void main(String[] args)
    {
        //Declare and instantiate a pen, a circle and a rectangle
        Pen p = new StandardPen();
        
       Shape s1 = new Triangle(30,60, 60,30, 30,30);
        s1.draw(p);
        s1.stretchBy(3);
        s1.move(30, 70);
        
        p.setColor(Color.red);
        s1.draw(p);
        System.out.println(s1);
        
        
        
        /*Shape s1 = new Circle(20, 20, 20);
        Shape s2 = new Rect(-20, -20, 20, 10);
        Shape s3 = new Wheel(-20, -20, 20, 6);
        
        //Draw the circle and rectangle
        s1.draw(p);
        s2.draw(p);
        s3.draw(p);
        
        //Print Descriptions
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        
        //Pause until the user wants to continue
        System.out.print("Press <Enter> to continue: ");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
        
        //Erase the cirlce and rectangle and set the pen's color to red
        p.setColor(Color.white);
        s1.draw(p);
        s2.draw(p);
        p.setColor(Color.red);
        
        //Move the circle and rectangle, change their size and redraw
        s1.move(30,30);
        s2.move(-30, -30);
        s1.stretchBy(2);
        s2.stretchBy(2);
        s1.draw(p);
        s2.draw(p);*/
        
    }
}
