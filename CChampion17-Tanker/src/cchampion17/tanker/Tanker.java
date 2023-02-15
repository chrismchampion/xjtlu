package cchampion17.tanker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
// Milk Tanker program

/*  Here we have a milk tanker with a capacity of 5,000 liters that can
         *  continue to visit farms until it is full.  Each farm gives a random 
         *  quantity of milk, and the tanker can drive 500km until it needs to 
         *  return to the factory, or it will return to the factory if full and
         *  will not visit any more farms.  Each farm is located a random
         *  distance away from the previous one.  
 */
public class Tanker {

    // class variables
    String tankerName;
    double capacity;
    double maxCapacity;
    double range;
    double distanceDriven = 0;
    double farmDistance = 0;
    int farmsVisited = 0;
    double milkQuantity = 0;
    int tankerScore = 0;

    final int MAX_FARMS = 12;

    // constructor
    public Tanker(String pName, double pCapacity, double pRange) {
        this.capacity = pCapacity;
        this.maxCapacity = pCapacity;
        this.range = pRange;
        this.tankerName = pName;
    }

    public static void main(String[] args) {

        // Create Tanker A - E with parameters capacity in liters, range in km
        // Comment out tankerA and tankerB to test displayTankerScores()
        Tanker tankerA = new Tanker("Tanker A", 3000, 10000);
        Tanker tankerB = new Tanker("Tanker B", 8000, 2500);
        Tanker tankerC = new Tanker("Tanker C", 5000, 2000);
        Tanker tankerD = new Tanker("Tanker D", 5000, 4000);
        Tanker tankerE = new Tanker("Tanker E", 4000, 5000);

        // Process tankers
        Tanker[] tankerArray = {tankerA, tankerB, tankerC, tankerD, tankerE};
        // Can't pass parameter if method is not static
        List<Tanker> efficientTankersList = processTankers(tankerArray);

        // Get tanker efficiency values
        // Can't pass parameters if method is not static
        scoreTankers(tankerArray, efficientTankersList);

        // Print tanker scores
        // Can't pass tanker array paramter if method is not static
        displayTankerScores(tankerArray, efficientTankersList);

    }

    public static List<Tanker> processTankers(Tanker[] pTankerArray) {
        // List for tankers that return to the factory because they've reached all 12 farms
        List<Tanker> efficientTankers = new ArrayList<>();

        // for each tanker in tanker array (A - E)
        for (Tanker tankArr1 : pTankerArray) {
            // run the dairy sequence
            tankArr1.doDairySequence(tankArr1, efficientTankers);
        }
        return efficientTankers;
    }

    public static void scoreTankers(Tanker[] tankArr, List<Tanker> pList) {
        // for each tanker in the list of efficient tankers
        for (Tanker t : pList) {
            // count tanker name occurrence and adjust the tanker object's score
            // for each of the tanker objects created in main accordingly
            for (int i = 0; i < tankArr.length; i++) {
                if (t.tankerName.equals(tankArr[i].tankerName)) {
                    tankArr[i].tankerScore++;
                }
            }
        }
    }

    public static void displayTankerScores(Tanker[] pTankerArray, List<Tanker> pEfficientTankers) {
        int index = 0;
        String tankerName;
        List<Tanker> tiedTankers = new ArrayList<>();
        // Get the tanker names and scores from tanker array parameter
        for (int tElem = 0; tElem < pTankerArray.length; tElem++) {

            tankerName = pTankerArray[tElem].tankerName;
            System.out.println(tankerName + " score is " + pTankerArray[tElem].tankerScore);
            // if score of tElem is great than 0 or greater than the previous element,
            // update index value to tElem highest score index
            if (pTankerArray[tElem].tankerScore > pTankerArray[index].tankerScore) {
                index = tElem;
            }
        }
        // for each of the tankers with the highest scores
        for (Tanker efficientTanker : pEfficientTankers) {
            // if there are duplicate high scores (tied tankers)
            if (efficientTanker.tankerScore == pTankerArray[index].tankerScore) {
                // exclude the first tanker with matching high score from the list
                if (!efficientTanker.tankerName.equals(pTankerArray[index].tankerName)) {
                    tiedTankers.add(efficientTanker);
                }
            }
        }
        // if no ties, print winner
        if (tiedTankers.isEmpty()) {
            System.out.println();
            System.out.println(pTankerArray[index].tankerName + " with a score of " + pTankerArray[index].tankerScore + " is the best tanker!");
        } else {
            // Use hashset to display only unique values from tiedTankers list,
            // instead of showing Tankers n amount of times based on their tankerScore value
            Set<Tanker> hashSetList = new HashSet<>(tiedTankers);
            // print winning tanker and tied tankers
            System.out.print("\nTie between " + pTankerArray[index].tankerName + " and ");
            hashSetList.forEach((h) -> {
                System.out.println(h.tankerName);
            });
        }
    }

    public void doDairySequence(Tanker pTankArr1, List<Tanker> pEfficientTankers) {
        // Execute dairy farm process 10 times while each tanker passes the three isOperational conditions
        for (int i = 0; i < 10; i++) {
            pTankArr1.displayTankerInfo();
            while (pTankArr1.isOperational()) {
                pTankArr1.visitDairyFarm();
                pTankArr1.displayTankerStatus();
                // Check if tanker visited all 12 farms and add to list of efficient tankers
                if (pTankArr1.maxFarmsVisited()) {
                    pEfficientTankers.add(pTankArr1);
                }
            }
            // Reset tanker values for the next iteration of the for loop (1-9)
            pTankArr1.resetTanker();
        }
    }

    // Used in doDairySequence() to calculate values for each tanker's trip to a dairy farm
    public void visitDairyFarm() {
        // While capacity is greater than 0, i.e. there is still capacity
        //while (capacity > 0 && farmsVisited < maxFarms && distanceDriven < range) {

        // Add one to the number of farms visited
        farmsVisited = farmsVisited + 1;
        // Calculate distance of 0 - 100 km between farms
        farmDistance = (Math.random() * 100);

        // Add distance between famrs to distanceDriven
        distanceDriven += farmDistance;

        // generate a random quantity of milk between 0 and 1000 liters
        milkQuantity = (Math.random() * 1000);
        // add the milk to the tanker
        capacity = capacity - milkQuantity;

        // if the tank is full, set to zero, cannot have negative capacity!
        if (capacity < 0) {
            capacity = 0;
        }
    }

    // Used in doDairySequence() to rest tanker values for loop iterations
    public void resetTanker() {
        farmsVisited = 0;
        distanceDriven = 0;
        capacity = maxCapacity;
    }

    public boolean tankIsFull() {
        return this.capacity <= 0;
    }

    public boolean maxFarmsVisited() {
        return this.farmsVisited == MAX_FARMS;
    }

    public boolean maxDistanceReached() {
        return this.distanceDriven >= this.range;
    }

    public boolean isOperational() {
        return !tankIsFull() && !maxFarmsVisited() && !maxDistanceReached();
    }

    public void displayTankerInfo() {
        // Display range and capacity info of tanker instance
        System.out.println("****************************************");
        System.out.println("TANKER NAME " + tankerName);
        System.out.println("TANKER CAPACITY " + maxCapacity + " LITERS");
        System.out.println("TANKER RANGE " + range + " KM");
        System.out.println("****************************************");
    }

    public void displayTankerStatus() {
        // Display information about the status
        System.out.println("Visiting Farm Number " + farmsVisited);
        System.out.println("Milk Produced =" + milkQuantity + " liters");
        System.out.println("Farm Distance =" + farmDistance + " km");
        System.out.println("Remaining capacity in tanker is " + capacity + " liters");
        System.out.println("Distance driven is " + distanceDriven + " km");
        System.out.println("\nMoving on to next farm...");

        if (maxFarmsVisited()) {
            System.out.println("\n! Maximum number of " + MAX_FARMS + " farms visited !");
        }
        if (maxDistanceReached()) {
            System.out.println("\n! Max distance of " + range + " km covered !");
        }
        if (tankIsFull()) {
            System.out.println("\n! Maximum tanker capacity of " + maxCapacity + " liters reached !");
        }
        if (maxFarmsVisited() || maxDistanceReached() || tankIsFull()) {
            System.out.println("\nRETURNING TO THE FACTORY");
        }

        // Add an empty line
        System.out.println();
        System.out.println("----------------------------------");
    }

}
