import java.util.ArrayList;

/**
 * Student.java
 * This class is a simple Representation of a Student. It hold properties such 
 * as the student ID, their class standing, and their courses. It includes 
 * functionality such as adding and removing courses from their schedule. 
 * @author brunsaj2
 */

public class Student extends Person {

    private int studentId;
    private String classStanding;
    private ArrayList<Course> courses = new ArrayList<Course>();
    
    /**
     * Workhorse Constructor. Initializes all properties 
     * [except for studentId] to parameterized values.
     * @param name the Name to be set
     * @param age the age to be set
     * @param classStanding the Students class standing to be set
     */
    public Student(String name, int age, String classStanding) {
        super(name, age);
        this.classStanding = classStanding;
        this.studentId = Person.id++;
    }
    
    /**
     * This method verifies that the Student can add a specific course. 
     * If conditions pass, the course is added to their schedule and the 
     * Student is added to the Course roster.
     * @param c the Course to be added.
     * @return true if the Student was successfully added, false otherwise
     */
    public boolean addCourse(Course c) {
        if (!(this.courses == null)) {    
            //Checks if student is already enrolled
            if (courses.contains(c)) {
                return false;
            }
        }
        
        //Checks if course is full
        if (c.getEnrolled() == c.getCourseLimit()) {
            return false;
        }
        
        courses.add(c);
        //Updates the amount of Students Registered
        int n = c.getEnrolled();
        c.setEnrolled(n += 1);
        c.addStudent(this);
        return true;
    }
    
    /**
     * This method verifies that the Student remove a specific course. 
     * If conditions pass, the course is removed from their schedule and the 
     * Student is removed from the roster.
     * @param c the Course to be removed
     * @return true if the Student was successfully removed, false otherwise
     */
    public boolean removeCourse(Course c) {
        if (this.courses == null) {
            return false;
        }
        //Checks if student is even enrolled.
        if (!(courses.contains(c))) {
            return false;
        }

        courses.remove(c);
        int n = c.getEnrolled();
        c.setEnrolled(n -= 1);
        c.removeStudent(this);
        return true;
    }
    
    /**
     * This method formats the Students information.
     * @return a String holding the neatly formatted information
     */
    @Override
    public String toString() {
        if (this.courses == null) {
            return String.format("Student: %s, Age: %d, Standing: %s, Number of Courses: 0", 
                    this.getName(), this.getAge(), this.classStanding);
        }
        return String.format("Student: %s, Age: %d, Standing: %s, Number of Courses: %d", 
                this.getName(), this.getAge(), this.classStanding, this.courses.size());
    }
    
    /**
     * This method retrieves the Students ID number.
     * @return an int holding the ID
     */
    public int getStudentId() {
        return this.studentId;
    }
    
    /**
     * This method retrieves the Students current class standing.
     * @return a String holding the class standing
     */
    public String getClassStanding() {
        return this.classStanding;
    }
    
    /**
     * This method retrieves all of the Students courses.
     * @return an ArrayList of Course objects
     */
    public ArrayList<Course> getCourses() {
        return this.courses;
    }
}
