/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cse110_swing;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author christopher
 */
public class CSE110_Swing extends JFrame {

    JPanel content;
    JLabel pic;
    JLabel caption;
    JButton button;
    
    public CSE110_Swing() {
    
        super("Picture Greeting");
        
        content = new JPanel();
        content.setLayout(new BorderLayout());
        pic = new JLabel(new ImageIcon("img/th.jpeg"));
        //pic.setEnabled(false);
        pic.setVisible(false);
        button = new JButton();
        button.setText("blah blah blah blah blah blah blah blah blah");
        caption = new JLabel("Hello");
        content.add(pic);
        content.add(button, BorderLayout.PAGE_END);
        content.add(caption, BorderLayout.NORTH);
        
        JRootPane rp = super.getRootPane();
        rp.
        setContentPane(content);
        setSize(100,100);
        //pack();
        //setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new CSE110_Swing();
    }
    
}
