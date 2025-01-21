import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Project2Tester.java
 * This class is used to test the functionality of Person.java, Professor.java,
 * Student.java, Course.java, and Gradeable.java.
 * @author brunsaj2
 */
public class Project2Tester {

    public static void main(String[] args) {

    }

    /**
     * This method reads professors and students from Files, 
     * .and then assigns them to corresponding objects
     * @param profFileName the file containing the professors
     * @param studentFileName the file containing the students
     * @return an ArrayList of Person objects
     */
    public static ArrayList<Person> readPeopleFromFile(String profFileName, 
            String studentFileName) {
        
        ArrayList<Person> people = new ArrayList<Person>();
        
        try {    
            Scanner sc = new Scanner(new File(profFileName));
            
            while (sc.hasNextLine()) {
                if (!(sc.hasNext() && sc.hasNext() && sc.hasNextInt() && sc.hasNext())) { 
                    String name = sc.next() + " " + sc.next();
                    int age = sc.nextInt();
                    String dept = sc.next();
                    Professor p = new Professor(name, age, dept);
                    people.add(p);
                }
            }
            sc.close();
        
            
            return readPeople2(studentFileName, people);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return people;
    }
    
    /**
     * This method is an extension of readPeopleFromFile().
     * @param studentFileName the file containing the students
     * @param people the current ArrayList to be added to
     * @return an ArrayList of Person objects
     */
    private static ArrayList<Person> readPeople2(String studentFileName, 
            ArrayList<Person> people) {
        try {
            Scanner in = new Scanner(new File(studentFileName)); 
            while (in.hasNextLine()) {
                String line = in.nextLine();
                Scanner lineScanner = new Scanner(line);
                if (line.isEmpty() == true) {
                    lineScanner.close();
                    in.close();
                    return people;
                } else {
                
                    String name = lineScanner.next() + " " +  lineScanner.next();
                    int age = lineScanner.nextInt();
                    String standing = lineScanner.next();
                    Student s = new Student(name, age, standing);
                    people.add(s);
                }
                lineScanner.close();
            }
            in.close();
            return people;
        } catch (FileNotFoundException e) {
            System.out.print("File Not Found");
        }
        return people;
    }
    
    /**
     * This method reads courses from a file, and creates Course objects, 
     * which are then assigned to Professors.
     * @param courseFileName the file containing the courses
     * @param professor an ArrayList containing professors
     * @return an ArrayList of Course objects
     */
    public static ArrayList<Course> readCoursesFromFile(String courseFileName, 
            ArrayList<Professor> professor) {
        
        ArrayList<Course> courses = new ArrayList<Course>();
        try {
            Scanner in = new Scanner(new File(courseFileName));
            int i = 0;
            while (in.hasNextLine()) {
                String line = in.nextLine();
                Scanner lineScanner = new Scanner(line);
                if (line.isEmpty() == true) {
                    lineScanner.close();
                    in.close();
                    return courses;
                } else {
                    String courseNum = lineScanner.next();
                    String courseName = lineScanner.next();
                    int enrollment = lineScanner.nextInt();
                    Professor p = professor.get(i);
                    i++;
                    Course c = new Course(courseNum, courseName, p, enrollment);
                    courses.add(c);
                }
                lineScanner.close();
            } 
            in.close();
            return courses;
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        return courses; 
    }

}
