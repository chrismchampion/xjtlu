package menu2;


/**
 *
 * @author ANDREW.ABEL
 */
public class Person {

    // Attributes here
    private String name;		//name
    private int age;		      //age of person
    private String address;	// a city: Suzhou or London
    private boolean married;  // a boolean to indicate marriage

    // Constructor
    public Person(String persName, int persAge, String addressIn, boolean married) {
        // Assign parameters to object attributes
        age = persAge;
        name = persName;
        address = addressIn;
        this.married = married;
        // Add a useful system.out
        System.out.println("Person called " + name + " Created");
    }

    public String getName() {
        // Getter to return name
        return name;
    }

    public int getAge() {
        // Getter to return name
        return age;
    }

    public boolean getMarried() {
        // Getter to return name
        return married;
    }

    public String getAddress() {
        // Getter to return name
        return address;
    }

    public void setAddress(String newAddress) {
        // Getter to return name
        address = newAddress;
        System.out.println("Address changed");
    }

    public void setMarried(boolean marriage) {
        // Getter to return name
        married = marriage;
        System.out.println("Marriage status changed");
    }

    public String toString() {
        // The method which converts the object to a string
        String marriageString = "is not married";
        if (getMarried()) {
            marriageString = "is married";
        }

        String s = "\n************************** \nPerson Details: \nPerson name is "
                + name + "\n" + "Person age is " + age
                + "\nPerson address is " + address
                + "\n" + name + " " + marriageString + ".";
        return s;
    }

    // The flatten method
    public String flatten() {
        // The flatten method can be used to convert object to a file
        // This enables it to be written to a text file
        // This needs modification
        return name + "," + age + "," + address + "," + married;
    }

}
