/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milk_factory;

import java.util.Scanner;

/**
 *
 * @author Wayne
 */
public class Milk_Factory {
    
    //define the const value
    final static int MAX_FARMS = 12;
    final static int MAX_ATTEMPT = 10;
    final static int TANKER_ACCOUNT = 5;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //define the tanker
        Tanker[] tankerArray = new Tanker[TANKER_ACCOUNT];
        tankerArray[0] = new Tanker(1, 3000, 10000);
        tankerArray[1] = new Tanker(2, 8000, 2500);
        tankerArray[2] = new Tanker(3, 5000, 2000);
        tankerArray[3] = new Tanker(4, 5000, 4000);
        tankerArray[4] = new Tanker(5, 4000, 5000);

        //define the farm
        Farm[][] farmArray = new Farm[MAX_ATTEMPT][MAX_FARMS];
        for (int i =0; i < MAX_ATTEMPT; i++){
            for (int j = 0; j < MAX_FARMS; j++){
                farmArray[i][j] = new Farm(j);
            }
        }
        
        //10 attempts
        for (int i = 0; i < MAX_ATTEMPT; i++) {
            for (int j = 0; j < TANKER_ACCOUNT; j++){
                processing(tankerArray[j],farmArray[i]);
                System.out.println("-------------------------------------------------------------------");
            }
            for (int t = 0; t < TANKER_ACCOUNT; t++){
                System.out.println("Tanker " + tankerArray[t].getID() + " has visited " + tankerArray[t].getFarmVisited() + " farms with " + tankerArray[t].getMilk() +" liters milk." );
                
                //empty the tanker for the next attemp
                tankerArray[t].emptyTanker();
            }
            System.out.println("Press Enter key to continue... ");
            Scanner input = new Scanner(System.in);
            String str = input.nextLine(); 
        }
    }
    
    private static void processing(Tanker tanker, Farm[] farmArray){
        
        int i =0;
        
        while (tanker.getCapacity() > 0 & tanker.remainRang() >0 & tanker.getFarmVisited() < MAX_FARMS){
            if (tanker.remainRang() < farmArray[i].farmDistance){
                tanker.remainRang = 0;
                System.out.println("Tanker " + tanker.getID() + " is tired. Returning to the factory");
            } else {
                tanker.toNextFarm(farmArray[i].farmDistance, farmArray[i].milkProduced);

                System.out.println("Visiting Farm Number " + farmArray[i].getID());
                System.out.println("Milk Produced =" + farmArray[i].getMilk() + " liters");
                System.out.println("Farm Distance =" + farmArray[i].getDis() + " km");
                System.out.println("Remaining capacity in tanker is " + tanker.getCapacity() + " liters");
                System.out.println("Distance driven is " + tanker.getDisDrivern() + " km");

                if (tanker.getCapacity()<0){
                    tanker.capacity = 0;
                    System.out.println("Tanker " + tanker.getID() + " is full. Returning to the factory");
                } else if (tanker.getFarmVisited() < 12){
                    i++;
                    System.out.println("Moving on to next farm");
                } else {
                    System.out.println("All Farm visited. Returning to the factory");
                }       
            }
        }
    }
}
