/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapemodel;

import java.awt.Graphics;

/**
 *
 * @author mercyougothis
 */
public class ShapeModel 
{
    Shape d[];// d
    int shapeCount = 0;
    /*   Constructor takes the number of number of indexes needed for d
        Can add new shapes --
        Can select a shape (the containsPoint method) 
        Can draw a shape
   */
    public ShapeModel(int numIndexes)
    {
        d = new Shape[numIndexes];
    }
    
    public void add(Shape s)
    {
        Shape d2[] = new Shape[d.length + 1];
        for(int j = 0; j < d.length; j ++)
        {
            d2[j] = d[j];
            shapeCount++;
        }
        d2[d2.length - 1] = s;
        d = d2;
    }
    public void draw(Graphics g) 
    {
        for(int j = 0; j < d.length; j++)
            if(d[j] != null)
                d[j].draw(g);
    }
    public void remove(Shape s)
    {
        int index = 0;
        Shape d2[] = new Shape[shapeCount-1];
        for(int j = 0; j < shapeCount; j++)
        {
            if(d[j] == s)
                index = j;
        }
        for(int j = 0; j < shapeCount; j++)
        {
            int count = j;
            if(j == index)
            {
                j++;
            }
            d2[count] = d[j];
                
        }
    }
    public Shape containsPoint(int x, int y)
    {
        for(int i = d.length - 1; i >= 0; i--)
          {
              if(d[i] != null)
                if(d[i].containsPoint(x,y))
                  return d[i];
              
          }
        return null;
    }

    
}
