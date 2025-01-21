/**
 * Person.java
 * This class is a simple representation of a Person. 
 * It is abstract so that only objects can be made from 
 * inherited subclasses. Its properties include a Name and Age.
 * @author brunsaj2
 */
public abstract class Person {

    protected static int id = 0;
    private String name;
    private int age;
    
    /**
     * Workhorse Constructor. This initializes both properties to parameterized values.
     * @param name the name to be set
     * @param age the age to be set
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    /**
     * Empty Constructor. This initializes both properties to default values.
     */
    public Person() {
        this("", 0);
    }
    
    /**
     * Retrieves the name of the Person.
     * @return a String holding the name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Retrieves the age of the Person.
     * @return an int holding the age
     */
    public int getAge() {
        return this.age;
    }
    
    /**
     * Changes the name of the Person Object.
     * @param name the Name to be set
     */
    public void setName(String name) {
        this.name = name;
    }
}
