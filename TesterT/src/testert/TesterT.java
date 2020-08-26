/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testert;

import java.util.ArrayList;

/**
 *
 * @author mercyougothis
 */
public class TesterT 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //int out = 0;
        int[] intArr = {66, 22, 11, 44, 55, 33, 77};
       System.out.println(monkey(intArr));
       
    }
    public static ArrayList<Integer> monkey(int[] list)
    {
      ArrayList<Integer> list2= new ArrayList<Integer>();
      for(int p = 0; p < list.length; p++)
      {
          int temp = list[p];
          for(int q = p; q < list.length; q++)
              if(list[q] < temp)
                  temp = list[q];
          list2.add(new Integer(temp));
      }
      return list2;
    }
    
    
}
