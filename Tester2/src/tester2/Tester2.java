/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester2;

/**
 *
 * @author mercyougothis
 */
public class Tester2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        int a[] = new int[]{1,2,3,4,5,6};
        System.out.println(search(a, 7));
    }
    static int search (int[] a, int searchValue)
    { 
        for (int i = 0; i <  a.length; i++)
        {
            if (a[i] = searchValue)
            {
                return i;
            } return -1; }
    }   
}
