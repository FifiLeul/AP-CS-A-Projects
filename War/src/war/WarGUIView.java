package war;


import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mercyougothis
 */
public class WarGUIView extends JFrame
{
    private WarModel model;
    private JButton playButton = new JButton("play!");
    private JButton resetButton = new JButton("reset");
    private JLabel p1Label = new JLabel("Player 1");
    private JLabel p2Label = new JLabel("Player 2");
    private JLabel card1Label = new JLabel("Card: ");
    private JLabel card2Label = new JLabel("Card: ");
    
    private JTextField p1Field = new JTextField(" Put a name here ");
    private JTextField p2Field = new JTextField(" Put a name here ");
    private JTextField card1Field = new JTextField("Not played yet     ");
    private JTextField card2Field = new JTextField("Not played yet     ");
    
    public WarGUIView(WarModel m)
    {
        model = m;
        card1Field.setEditable(false);
        card2Field.setEditable(false);
        p1Field.setEditable(true);
        p2Field.setEditable(true);
        
        card1Field.setBackground(Color.white);
        card2Field.setBackground(Color.white);
        p1Field.setBackground(Color.white);
        p2Field.setBackground(Color.white);
        
        JPanel northPanel = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();
        
        Container container = this.getContentPane();
        container.add(northPanel, BorderLayout.NORTH);
        container.add(centerPanel, BorderLayout.CENTER);
        container.add(southPanel, BorderLayout.SOUTH);
        
        northPanel.add(p1Label);
        northPanel.add(p1Field);
        northPanel.add(card1Label);
        northPanel.add(card1Field);
        
        centerPanel.add(p2Label);
        centerPanel.add(p2Field);
        centerPanel.add(card2Label);
        centerPanel.add(card2Field);
        southPanel.add(playButton);
        southPanel.add(resetButton);
        
        playButton.addMouseListener(new PlayListener());
        resetButton.addMouseListener(new ResetListener());
        setTitle("War GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    public static void main(String args[])
   {
       WarModel model = new WarModel();
       WarGUIView view = new WarGUIView(model);
   }
    private class PlayListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent me) 
        {
            model.setPlayers(p1Field.getText(), p2Field.getText());
            model.play();
            if(model.gameWon())
            {
                card1Field.setText("   "+ model.card1());
                card2Field.setText("    " + model.card2());
                JOptionPane.showMessageDialog(WarGUIView.this, model.getWinner());
                return;
            }
            card1Field.setText(model.card1());
            card2Field.setText(model.card2());
            JOptionPane.showMessageDialog(WarGUIView.this, model.getRoundWinner());
                
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
            model = new WarModel();
            p1Field.setText(" Put a name here ");
            p2Field.setText(" Put a name here ");
            card1Field.setText("   Not played yet     ");
            card2Field.setText("   Not played yet     ");
         
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
