package student2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mercyougothis
 */
public class TestScoresApp 
{
    public static void main(String[] args)
    {
        TestScoresModel model = new TestScoresModel();
        new TestScoresView(model);
    }
}
