//DO NOT CHANGE THIS PACKAGE
package coursework3;

import cw3interfaces.VolunteerInterface;

//DO NOT CHANGE THIS NAME
public class Volunteer implements VolunteerInterface {

    private String skill1;
    private String skill2;
    private String skill3;
    private String skillSet;
    
    //COMPLETE THIS CLASS 
    public Volunteer(String skill1, String skill2, String skill3) {
        
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
        this.skillSet = skill1 + "," + skill2 + "," + skill3;
    }
    
    //these public methods need to form the interface 
    // DO NOT CHANGE ANY OF THESE METHOD NAMES, RETURN VALUES, OR ARGUMENTS   
    @Override
    public String getSkillSet() {
        //COMPLETE CODE HERE
        //returns a String of this volunteers skills, eg BBB, ABC, CDD etc
        return skill1 + skill2 + skill3;
    }
    
    public void setSkillSet(String a, String b, String c) {
        this.skill1 = a;
        this.skill2 = b;
        this.skill3 = c;
    }

}
