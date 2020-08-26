/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testscoresappconsole;

/**
 *
 * @author mercyougothis
 */
public class TestScoresAppConsole 
{
    public static void main(String[] args)
    {
        TestScoresModel model = new TestScoresModel();
        TestScoresView testScoresView = new TestScoresView(model);
    }
    
}
