/**
 * Gradeable.java
 * This Interface requires 2 methods to be used by subclasses, 
 * which include functionality such as calculating the final grade 
 * and assigning a grade.
 * @author brunsaj2
 */

public interface Gradeable {

    /**
     * This method assigns a grade to a student.
     * @param s the Student to be evaluated
     * @param percentage the percentage to be evaluated
     * @return a char holding the letter grade
     */
    public char assignGrade(Student s, double percentage);
    
    /**
     * This method calculates the final grade for a Student.
     * @param percent the students current percentage
     * @param fin the students grade on the final exam to be added.
     * @return a double holding the final grade
     */
    public double percentWithFinal(double percent, double fin);
    
}
