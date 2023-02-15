package myzoo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author joelewis
 */
public class ZooWindow extends Frame {       //we inherit from Frame all the properties and behaviours of a window

    Dimension screenSize;   //a Dimension object has width and height fields. We will use it to store the ...?
    ImageDisplay[] imageArray = new ImageDisplay[12];
    
    /*
    This is the CONSTRUCTOR method. It constructs a new object of this class.
    It is called by calling new ClassName(); from another class/object
     */
    public ZooWindow() {
        super("My Zoo Window");
        this.init();    //just to be tidy, I put my initialisation code in a separate method
    }
    
    private void init() {
        this.setVisible(true);    //first we set some parameters inherited from Frame  
        this.setLayout(null);
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();   //ok, there's a thing called Toolkit. You can get the screen size from it
        this.setSize(screenSize.width, screenSize.height);          //make our window fill the screen
        // mini zoo window
        //this.setSize(screenSize.width/2, screenSize.height/2);

        // dark green
        //this.setBackground(new Color(50, 50, 25));                  //change this!
        this.setBackground(new Color(124, 252, 0));
        this.addWindowListener(new WindowAdapter() {                //don't worry about this disgusting piece of code
            public void windowClosing(WindowEvent windowEvent) {     //it makes the 'close' button on the window work
                System.exit(0);                                      //OK??
            }
        });

        // Add images to ZooWindow
        loadGrid("res/rabbit.png");
        //loadDiagonalLineIncreasing("res/tiger.png");
        //loadVerticalLine("res/rabbit.png");
        //loadHorizontalLine("res/trex.png");
        //addImage();
    }
    
    public void addImage() {
        ImageDisplay myImage;
        //OK, so create a new ImageDisplay and assign it to myImage HERE!!
        myImage = new ImageDisplay("res/lion.png", new Point(400, 350), new Dimension(150, 150));
        this.add(myImage);
        myImage.setLocation(myImage.location);
        myImage.setSize(myImage.size);
    }
    
    public void loadHorizontalLine(String resPath) {
        
        ImageDisplay zooAnimalImage;
        // Variables to be incremented in for loop
        int pointX = 0;
        int pointY = 20;
        // Image dimensions passed to ImageDisplay constructor
        int dimX = 150;
        int dimY = 150;
        
        for (int i = 0; i < 12; i++) {
            zooAnimalImage = new ImageDisplay(resPath, new Point(pointX, pointY), new Dimension(dimX, dimY));
            this.add(zooAnimalImage);
            zooAnimalImage.setLocation(zooAnimalImage.location);
            zooAnimalImage.setSize(zooAnimalImage.size);

            // Increment pointX by image width dimX for each loop iteration
            pointX += dimX;
        }
    }
    
    public void loadVerticalLine(String resPath) {
        
        ImageDisplay zooAnimalImage;
        // Variables to be incremented in for loop
        int pointX = 0;
        int pointY = 20;
        // Image dimensions passed to ImageDisplay constructor
        int dimX = 150;
        int dimY = 150;
        
        for (int i = 0; i < 12; i++) {
            zooAnimalImage = new ImageDisplay(resPath, new Point(pointX, pointY), new Dimension(dimX, dimY));
            this.add(zooAnimalImage);
            zooAnimalImage.setLocation(zooAnimalImage.location);
            zooAnimalImage.setSize(zooAnimalImage.size);

            // Increment pointY by image height dimY for each loop iteration
            pointY += dimY;
        }
    }
    
    public void loadDiagonalLineIncreasing(String resPath) {
        
        ImageDisplay zooAnimalImage;
        // Variables to be incremented in for loop
        int pointX = 30;
        int pointY = 30;
        // Image dimensions passed to ImageDisplay constructor
        int dimX = 40;
        int dimY = 40;
        
        for (int i = 0; i < 12; i++) {
            zooAnimalImage = new ImageDisplay(resPath, new Point(pointX, pointY), new Dimension(dimX, dimY));
            this.add(zooAnimalImage);
            zooAnimalImage.setLocation(zooAnimalImage.location);
            zooAnimalImage.setSize(zooAnimalImage.size);

            // Increment x coordinate by 80%
            // Increment y coordinate by 20%
            pointX += dimX * 0.8;
            pointY += dimY * 0.4;

            // Increase size by 15% for each loop iteration
            dimX += dimX * 0.25;
            dimY += dimY * 0.25;
        }
    }  
    
    public void loadGrid(String resPath) {

        ImageDisplay zooAnimalImage;
        // Variables to be incremented in for loop
        //int pointX = 0;
        //int pointY = 0;
        // Image dimensions passed to ImageDisplay constructor
        int sizeX = 150;
        int sizeY = 150;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 4; j++) {
                zooAnimalImage = new ImageDisplay(resPath, new Point((i*200)+50, (j*200)+50), new Dimension(sizeX, sizeY));
                this.add(zooAnimalImage);
                zooAnimalImage.setLocation(zooAnimalImage.location);
                zooAnimalImage.setSize(zooAnimalImage.size);

                // Increment pointX by image width dimX for each loop iteration
                //pointX += sizeX;
            }
            // Here is where I need to skip to new line  
            //pointY += 100;
        }
    }
}
