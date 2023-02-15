/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.zoo;

import java.awt.Dimension;
import java.awt.Point;


/**
 *
 * @author christopher
 */
public class Lab5Zoo {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        ZooWindow zooWindow = new ZooWindow();

        // Add rabbits
        zooWindow.addSprite("res/rabbit.png", new Point(200,200), new Dimension(50,50), new Dimension(zooWindow.screenSize), 10);
        zooWindow.addSprite("res/rabbit.png", new Point(500,500), new Dimension(50,50), new Dimension(zooWindow.screenSize), 10);
        zooWindow.addSprite("res/rabbit.png", new Point(800, 800), new Dimension(50,50), new Dimension(zooWindow.screenSize), 10);
        // Add tigers
        zooWindow.addSprite("res/tiger.png", new Point(300,300), new Dimension(150 ,150), new Dimension(zooWindow.screenSize), 5);
        zooWindow.addSprite("res/tiger.png", new Point(600,600), new Dimension(150 ,150), new Dimension(zooWindow.screenSize), 5);
        zooWindow.addSprite("res/tiger.png", new Point(450,450), new Dimension(150 ,150), new Dimension(zooWindow.screenSize), 5);
        // Add lions     
        zooWindow.addSprite("res/lion.png", new Point(100,100), new Dimension(200,200), new Dimension(zooWindow.screenSize), 4);
        zooWindow.addSprite("res/lion.png", new Point(400,400), new Dimension(200,200), new Dimension(zooWindow.screenSize), 4);
        zooWindow.addSprite("res/lion.png", new Point(700,700), new Dimension(200,200), new Dimension(zooWindow.screenSize), 4);
        // Add T-Rex
        zooWindow.addSprite("res/trex.png", new Point(25, 25), new Dimension(450 ,450), new Dimension(zooWindow.screenSize), 5);
        
        new Thread(zooWindow).start();
    }
    
}
