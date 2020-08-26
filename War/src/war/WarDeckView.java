/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
;
import javax.swing.*;import javax.swing.*;

/**
 *
 * @author mercyougothis
 */
public class WarDeckView extends JFrame
{
    WarModel model;
    ImagePanel panel;
    Deck deck = new Deck("cards");
    private JButton deal = new JButton("Deal");
    private JButton reset = new JButton("Reset");
    private int countPressed = 0;
    
    public WarDeckView(WarModel m)
    {
        model = m;
        //this.setLayout(new GridLayout(2,1));
        panel = new ImagePanel(new ImageIcon("cards\\10D.png"));
        
        JPanel southPanel = new JPanel();
        southPanel.setSize(300,20);
        Container container = this.getContentPane();
        
        container.add(panel, BorderLayout.NORTH);
        container.add(panel, BorderLayout.CENTER);
        container.add(southPanel, BorderLayout.SOUTH);

        southPanel.add(deal);
        southPanel.add(reset);
        
        deal.addMouseListener(new DealListener());
        reset.addMouseListener(new ResetListener());
        
        this.setSize(300,600);
        panel.setSize(this.getWidth(),this.getHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);
        
        
    }
     public static void main(String args[])
   {
       WarModel model = new WarModel();
       WarDeckView view = new WarDeckView(model);
   }
    private class DealListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent me) 
        {
            if(countPressed != 52)
            {
                Card arr[] = deck.deal(1);
                countPressed++;
                Card currCard = arr[0];
                //panel.setImage(new ImageIcon("cards\\10C.png"));
                panel.setImage(new ImageIcon(currCard.getFullPath()));
            }
            else
            {
                JOptionPane.showMessageDialog(panel, "All cards have been dealt. Please press reset to play again"); 
                countPressed = 0;
            }       
        }
        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}

        @Override
        public void mouseEntered(MouseEvent me) {}

        @Override
        public void mouseExited(MouseEvent me) {}        
    }
    private class ResetListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent me) 
        {
            
            panel.setImage(new ImageIcon(""));
            deck = new Deck("cards");
        }
        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}

        @Override
        public void mouseEntered(MouseEvent me) {}

        @Override
        public void mouseExited(MouseEvent me) {}        
    }

}
 