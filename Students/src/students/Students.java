/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package students;

import java.util.ArrayList;

/**
 *
 * @author mercyougothis
 */
public class Students {

    public Students(int grade)
    {
        this.grade = grade;
    }
    private int grade;
    public boolean compareTo(Object s)
    {
        return true;//(Students) s.grade == grade;
    }
    public static void main(String[] args)
    {
       
    }
    
    
}
