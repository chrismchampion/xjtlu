//DO NOT CHANGE THIS PACKAGE
package coursework3;

import cw3interfaces.SkillSorterInterface;
import java.util.ArrayList;
import java.util.Iterator;

//DO NOT CHANGE THIS NAME
public class SkillSorter implements SkillSorterInterface {

    private final String GROUP1 = "Group1";
    private final String GROUP2 = "Group2";
    private final String GROUP3 = "Group3";
    private final String GROUP4 = "Group4";
    private final String GROUP5 = "Group5";
    private CommunityGroup group1;
    private CommunityGroup group2;
    private CommunityGroup group3;
    private CommunityGroup group4;
    private CommunityGroup group5;

    private final String FILE_NAME = "GroupList.txt";
    private ArrayList<CommunityGroup> myGroups = new ArrayList<>();
    //List<List<Volunteer>> myGroups = new ArrayList<List<Volunteer>>();

    //COMPLETE THIS CLASS
    public SkillSorter() {
        myGroups = FileReadWrite.readGroupFile(FILE_NAME);

        if (myGroups.isEmpty()) {
            // Create Group1-5 when SkillSorter is instantiated in main()
            group1 = new CommunityGroup(GROUP1);
            group2 = new CommunityGroup(GROUP2);
            group3 = new CommunityGroup(GROUP3);
            group4 = new CommunityGroup(GROUP4);
            group5 = new CommunityGroup(GROUP5);

            myGroups.add(group1);
            myGroups.add(group2);
            myGroups.add(group3);
            myGroups.add(group4);
            myGroups.add(group5);
            // Create a new GroupList.txt file with Groups1-5
            FileReadWrite.initGroupFile(myGroups, FILE_NAME);
        } else {
            group1 = myGroups.get(0);
            group2 = myGroups.get(1);
            group3 = myGroups.get(2);
            group4 = myGroups.get(3);
            group5 = myGroups.get(4);
        }
    }

    public void addVolunteerToGroup(CommunityGroup cg) {

        if (cg.howManyVolunteers() < cg.getMaxVol()) {
            ArrayList volList = cg.getVolunteerList();
            Volunteer vol = new Volunteer("A", "A", "A");
            volList.add(vol);
        } else {
            System.out.println("ERROR: Maximum of " + cg.getMaxVol() + " volunteers for this group has been reached.");
        }
    }

    //these public methods need to form the interface 
    // DO NOT CHANGE ANY OF THESE METHOD NAMES, RETURN VALUES, OR ARGUMENTS
    @Override
    public void addVolunteer(Volunteer vol) {
        //add a volunteer to a Community Group USING YOUR SORTING ALGORITHM
        //COMPLETE CODE HERE

    }

    @Override
    public void moveVolunteer(String skillSet, CommunityGroup from, CommunityGroup to) {
        //move a volunteer with this skillset (eg AAA, BCD) from one CommunityGroup to another
        //COMPLETE CODE HERE
    }

    @Override
    public void deleteVolunteer(String skillSet, CommunityGroup from) {
        //delete a volunteer with this skillset from this CommunityGroup
        //COMPLETE CODE HERE
    }

    @Override
    public void deleteAllVolunteers() {
        // delete all volunteers from all CommunityGroups
        //COMPLETE CODE HERE
    }

    @Override
    public ArrayList<CommunityGroup> getCommunityGroups() {
        //return an ArrayList of all this application's CommunityGroups
        return myGroups;
    }

    public CommunityGroup getGroup1() {
        return group1;
    }
    
    public CommunityGroup getGroup2() {
        return group2;
    }
        
    public CommunityGroup getGroup3() {
        return group3;
    }
            
    public CommunityGroup getGroup4() {
        return group4;
    }
                
    public CommunityGroup getGroup5() {
        return group5;
    }
    
    public CommunityGroup getGroupByName(String nameInput) {
        
        CommunityGroup group = new CommunityGroup("DEFAULT");
        
        Iterator<CommunityGroup> cgIterator = myGroups.iterator();
        while (cgIterator.hasNext()) {
            
            CommunityGroup cg = cgIterator.next();
            if (cg.getName().equalsIgnoreCase(nameInput)) {
                group = cg;
            }
            
        }
        System.out.println("YOU ENTERED: " + nameInput);
        System.out.println("RETURNED: " + group.getName());
        
        return group;
    }
    
    public String getFileName() {
        return FILE_NAME;
    }
}
