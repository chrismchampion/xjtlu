package coursework2;

/**
 *
 * @author christopher
 */
public class Course {

    // private member variables
    private String title;
    private double grade;

    // constructor
    public Course(String pTitle, double pGrade) {

        this.title = pTitle;
        this.grade = pGrade;
    }

    // Getter and Setter methods
    public String getTitle() {
        return title;
    }

    public Double getGrade() {
        return grade;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return title + "/" + grade + ";\n";
    }
}
