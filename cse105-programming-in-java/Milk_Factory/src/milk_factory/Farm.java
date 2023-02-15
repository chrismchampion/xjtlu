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
public class Farm {
    
    int farmID;
    double milkProduced;
    double farmDistance;
    
    public Farm(int pID){
        farmID = pID;
        milkProduced = (Math.random()*1000);
        farmDistance = (Math.random()*100);
    }
    
    public int getID(){
        return farmID;
    }
    
    public double getMilk(){
        return milkProduced;
    }
    
    public double getDis(){
        return farmDistance;
    }
}
