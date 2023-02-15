/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.zoo;

/**
 *
 * @author christopher
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ZooWindow extends Frame implements Runnable {

    Dimension screenSize;
    private Sprite[] sprites = new Sprite[10];
    private int spriteCounter = 0;

    //Constructor
    public ZooWindow() {
        //myOwner = zoo;
        init();

    }

    public void addSprite(String imagePath, Point location, Dimension size, Dimension bounds, int speed) {
        Sprite sprite = new Sprite(imagePath, location, size, bounds, speed);    //note the additional argument: screenSize
        if (spriteCounter < sprites.length) {
            sprites[spriteCounter] = sprite;
            System.out.println("Sprite added at index: " + spriteCounter);
            spriteCounter++;
        } else {
            System.out.println("Sprite not added to sprite array; array full");
        }
    }

    private void init() {
        this.setVisible(true);
        this.setLayout(null);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screenSize.width, screenSize.height);
        this.setBackground(Color.green);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }

    @Override
    public void run() {

        while (true) {
            for (int i = 0; i < spriteCounter; i++) {
                sprites[i].move();
            }
            repaint();
            try {
                // Number of milliseconds the thread will cease execution
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        for (int i = 0; i < spriteCounter; i++) {
            sprites[i].paintSprite(graphics, this);
        }
    }
}
