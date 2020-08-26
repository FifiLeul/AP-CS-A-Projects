/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapemodel;
import java.awt.*;
/**
 *
 * @author mercyougothis
 */
public interface Shape 
{
    public void draw(Graphics g);
    public boolean containsPoint(int x, int y);
    public void move(int xAmount, int yAmount);
    public void fill(Graphics g);
    public void setFilled(boolean b);
}
