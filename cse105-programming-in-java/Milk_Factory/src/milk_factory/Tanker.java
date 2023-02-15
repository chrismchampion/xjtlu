/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package milk_factory;

/**
 *
 * @author Wayne
 */
public final class Tanker {
    
    double capacity;
    double maxCapacity;
    double range;
    int tankerID;
    double distanceDriven;
    int farmsVisited;
    double remainRang;
    
    // constructor
    public Tanker(int pID, double pCapacity, double pRange) {
        tankerID = pID;
        maxCapacity = pCapacity;
        range = pRange;
        
        emptyTanker();
    }
    
    public void emptyTanker(){
        capacity = maxCapacity;
        distanceDriven = 0.0;
        farmsVisited = 0;
        remainRang = maxCapacity;
    }

    public void toNextFarm(double farmDis, double farmMilk){
        distanceDriven += farmDis;
        capacity -= farmMilk;
        farmsVisited ++;
        remainRang = range-distanceDriven;
    }
    
    public int getID(){
        return tankerID;
    }
    
    public double getDisDrivern(){
        return distanceDriven;
    }
    
    public double getCapacity(){
        return capacity;
    }
    
    public double remainRang(){
        return remainRang;
    }

    public int getFarmVisited(){
        return farmsVisited;
    }
    
    public double getMilk(){
        return maxCapacity - capacity;
    }
}
