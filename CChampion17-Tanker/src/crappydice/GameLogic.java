/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crappydice;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author christopher
 */
public class GameLogic {

    // private class variables
    private static int[] diceArray;
    private int score;
    private String scoreString;
    private String totalScoreString;
    private int totalScore;
    protected static JLabel diceLabel1, diceLabel2, diceLabel3, diceLabel4;

    public GameLogic() {

        // Initialize score and totalScore with 0
        this.score = 0;
        this.totalScore = 0;
        // Initialize array size with number of die
        diceArray = new int[4];

    }

    protected static void roll(int[] diceArray) {

        for (int i = 0; i < diceArray.length; i++) {
            // Initialize each die with random from 1-6
            diceArray[i] = (int) (Math.random() * 6 + 1);
            System.out.print(diceArray[i] + " ");
        }
    }

    protected void getScore(int[] diceArray) {

        int[] scoreArray = {0, 0, 0, 0, 0, 0};
        for (int j = 1; j <= 6; j++) {

            for (int i = 0; i <= 3; i++) {

                if (diceArray[i] == j) {
                    // Subtract 1 to increment the value at the index
                    scoreArray[j - 1]++;
                }
            }
        }
        for (int s = 0; s < scoreArray.length; s++) {
            if (scoreArray[s] > 1) {
                //this.score = scoreArray[s];
                score = scoreArray[s];
            }
        }
        totalScore += score;
        totalScoreString = Integer.toString(totalScore);
        System.out.println("Your score = " + score);

        // Assign score to points for point out before reseeting it
        scoreString = Integer.toString(score);
        // Reset points for next roll
        score = 0;
    }

    public static JLabel createDiceLabel(int index) {
        ImageIcon imgIcon = new ImageIcon("res/die-" + diceArray[index] + ".png");
        JLabel diceLabel = new JLabel(imgIcon);
        diceLabel.setVisible(true);
        return diceLabel;
    }
    
    public static JLabel[] getDiceLabels() {
        JLabel[] arr = {diceLabel1, diceLabel2, diceLabel3, diceLabel4};
        return arr;
    }

    public String getScoreString() {
        return scoreString;
    }

    public String getTotalScoreString() {
        return totalScoreString;
    }

    public int[] getDiceArray() {
        return diceArray;
    }
}
