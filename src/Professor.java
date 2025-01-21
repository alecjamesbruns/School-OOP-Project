/**
 * Professor.java
 * This class is a simple representation of a Professor. 
 * It includes properties such as their ID, department, 
 * and which Course they are teaching. Its functionalities
 * include setting which course they are teaching.
 * @author brunsaj2
 */

public class Professor extends Person {
    
    private int profId;
    private String dept;
    private Course course;
    
    /**
     * Partial Constructor. Initializes all properties to 
     * either parameterized values or default values.
     * @param name the name of the Professor
     * @param age the age of the Professor
     * @param dept the Professors department
     */
    Professor(String name, int age, String dept) {
        super(name, age);
        this.dept = dept;
        this.profId = Person.id++;
    }
    
    /**
     * Workhorse Constructor. Initializes all properties to parameterized 
     * values [excluding profId which is predetermined].
     * @param name the name of the Professor
     * @param age the age of the Professor
     * @param dept the Professors department
     * @param course the Professors course
     */
    Professor(String name, int age, String dept, Course course) {
        super(name,age);
        this.dept = dept;
        this.course = course;
        this.profId = Person.id++;
    }
    
    /**
     * This method formats the Professor Information.
     * @return a String holding the neatly formatted information
     */
    @Override
    public String toString() {
        if (this.course == null) {
            return String.format("Prof. %s, Age: %d, Department: %s, Teaching a Course? No",
                    this.getName(), this.getAge(), this.dept);
        }
        return String.format("Prof. %s, Age: %d, Department: %s, Teaching a Course? Yes",
                this.getName(), this.getAge(), this.dept);
    }

    /**
     * This method retrieves the Professors ID.
     * @return an int holding the ID
     */
    public int getProfId() {
        return profId;
    }

    /**
     * This method retrieves the Professors department.
     * @return a String holding the Professors department
     */
    public String getDept() {
        return dept;
    }

    /**
     * This method retrieves the Professors Course.
     * @return a Course Object holding the Professors Course.
     */
    public Course getCourse() {
        return course;
    }
    
    /**
     * This method changes the Professors Course to the parameterized value.
     * @param course the Course to be set
     */
    public void setCourse(Course course) {
        //Checks to see if the course has a professor
        if (!(course.getProfessor() == null)) {
            this.course = course;
        }
    }
}
