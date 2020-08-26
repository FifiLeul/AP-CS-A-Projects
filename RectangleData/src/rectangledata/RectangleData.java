/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangledata;

/**
 *
 * @author mercyougothis
 */
import APClasses.APConsole;
public class RectangleData 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        APConsole console = new APConsole("Rectangle Data");
        int[] height = new int[] {1,2,3,4,5,6,7,8,9,10}; 
        int[] width = new int[] {1,2,3,4,5,6,7,8,9,10};
        //console.printf("%28s%3s\n", "Perimeter", "Area");
        console.printf("%8s%8s%12s%8s\n","Perimeter", "Area","Width" , "Height");
       for(int j = 0; j < height.length; j++)
       {
           for(int k = 0; k < width.length; k++)
           {
               int perimeter = (height[j] * 2) + (width[k] * 2);
               int area = height[j] * width[k];
               
               //console.printf("%-10s%1s%-3s%5d%3d\n", height[j] + " (h)", "and  ", + width[k] + "(w):",perimeter,area);
               console.printf("%-13d%-7d%7d%7d\n",perimeter,area, width[k], height[j]);
           }
       }
       
       
    }
    
    
    
}
