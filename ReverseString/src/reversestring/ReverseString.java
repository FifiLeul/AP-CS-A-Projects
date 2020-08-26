/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversestring;

/**
 *
 * @author mercyougothis
 */
public class ReverseString 
{

    public static void main(String[] args)
    {
        System.out.println("Blanks: \n\t" + check("","",1));
        
        System.out.println("Completely reversed: \n\t"    + check("hello", "olleh", 0) + "\n\t"
                                                          + check("MadamImAdam","madAmImadaM", 0) + "\n\t"
                                                          + check("hell\no", "o\nlleh", 0) + "\n\t"
                                                          + check("ylrae", "early", 0) +"\n\t"
                                                          + check("!_hi_!", "!_ih_!", 0));
        
        System.out.println("Out of bounds: \n\t"          + check("crazy","", 20) +"\n\t"
                                                          + check(" ","", 3));
        
        System.out.println("Spliced and reversed: \n\t"   + check("computer group", "puorg retu", 4) +"\n\t" 
                                                          + check("racecaR","Rac", 4) + "\n\t"
                                                          + check("question mark", "kram noit", 4) +"\n\t"
                                                          + check("civiC","Civ", 2) +"\n\t"
                                                          + check("10001","100", 2));
        
        System.out.println("Characters and numbers: \n\t" + "Standard Characters: \n\t\t"
                                                          + check("90fs%^31", "13^%s", 3) +"\n\t\t"
                                                          + check("%^&*", "*&^%", 0) + "\n\t"
                                                          + "Escape Characters: \n\t\t" 
                                                          + check("($56&)\t\\\n", "\n\\\t)&65$(", 0) + "\n\t\t"
                                                          + check("\"racecaR\"", "\"Rac", 5));
    }
    public static String reverse(String s, int index)
    {
        if(index < 0 || index > s.length())
            throw new IndexOutOfBoundsException("Negative index");
        if(index == s.length()-1)
            return Character.toString(s.charAt(s.length()-1));
        if(index + 1 > s.length()-1)
            return "";
        return reverse(s.substring(index + 1), 0) + Character.toString(s.charAt(index));
    }
    public static String check(String s, String s2, int index)
    {
        String reversed = "";
       try
       {
           reversed = reverse(s,index);
           if(s2.equals("") && !reversed.equals(""))
            return "FAILED: index of" + index + " is too large for"  + s;
        if(reversed.equals(s2) == false)
            return "FAILED: " + s2 + " is NOT the same as "  + reverse(s, index);
       }
       catch(IndexOutOfBoundsException e)
       {
           return "FAILED: index out of bounds: " + s + " reversed at index " + index;
       }
        return "passed: " + s2 + " is the same as " + s + " reversed at index " + index;  
    }
 
}
