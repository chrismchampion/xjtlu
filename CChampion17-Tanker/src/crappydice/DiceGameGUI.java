/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crappydice;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author christopher
 */
public class DiceGameGUI extends JFrame implements ActionListener {

    // private class variables
    private int[] dice;
    private int[] score;
    private int points;
    private int clicks = 0;
    private JLabel diceLabel1;
    private JLabel diceLabel2;
    private JLabel diceLabel3;
    private JLabel diceLabel4;

    public static void main(String[] args) {

        // Call constructor
        DiceGameGUI game1 = new DiceGameGUI();
    }

    public DiceGameGUI() {

        // Initialize window
        init();

        // Initialize vars with 0
        this.points = 0;
        // Set array size to 4 for the four die
        dice = new int[4];
        score = new int[6];
    }

    private void init() {
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Dice 1.0");
        this.setLayout(new FlowLayout());
        //screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(1000, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add four dice 1
        for (int i = 0; i < 4; i++) {
            ImageIcon imgIcon = new ImageIcon("res/die-1.png");
            JLabel label = new JLabel(imgIcon);
            label.setBounds(10, 10, 100, 100);
            label.setVisible(true);
            this.add(label);
        }

        JButton button = new JButton();
        button.setText("Roll the dice!");
        this.add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (clicks > 0) {
            this.getContentPane().remove(diceLabel1);
            this.getContentPane().remove(diceLabel2);
            this.getContentPane().remove(diceLabel3);
            this.getContentPane().remove(diceLabel4);
        }
        clicks++;
        roll(dice);
        getScore(dice);

        revalidate();
        repaint();

    }

    public void addLabel1() {
        ImageIcon imgIcon = new ImageIcon("res/die-" + dice[0] + ".png");
        diceLabel1 = new JLabel(imgIcon);
        diceLabel1.setBounds(10, 10, 100, 100);
        diceLabel1.setVisible(true);
        this.add(diceLabel1);
    }

    public void addLabel2() {
        ImageIcon imgIcon = new ImageIcon("res/die-" + dice[1] + ".png");
        diceLabel2 = new JLabel(imgIcon);
        diceLabel2.setBounds(10, 10, 100, 100);
        diceLabel2.setVisible(true);
        this.add(diceLabel2);
    }

    public void addLabel3() {
        ImageIcon imgIcon = new ImageIcon("res/die-" + dice[2] + ".png");
        diceLabel3 = new JLabel(imgIcon);
        diceLabel3.setBounds(10, 10, 100, 100);
        diceLabel3.setVisible(true);
        this.add(diceLabel3);
    }

    public void addLabel4() {
        ImageIcon imgIcon = new ImageIcon("res/die-" + dice[3] + ".png");
        diceLabel4 = new JLabel(imgIcon);
        diceLabel4.setBounds(10, 10, 100, 100);
        diceLabel4.setVisible(true);
        this.add(diceLabel4);
    }

    private void roll(int[] diceArray) {
        
        for (int i = 0; i < diceArray.length; i++) {
            // Initialize each die with random from 1-6
            diceArray[i] = (int) (Math.random() * 6 + 1);
            System.out.print(diceArray[i] + " ");

        }
        addLabel1();
        addLabel2();
        addLabel3();
        addLabel4();
    }

    private void getScore(int[] diceArray) {
        //score = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < score.length; i++) {
            score[i] = 0;
        }
        for (int j = 1; j <= 6; j++) {

            for (int i = 0; i <= 3; i++) {

                if (diceArray[i] == j) {
                    score[j - 1]++;
                }
            }
        }
        for (int s = 0; s < score.length; s++) {
            if (score[s] > 1) {
                points = score[s];
            }
        }
        System.out.println("\nYour score = " + points);
        // Reset points for next roll
        points = 0;
    }

}