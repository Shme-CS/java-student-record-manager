/**
 * Student Model Class
 * Represents a student entity with basic information
 * Demonstrates encapsulation and object-oriented design principles
 */
public class Student {
    // Private attributes for encapsulation
    private int id;
    private String name;
    private int age;
    private String course;
    
    // Default constructor
    public Student() {
    }
    
    // Parameterized constructor
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }
    
    // Getter methods
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getCourse() {
        return course;
    }
    
    // Setter methods
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    // toString method for easy display
    @Override
    public String toString() {
        return String.format("ID: %d | Name: %s | Age: %d | Course: %s", 
                           id, name, age, course);
    }
    
    // equals method for comparison (useful for searching)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id;
    }
    
    // hashCode method (good practice when overriding equals)
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}