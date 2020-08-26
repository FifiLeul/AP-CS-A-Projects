/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennypitchjframe;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class PennyPitchJFrame extends JPanel
{
     private static Square[][] squares =
                 {{new Square(1), new Square(1), new Square(1), new Square(1), new Square(1)}, 
                  {new Square(1), new Square(2), new Square(2), new Square(2), new Square(1)},
                  {new Square(1), new Square(2), new Square(3), new Square(2), new Square(1)}, 
                  {new Square(1), new Square(2), new Square(2), new Square(2), new Square(1)},
                  {new Square(1), new Square(1), new Square(1), new Square(1), new Square(1)}};
    private static Square[][] resetter =
                 {{new Square(1), new Square(1), new Square(1), new Square(1), new Square(1)}, 
                  {new Square(1), new Square(2), new Square(2), new Square(2), new Square(1)},
                  {new Square(1), new Square(2), new Square(3), new Square(2), new Square(1)}, 
                  {new Square(1), new Square(2), new Square(2), new Square(2), new Square(1)},
                  {new Square(1), new Square(1), new Square(1), new Square(1), new Square(1)}};
    private static int[][] nums = new int[5][5];
    
     public static void main(String[] args)
        {
		JFrame frame= new JFrame("JavaTutorial.net");	
		frame.getContentPane().add(new PennyPitchJFrame());
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
                
                
                    
                    
        }

	public void paint(Graphics g)
        {
		g.drawString(storeBoard().substring(0,11), 100, 80);
                g.drawString("\n" + storeBoard().substring(11, 21), 100,100);
                g.drawString("\n" + storeBoard().substring(21, 32), 100,120);
                g.drawString("\n" + storeBoard().substring(32, 42), 100,140);
        }
	
	
    public static String storeBoard()
    {
        String str = "";
        for(int j  = 0; j < squares.length; j++)
        {
            for(int i = 0; i < squares[j].length; i++)
            {
                str+= squares[j][i] + " ";
            }
            str += "\n";
        }
        return str;
    }
    //makes sure each iteration produces a 'P' in a different location on the board
    public static Boolean guessedCoord(int row, int col, int[][] stored)
    {
        if(guessedRow(row,stored) && guessedCol(col, stored))
        {
            return true;
        }
        return false;
    }
    public static Boolean guessedRow(int row, int[][]stored)
    {
        for(int j = 0; j < stored[0].length; j++)
        {
            if(stored[0][j] == row)
            {
                return true;
            }
            
        }
        return false;
    }
    public static Boolean guessedCol(int col, int[][]stored)
    {
        for(int j = 0; j < stored[0].length; j++)
        {
            if(stored[1][j] == col)
            {
                return true;
            }
            
        }
        return false;
    }
    
        
}