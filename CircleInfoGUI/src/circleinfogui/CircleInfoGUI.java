/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circleinfogui;

/**
 *
 * @author mercyougothis
 */
import APClasses.APConsole;
import java.util.InputMismatchException;
public class CircleInfoGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("Circle Info GUI");
        double radius = 0;
        double areaOfCircle = 0;
        double surfaceAreaSphere = 0;
        double sphereVol = 0;
        
        console.println("Give me your radius and I will return the area of a circle, surface area of a sphere,\nor volume of a sphere with that radius");
        
        int start = 0;
        while(start != 1)
        {
            try
            {
                radius = console.nextDouble();
                while(radius < 0)
                {
                    console.println("You can't have a negative radius");
                    radius = console.nextDouble();
                }
                start++;
            }

            catch(InputMismatchException e)
            {
                console.nextLine();
                console.println("Give me a positive number");
            }
        }
        
        areaOfCircle = (radius * radius) * (Math.PI);
        surfaceAreaSphere = areaOfCircle * 4;
        sphereVol = (double) 4/3 * (radius * radius * radius) * (Math.PI);
        
        console.printf("\n\tArea of a Circle: " + areaOfCircle + "" + "\n");
        console.printf("\tSurface Area of a Sphere: " + surfaceAreaSphere + "" + "\n");
        console.printf("\tVolume of a Sphere: " + sphereVol + ""+"\n");
    }
    
}
