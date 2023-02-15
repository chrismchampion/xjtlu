/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myzoo;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Container;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author joelewis
 */
public class ImageDisplay extends Container {
    Point location;
    Dimension size;
    BufferedImage myImage;
    
    
    //Constructor
    public ImageDisplay(String imagePath, Point loc, Dimension size){
        this.location = loc;
        this.size = size;
        loadImage(imagePath);
    }
    
    private void loadImage(String imagePath){     
        try {
            myImage = ImageIO.read(new File(imagePath));
            System.out.println("ImageDisplay: image loaded");
        } catch (IOException e) {
            System.out.println("ImageDisplay: problem loading image");
            e.printStackTrace();
        }
    }
    
    @Override
    public void paint(Graphics g){
        //NOTE: the image is scaled for each paint call - wasteful!?
        g.drawImage(myImage, 0, 0, size.width, size.height, this);
        //System.out.println("Sprite paint called");
    }

    
    
}
