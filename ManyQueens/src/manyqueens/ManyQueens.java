/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manyqueens;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author mercyougothis
 */
public class ManyQueens
{
    static ArrayList <Integer> storeQueens = new ArrayList<Integer>();
    static ArrayList <Integer> storeRecursionsQueens = new ArrayList<Integer>();
    static ArrayList <Integer> storeRecursionsAttacked = new ArrayList<Integer>();
    static int countQueens;
    static int countRecursionsQueens;
    static int countRecursionsAttacked;
    static int boardSize; 
    static boolean[][] board;

    public static void main(String[] args)
    { System.out.println(108%120);
        /*Scanner reader = new Scanner(System.in);
        System.out.print("Enter the board size: ");
        boardSize = reader.nextInt();
        board = new boolean[boardSize][boardSize];*/

        for(int j = 0; j <= 10; j++)
        {
            play(j);
            
            storeQueens.add(countQueens);
            storeRecursionsQueens.add(countRecursionsQueens);
            storeRecursionsAttacked.add(countRecursionsAttacked);
            
            countQueens = 0;
            countRecursionsQueens = 0;
            countRecursionsAttacked = 0;
        }
        print();
        
    }
    public static void print()
    {
        System.out.println("**********QUEENS***************");
        for(Integer i: storeQueens)
            System.out.println(i);
        System.out.println("**********RECURSIONS(QUEENS)***********");
        for(Integer i: storeRecursionsQueens)
            System.out.println(i);
        System.out.println("*********RECURSIONS(ATTACKED)**********");
        for(Integer i: storeRecursionsAttacked)
            System.out.println(i);
    }
    public static void play(int j )
    {
        boardSize = j;
        board = new boolean[boardSize][boardSize];
        
        for(int row = 0; row < boardSize; row++)
            for(int col = 0; col < boardSize; col++)
                board[row][col] = false;
        if(! canPlaceQueen(0,board))
            System.out.println("Impossible on a board of size " + 
                               boardSize  +"x" + boardSize);
        else
        {
            System.out.println("Here is a solution for a board of size " 
                               + boardSize + "x" + boardSize);
            for(int row = 0; row < boardSize; row++)
            {
                for(int col = 0; col < boardSize; col++)
                {
                    /*if(board[row][col])
                        System.out.print("Q");
                    else
                        System.out.print("-");*/
                }
                //System.out.println();
            }
        }
    }
    public static boolean canPlaceQueen(int col, boolean[][] board)
    {
        countRecursionsQueens++;
        for(int row = 0; row < board.length; row++)
        {
            if(!attacked(row,col,board))
            {
                if(col == board.length - 1)
                { 
                    board[row][col] = true;
                    countQueens++;
                return true;
                }
                else
                {
                    board[row][col]= true;
                    if(canPlaceQueen(col + 1, board))
                    {
                        countQueens++;
                        return true;
                    }
                    else
                        board[row][col] = false;
                }
            }
        }
        return false;
    }
    public static boolean attacked(int row, int col, boolean[][] board)
    {
        countRecursionsAttacked++;
        int i, j, k;
        for(j = 0 ; j < col; j++)
            if(board[row][j])
                return true;
        i = row -1;
        j = col - 1;
        for(k =0; k <= Math.min(i,j);k++)
        {
            if(board[i][j])
                return true;
            else
            {
                i--; j--;
            }
        }
        i = row + 1;
        j = col - 1;
        for(k = 0 ; k <= Math.min(board.length - i - 1, j); k++)
        {
            if(board[i][j])
                return true;
            else
            {
                i++; j--;
            }
        }      
        return false;
    }
}
    

