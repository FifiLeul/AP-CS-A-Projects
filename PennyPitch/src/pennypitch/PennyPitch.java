/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennypitch;

import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author mercyougothis
 */
public class PennyPitch 
{
    private static Square[][] squares =
                 {{new Square(1), new Square(1), new Square(1), new Square(1), new Square(1)}, 
                  {new Square(1), new Square(2), new Square(2), new Square(2), new Square(1)},
                  {new Square(1), new Square(2), new Square(3), new Square(2), new Square(1)}, 
                  {new Square(1), new Square(2), new Square(2), new Square(2), new Square(1)},
                  {new Square(1), new Square(1), new Square(1), new Square(1), new Square(1)}};
    
    private static int[][] nums = new int[5][5];
    
    
    public static void main(String[] args) 
    {
        
        int option = -1;
        
        while(option != 1)
        {
            run();
            option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", " press y/n", JOptionPane.YES_NO_OPTION);
        }

    }
    public static void run()
    {
        nums[0] = new int[]{1,1,1,1,1};
        nums[1] = new int[]{1,2,2,2,1};
        nums[2] = new int[]{1,2,3,2,1};
        nums[3] = new int[]{1,2,2,2,1};
        nums[4] = new int[]{1,1,1,1,1}; 
        Random row = new Random();
        Random column = new Random();
        int score = 0;
        JOptionPane.showMessageDialog(null, storeBoard());
        int currentGain = 0;
        int[][] usedCoords = new int[2][5];
        for(int j = 0; j < 5; j++)
        {
            int r = 0;
            int c = 0;
            while(guessedCoord(r,c,usedCoords))
            {
                r = row.nextInt((4 - 0) + 1) + 0;
                c = row.nextInt((4 - 0) + 1) + 0;
            }
            usedCoords[0][j] = r;
            usedCoords[1][j] = c;
            score += squares[r][c].getLabel();
            currentGain = squares[r][c].getLabel();
            squares[r][c].pennyLanded(true);
            
            if(j == 4)
            {
                JOptionPane.showMessageDialog(null,  storeBoard() + "\nPoints gained this toss: " + currentGain + "\n**FinalScore: " + score +"**"); 
            }
            else
                JOptionPane.showMessageDialog(null,  storeBoard() + "\nPoints gained this toss: " + currentGain);
        }
            reset();
            storeBoard();
            
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
    public static void reset()
    {
         Square[][] resetter =
                 {{new Square(1), new Square(1), new Square(1), new Square(1), new Square(1)}, 
                  {new Square(1), new Square(2), new Square(2), new Square(2), new Square(1)},
                  {new Square(1), new Square(2), new Square(3), new Square(2), new Square(1)}, 
                  {new Square(1), new Square(2), new Square(2), new Square(2), new Square(1)},
                  {new Square(1), new Square(1), new Square(1), new Square(1), new Square(1)}};
         squares = resetter;
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
