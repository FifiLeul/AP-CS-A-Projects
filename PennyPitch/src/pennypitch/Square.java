/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennypitch;

public class Square extends Object
{
    private int label;
    private boolean pennyLanded = false;
    
    public Square(int numberLabel)
    {
        label = numberLabel;
    }
    public int getLabel()
    {
        return label;
    }
    public Boolean pennyLanded(Boolean bool)
    {
        pennyLanded = bool;
        return pennyLanded;
    }
    public String toString()
    {
        if(pennyLanded == true)
        {
            return "P";
        }
        else 
            return label + "";
    }
    
}
