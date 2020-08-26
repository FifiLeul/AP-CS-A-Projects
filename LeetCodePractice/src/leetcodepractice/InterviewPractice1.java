/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodepractice;

/**
 *
 * @author mercyougothis
 */
public class InterviewPractice1 
{
    public static void main(String[] args)
    {
        System.out.println(checkRecord("PPALLP"));
    }
    public static String reverseBits(String n)
    {
        int value = 0;
        String str = (n + "");
        String reversed = "";
        
        for(int j = str.length() - 1; j > -1; j--)
            reversed += str.charAt(j);
        return reversed;
    }
    public static boolean checkRecord(String s)
    {
        int countA = 0;
        int countLL = 0;
        
        while(s.contains("A"));
        {
            countA++;
            s.replace("A", "");
        }
        while(s.contains("LL"))
        {
            countLL++;
            s.replace("LL", "");
        }
        
        return countA < 2 && countLL < 3;
    }
}
