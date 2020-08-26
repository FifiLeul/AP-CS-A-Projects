/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addcommas;

/**
 *
 * @author mercyougothis
 */
public class AddCommas 
{

    public static void main(String[] args)
    {
        System.out.println("All zeroes: \n\t"            + check(000, "0"));
        System.out.println("10^x (until error): \n\t"    + check(10, "10") + "\n\t"
                                                         + check(100, "100") + "\n\t"
                                                         + check(1000, "1,000") + "\n\t"
                                                         + check(10000, "10,000") + "\n\t"
                                                         + check(100000, "100,000") + "\n\t"
                                                         + check(1000000, "1,000,000") + "\n\t"
                                                         + check(10000000, "10,000,000") + "\n\t"
                                                         + check(100000000, "100,000,000") + "\n\t"
                                                         + check(1000000000, "1,000,000,000") + "\n\t");
        
        System.out.println("Non-zero numbers (until error): \n\t"  + check(1, "1") + "\n\t"
                                                         + check(23, "23") + "\n\t"
                                                         + check(324, "324") + "\n\t"
                                                         + check(2546, "2,546") + "\n\t"
                                                         + check(90874, "90,874") + "\n\t"
                                                         + check(534565, "534,565") + "\n\t"
                                                         + check(4425353, "4,425,353") + "\n\t"
                                                         + check(94265983, "94,265,983") + "\n\t" 
                                                         + check(589125873, "589,125,873") + "\n\t");
        
        System.out.println("Zeroes and non-zeroes: \n\t" + check(23100, "23,100") + "\n\t"
                                                         + check(3560000, "3,560,000") + "\n\t"
                                                         + check(410, "410"));
        
        System.out.println("Negatives: \n\t"             + check(-100, "-100") + "\n\t"
                                                         + check(-25462153, "-25,462,153") + "\n\t"
                                                         + check(-14331, "-14,331"));
        
        
    }
  
    public static String addCommas(int i)
    {
        String str = "";
        if(i <= 0)
            throw new IllegalArgumentException("Negative input");   
        if(i%1000 == 0)
            str = ",000";
        else if(i > 1000)
            str = "," + i % 1000;

        else if(i < 1000)
            return i+"";
        return  addCommas(i/1000) + str;
    }
    public static String check(int i, String s2)
    {
       try
       {
        if(addCommas(i).equals(s2))
            return "PASS: " + addCommas(i) +" is equal to " + s2;
       }
       catch(IllegalArgumentException e)
       {
           return "FAIL: bad input";
       }
        return "FAIL: " + addCommas(i) +" is not equal to " + s2 ;
    }
}
