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
public class GameWindow extends JFrame implements ActionListener {

    public JLabel scoreLabel;
    private JLabel totalScoreLabel;
    int clicks = 0;
    GameLogic logic = new GameLogic();

    public GameWindow() {
        // Constructor calls method to initialize window
        init();
    }

    public void init() {
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Dice 1.0");
        this.setLayout(new FlowLayout());
        //screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(1000, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scoreLabel = new JLabel();
        scoreLabel.setText("Score: 0");
        scoreLabel.setVisible(true);
        this.add(scoreLabel);

        totalScoreLabel = new JLabel();
        totalScoreLabel.setText("Total Score: 0");
        totalScoreLabel.setVisible(true);
        this.add(totalScoreLabel);

        JButton button = new JButton();
        button.setText("Roll the dice!");
        this.add(button);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Each time the roll button is clicked...
        
        // 1. Remove previous round dice (JLabels) from the frame
        if (clicks > 0) {
            for (JLabel diceLabel : GameLogic.getDiceLabels()) {
                this.getContentPane().remove(diceLabel);
            }
        }
        clicks++;

        // 2. Roll the dice - generates random 1-6 for the length of diceArray and assigns to index 0 - 3 in the diceArray
        GameLogic.roll(logic.getDiceArray());

        
        // 3. Add dice (JLabels) to the frame
        GameLogic.diceLabel1 = GameLogic.createDiceLabel(0);
        this.add(GameLogic.diceLabel1);
        GameLogic.diceLabel2 = GameLogic.createDiceLabel(1);
        this.add(GameLogic.diceLabel2);
        GameLogic.diceLabel3 = GameLogic.createDiceLabel(2);
        this.add(GameLogic.diceLabel3);
        GameLogic.diceLabel4 = GameLogic.createDiceLabel(3);
        this.add(GameLogic.diceLabel4);

        //logic.getScore(GameLogic.diceArray);
        logic.getScore(logic.getDiceArray());

        this.scoreLabel.setText("Score: " + logic.getScoreString());
        this.totalScoreLabel.setText("Total Score: " + logic.getTotalScoreString());

        revalidate();
        repaint();
    }

}
