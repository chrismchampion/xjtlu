/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw1.task4a;

/**
 *
 * @author christopher
 */
public class Game {

    // private class variables
    private int score;
    private int totalScore;
    private Dice[] diceArray;
    private String scoreToString;

    public Game() {

        // Score and totalScore initialized with 0 for new instance of Game()
        this.score = 0;
        this.totalScore = 0;

        // Initialize dice with image of die 1
        String diceLabel = "res/die-1.png";
        this.diceArray = new Dice[4];
        this.diceArray[0] = new Dice(diceLabel);
        this.diceArray[1] = new Dice(diceLabel);
        this.diceArray[2] = new Dice(diceLabel);
        this.diceArray[3] = new Dice(diceLabel);
    }

    // Package access for call in GameWindow.java
    protected void calculateScore() {

        // Reset scoreArray to 0 every time calculateScore() is called
        int[] scoreArray = {0, 0, 0, 0, 0, 0};

        // dieVal is 1 - 6 (loop 6 times)
        for (int dieVal = 1; dieVal <= scoreArray.length; dieVal++) {
        // for diceArray[0] to diceArray[3] (loop 4 times)
            for (int index = 0; index < diceArray.length; index++) {
                // If int value at diceArray index equals 1...6
                if (diceArray[index].getRandomVal() == dieVal) {
                    // Increment value of scoreArray at index dieVal-1 by 1, e.g,
                    // diceArray[1,1,1,1] = scoreArray[4,0,0,0,0,0]
                    // diceArray[1,3,3,4] = scoreArray[1,0,2,1,0,0]
                    scoreArray[dieVal - 1]++;
                }
            }
        }
        // Iterate through scoreArray
        for (int index = 0; index < scoreArray.length; index++) {
        // If scoreArray at any index contains int value 2 or more
            if (scoreArray[index] > 1) {
                // then 2 or more numbers match. Assign value at index to score.
                score = scoreArray[index];
            }
        }
        // Increment total score with the value of score
        totalScore += score;
        // Assign score to String var before resetting it for the next round
        scoreToString = Integer.toString(score);
        // Reset score for the next roll
        score = 0;
    }

    // Package access for call in GameWindow.java
    protected void updateDiceLabels() {
        // Get .png file from res folder based on random dice value 1 - 6
        diceArray[0].setDiceLabel("res/die-" + diceArray[0].getRandomVal() + ".png");
        diceArray[1].setDiceLabel("res/die-" + diceArray[1].getRandomVal() + ".png");
        diceArray[2].setDiceLabel("res/die-" + diceArray[2].getRandomVal() + ".png");
        diceArray[3].setDiceLabel("res/die-" + diceArray[3].getRandomVal() + ".png");
    }

    // GETTER METHODS
    public Dice[] getDiceArray() {
        return diceArray;
    }

    public String getScoreToString() {
        return scoreToString;
    }

    public String getTotalScoreToString() {
        return Integer.toString(totalScore);
    }
}
