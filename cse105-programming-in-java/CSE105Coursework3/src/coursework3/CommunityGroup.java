//DO NOT CHANGE THIS PACKAGE
package coursework3;

import cw3interfaces.CommunityGroupInterface;
import java.util.ArrayList;

//DO NOT CHANGE THIS NAME
public class CommunityGroup implements CommunityGroupInterface {
    
    //COMPLETE THIS CLASS 
    private final String groupName;
    private final int MAX_VOL = 2;
    private ArrayList<Volunteer> myVolunteers = new ArrayList<>();

    // constructor
    public CommunityGroup(String name) {
        this.groupName = name;
    }
    
    //these public methods need to form the interface 
    // DO NOT CHANGE ANY OF THESE METHOD NAMES, RETURN VALUES, OR ARGUMENTS   
    @Override
    public int howManyVolunteers() {
        //return the total number of volunteers in this community group
        //COMPLETE CODE HERE
        //return 0;
        return this.myVolunteers.size();
    }

    @Override
    public String getSkillsTotals() {
        // return the total number of each skill in a String, example:
        //Skill A: 13, Skill B: 20, Skill C: 23, Skill D: 5, Skill E: 41
        //COMPLETE CODE HERE
        return "delete this";
    }

    public String getName() {
        return groupName;
    }
    
    public int getMaxVol() {
        return MAX_VOL;
    }
    
    public ArrayList getVolunteerList() {
        return this.myVolunteers;
    }
    
}
