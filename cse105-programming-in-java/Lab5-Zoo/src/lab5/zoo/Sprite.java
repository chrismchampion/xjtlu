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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author joelewis
 */
public class Sprite {

    Point location;
    Dimension size;
    Dimension bounds;
    int speed;
    private BufferedImage myImage;
    // Number of pixels to increment/decrement when the move method is called
    private int moveX = 1, moveY = -1;

    public Sprite(String imagePath, Point loc, Dimension size, Dimension bounds, int speed) {
        loadImage(imagePath);
        this.location = loc;
        this.size = size;
        this.bounds = bounds;
        //this.speed = speed;
        this.moveX = speed;
        this.moveY = speed;
    }

    private void loadImage(String imagePath) {
        try {
            myImage = ImageIO.read(new File(imagePath));
            System.out.println("image loaded");
        } catch (IOException e) {
            System.out.println("Sprite: problem loading image");
            e.printStackTrace();
        }
    }

    public void move() {
        
        location.x = location.x + moveX;
        location.y = location.y + moveY;
        
        // Reverse direction if image reaches right edge of screen minus image width
        if (location.x >= bounds.width-size.width) {
            moveX = moveX * -1;
        }
        // Reverse direction if image reaches left edge of screen
        if (location.x <= 0) {
            moveX = moveX * -1;
        }
        
        // Reverse direction if image reaches bottom edge of screen minus image height
        if (location.y >= bounds.height-size.height) {
            moveY = moveY * -1;
        }
        // Reverse direction if image reaches top edge of screen
        if (location.y <= 0) {
            moveY *= -1;
        }
    }

    public void paintSprite(Graphics g, ImageObserver io) {
        g.drawImage(myImage, location.x, location.y, size.width, size.height, io);
        //System.out.println("Sprite paint called");
    }
    
    public void getSpeed() {
        // return Sprite's speed value to be passed to thread
    }

}
