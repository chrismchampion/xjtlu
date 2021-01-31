package coursework3;

import cw3interfaces.VolunteerInterface;

/**
 *
 * @author Christopher Champion, 1719247
 */
public class Volunteer implements VolunteerInterface {

    // private class variables
    private String skillSet;

    // Constructor 
    public Volunteer(String pSkillSet) {

        this.skillSet = pSkillSet;
    }
  
    @Override
    public String getSkillSet() {
        //returns a String of this volunteers skills, eg BBB, ABC, CDD etc
        return skillSet;
    }

    protected static String formatSkillSet(String skills) {

        // Remove white spaces and convert to upper case
        String formatStr = skills.replaceAll("\\s+", "").toUpperCase();
        // Convert formatStr to character array
        char[] chars = formatStr.toCharArray();

        // Bubble Sort char array
        char temp;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 1; j < chars.length - i; j++) {

                if (chars[j - 1] > chars[j]) {
                    temp = chars[j - 1];
                    chars[j - 1] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        // return as string
        return String.valueOf(chars);
    }

}
