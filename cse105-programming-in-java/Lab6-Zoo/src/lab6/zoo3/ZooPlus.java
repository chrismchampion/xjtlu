/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.zoo3;

import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author joelewis
 */
public class ZooPlus {

    
    public static void main(String[] args) {
        ZooPlus zp = new ZooPlus();
    }
    
    public ZooPlus(){
        ZooWindow gui = new ZooWindow();
        
        Enclosure cowField = gui.addEnclosure("res/grass1.jpg", new Point(50, 50), new Dimension(500, 300), "Cow field");
        for(int i = 0; i < 3; i++){
            cowField.addAnimal("Cow");
        }

        Enclosure fishPond = gui.addEnclosure("res/water1.jpg", new Point(600, 50), new Dimension(400, 300), "Fish pond");
        for(int i = 0; i < 3; i++) {
            fishPond.addAnimal("Fish");
        }
        
        Enclosure jungleLair = gui.addEnclosure("res/jungle1.jpg", new Point(1050, 50), new Dimension(500, 300), "Jungle lair");
        jungleLair.addAnimal("Cat");
        
        new Thread(gui).start();
    }
    
}
