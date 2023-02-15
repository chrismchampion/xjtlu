/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.scanner;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;




public class Window extends Frame {
    //variables we want to use eerywhere
    int screenWidth;
    int screenHeight;
    
    //this method is called by the JVM when the program starts
    public static void main(String [] args){
        //It calls its own constructor
        Window myWindow = new Window();
        myWindow.init();
    }
    
    //Constructor: makes a new Object of type Window
    public Window(){
        //calls init() method (look down!)
        init();
    }
   
    public void paint(Graphics g){
        super.paint(g);
        //*************************** add your painting code here! **********************
        g.setColor(Color.RED);
        g.drawLine(30, 30, 300, 300);
        g.drawLine(30, 30, 500, 600);
        g.drawString("Hello World", screenWidth/2, 50);
    }
    
    
    //initialises a number of bits the window needs
    private void init(){
        setVisible(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();   
        setSize(screenSize.width, screenSize.height);
        screenWidth = screenSize.width;
        screenHeight = screenSize.height;
        setBackground(Color.BLACK);  
        addWindowListener(new WindowAdapter() {                
            public void windowClosing(WindowEvent windowEvent){  
               System.exit(0);                                      
            }        
        });
    }
    
}
