/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1.task4a;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author christopher
 */
public class Dice {

    // private class variables
    private int randomVal;
    private JLabel diceLabel;

    public Dice(String pImagePath) {

        // Constructor creates new ImageIcon and passes it to create new JLabel
        ImageIcon diceImage = new ImageIcon(pImagePath);
        this.diceLabel = new JLabel(diceImage);
        this.diceLabel.setVisible(true);
    }

    // Package access for call in GameWindow.java
    protected void roll() {
        this.randomVal = (int) (Math.random() * 6 + 1);
    }

    // SETTER METHODS
    public void setDiceLabel(String pImagePath) {
        ImageIcon diceImage = new ImageIcon(pImagePath);
        this.diceLabel = new JLabel(diceImage);
    }

    // GETTER METHODS
    public int getRandomVal() {
        return randomVal;
    }

    public JLabel getDiceLabel() {
        return diceLabel;
    }

}
