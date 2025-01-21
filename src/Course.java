import java.security.InvalidParameterException;
import java.util.ArrayList;

/**
 * Course.java
 * This class is a representation of courses. It includes properties such 
 * as the course number, course name, the professor assigned, students 
 * currently enrolled, and the course capacity. Its functionalities 
 * include adding and removing students, and assigning / calculating grades.
 * @author brunsaj2
 */

public class Course implements Gradeable {

    private String courseNum;
    private String name;
    private Professor professor;
    private int enrolled;
    private int courseLimit;
    private ArrayList<Student> roster = new ArrayList<Student>();
    
    /**
     * Workhorse Constructor. Initializes all properties to parameterized values.
     * @param courseNum the course number
     * @param name the name of the course
     * @param professor the professor for the course
     * @param courseLimit the student limit for the course
     */
    public Course(String courseNum, String name, Professor professor, int courseLimit) {
        this.courseNum = courseNum;
        this.name = name;
        this.professor = professor;
        this.courseLimit = courseLimit;
    }
    
    /**
     * This method adds a student to the course roster, 
     * assuming the roster is not full and the student 
     * isn't already enrolled.
     * @param s a Student to be added
     * @return true if the addition was successful, false otherwise
     */
    public boolean addStudent(Student s) {
        //Checks if roster exists
        if (!(this.roster == null)) {
            if (this.roster.contains(s)) {
                return false;
            } else if (this.enrolled == this.courseLimit) {
                return false;
            }
        }
        // Adds student to course, adds course to Student, and adjusts roster
        this.roster.add(s);
        s.addCourse(this);
        return true;
    }
    
    /**
     * This method removes a Student from a course, 
     * assuming the roster exists and the student 
     * was never in the course to begin with.
     * @param s the Student to be evaluated
     * @return true if removal was successful, false otherwise
     */
    public boolean removeStudent(Student s) {
        //Checks if roster exists
        if (this.roster == null) {
            return false;
        }
        //Checks if roster contains student
        if (!(this.roster.contains(s))) {
            return false;
        }
        //removes student from course, and course from student
        roster.remove(s);
        s.removeCourse(this);
        
        return true;
    }
    
    /**
     * This method creates a formatted String of the current Course Object.
     * @return a String that has been formatted neatly
     */
    public String toString() {
        if (this.professor == null) {
            return String.format("Course: %s, %s, Professor: None, Enrollment: %d/%d",  
                    this.courseNum, this.name, 
                    this.enrolled, this.courseLimit);
        }
        return String.format("Course: %s, %s, Professor: %s, Enrollment: %d/%d",  
                this.courseNum, this.name, this.professor.getName(),
                this.enrolled, this.courseLimit);
    }

    /**
     * Retrieves the current Course number.
     * @return a String holding the courseNum
     */
    public String getCourseNum() {
        return courseNum;
    }

    /**
     * Retrieves the current Course Name.
     * @return a String holding the course name
     */
    public String getName() {
        return name;
    }

    /**
     * This method retrieves the Course Professor.
     * @return a Professor Object
     */
    public Professor getProfessor() {
        return professor;
    }

    /**
     * This method retrieves the amount of Students enrolled.
     * @return an int holding the enrolled amount
     */
    public int getEnrolled() {
        return enrolled;
    }

    /**
     * This method retrieves the maximum number of Students for the current course.
     * @return an int holding the maximum enrollment.
     */
    public int getCourseLimit() {
        return courseLimit;
    }

    /**
     * This method retrieves the roster of the Course.
     * @return an ArrayList of Students
     */
    public ArrayList<Student> getRoster() {
        return roster;
    }
    
    /**
     * This method changes the amount of Students currently enrolled.
     * @param enrolled the amount of students enrolled.
     */
    public void setEnrolled(int enrolled) {
        this.enrolled = enrolled;
    }

    /**
     * This method assigns a grade to a student.
     * @param s the Student to be evaluated
     * @param percentage the percentage to be evaluated
     * @return a char holding the letter Grade
     */
    @Override
    public char assignGrade(Student s, double percentage) {
        
        if (percentage < 0 || percentage > 1) {
            throw new InvalidParameterException(percentage + " is not a valid grade.");
        }
        
        if (s.getClassStanding().equalsIgnoreCase("graduate")) {
            if (percentage < .80) {
                return 'F';
            } else if (percentage < .90) {
                return 'B';
            } else {
                return 'A';
            }
        } else {
            if (percentage < .60) {
                return 'F';
            } else if (percentage < .70) {
                return 'D';
            } else if (percentage < .80) {
                return 'C';
            } else if (percentage < .90) {
                return 'B';
            } else {
                return 'A';
            }
        }
          
    }
    
    /**
     * This method calculates the final grade for a Student.
     * @param percent the students current percentage
     * @param fin the students grade on the final exam to be added.
     * @return a double holding the final grade
     */
    @Override
    public double percentWithFinal(double currentPercent, double finalPercent) {
        return (currentPercent * .8) + (finalPercent * .2);
    }
}
