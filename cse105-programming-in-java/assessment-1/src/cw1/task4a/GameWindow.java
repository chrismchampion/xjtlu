/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1.task4a;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author christopher
 */
public class GameWindow extends JFrame implements ActionListener {

    // private class variables
    private JLabel totalScoreLabel;
    private JLabel scoreLabel;
    // Instantiate game
    private Game game = new Game();

    public GameWindow() {

        // Constructor calls initialize method to set game window (JFrame) properties
        init();
    }

    public void init() {
        // Set this JFrame's properties
        this.setVisible(true);
        this.setSize(1000, 200);
        this.setResizable(false);
        this.setTitle("Dice Game v.1");
        // Auto add components left to right, top to bottom
        this.setLayout(new FlowLayout());
        // End program run on window close
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add button
        JButton button = new JButton();
        button.setText("Roll the dice!");
        this.add(button);
        // ActionListener for button click
        button.addActionListener(this);

        // Add total score label
        totalScoreLabel = new JLabel();
        totalScoreLabel.setText("Total Score: 0");
        totalScoreLabel.setVisible(true);
        this.add(totalScoreLabel);

        // Add (current round) score label
        scoreLabel = new JLabel();
        scoreLabel.setText("Score: 0");
        scoreLabel.setVisible(true);
        this.add(scoreLabel);

        // Start game with row of 4 dice "res/die-1.png"
        this.add(game.getDiceArray()[0].getDiceLabel());
        this.add(game.getDiceArray()[1].getDiceLabel());
        this.add(game.getDiceArray()[2].getDiceLabel());
        this.add(game.getDiceArray()[3].getDiceLabel());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Remove previous dice labels from the JFrame on button click
        for (Dice die : game.getDiceArray()) {
            this.getContentPane().remove(die.getDiceLabel());
        }

        // Assign random value 1-6 to each die in the Dice[]
        game.getDiceArray()[0].roll();
        game.getDiceArray()[1].roll();
        game.getDiceArray()[2].roll();
        game.getDiceArray()[3].roll();

        // Get corresponding dice image from res folder and set as new JLabel
        game.updateDiceLabels();
        // Call to update score and total score values
        game.calculateScore();

        // Add updated dice JLabels to this JFrame
        this.add(game.getDiceArray()[0].getDiceLabel());
        this.add(game.getDiceArray()[1].getDiceLabel());
        this.add(game.getDiceArray()[2].getDiceLabel());
        this.add(game.getDiceArray()[3].getDiceLabel());

        // Set this JFrame's score and total score JLabels with updated toString values
        this.scoreLabel.setText("Score: " + game.getScoreToString());
        this.totalScoreLabel.setText("Total Score: " + game.getTotalScoreToString());

        // Call to repaint() refreshes the JFrame with added components
        repaint();

        // TEST PRINTS ROLL VALUES IN THE CONSOLE
        /*for (int i = 0; i < newGame.getDiceArray().length; i++) {
            System.out.print(newGame.getDiceArray()[i].getRandomVal() + " ");
        }
        System.out.print(" Your score: " + newGame.getScoreToString());
        System.out.println();*/
    }

}
