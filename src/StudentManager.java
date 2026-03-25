import java.util.ArrayList;
import java.util.Scanner;

/**
 * StudentManager Class
 * Handles all CRUD operations and business logic for student management
 * Demonstrates ArrayList usage and method organization
 */
public class StudentManager {
    // ArrayList to store student records
    private ArrayList<Student> students;
    private Scanner scanner;
    
    // Constructor
    public StudentManager() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
        // Add some sample data for demonstration
        initializeSampleData();
    }
    
    // Initialize with sample data
    private void initializeSampleData() {
        students.add(new Student(101, "John Doe", 20, "Computer Science"));
        students.add(new Student(102, "Jane Smith", 19, "Mathematics"));
        students.add(new Student(103, "Mike Johnson", 21, "Physics"));
    }
    
    /**
     * Add a new student to the system
     */
    public void addStudent() {
        System.out.println("\n=== Add New Student ===");
        
        try {
            // Get student ID with validation
            int id = getValidatedId();
            if (!StudentValidator.isValidId(id)) {
                System.out.println("Error: " + StudentValidator.getIdErrorMessage(id));
                return;
            }
            
            if (findStudentById(id) != null) {
                System.out.println("Error: Student with ID " + id + " already exists!");
                return;
            }
            
            // Get student details
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine().trim();
            if (!StudentValidator.isValidName(name)) {
                System.out.println("Error: " + StudentValidator.getNameErrorMessage(name));
                return;
            }
            
            System.out.print("Enter Student Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (!StudentValidator.isValidAge(age)) {
                System.out.println("Error: " + StudentValidator.getAgeErrorMessage(age));
                return;
            }
            
            System.out.print("Enter Student Course: ");
            String course = scanner.nextLine().trim();
            if (!StudentValidator.isValidCourse(course)) {
                System.out.println("Error: " + StudentValidator.getCourseErrorMessage(course));
                return;
            }
            
            // Create and add student
            Student newStudent = new Student(id, name, age, course);
            students.add(newStudent);
            System.out.println("✓ Student added successfully!");
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input! Please try again.");
            scanner.nextLine(); // Clear invalid input
        }
    }
    
    /**
     * Display all students in the system
     */
    public void viewAllStudents() {
        System.out.println("\n=== All Students ===");
        
        if (students.isEmpty()) {
            System.out.println("No students found in the system.");
            return;
        }
        
        System.out.println("Total Students: " + students.size());
        System.out.println("-".repeat(60));
        
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("-".repeat(60));
    }
    
    /**
     * Search for students by ID or name
     */
    public void searchStudent() {
        System.out.println("\n=== Search Student ===");
        System.out.println("1. Search by ID");
        System.out.println("2. Search by Name");
        System.out.print("Enter your choice: ");
        
        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    searchById();
                    break;
                case 2:
                    searchByName();
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
            scanner.nextLine();
        }
    }
    
    /**
     * Search student by ID
     */
    private void searchById() {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Student student = findStudentById(id);
            if (student != null) {
                System.out.println("✓ Student Found:");
                System.out.println(student);
            } else {
                System.out.println("✗ No student found with ID: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid ID format!");
            scanner.nextLine();
        }
    }
    
    /**
     * Search student by name (partial match)
     */
    private void searchByName() {
        System.out.print("Enter Student Name (or part of name): ");
        String searchName = scanner.nextLine().trim().toLowerCase();
        
        if (searchName.isEmpty()) {
            System.out.println("Error: Search name cannot be empty!");
            return;
        }
        
        ArrayList<Student> foundStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchName)) {
                foundStudents.add(student);
            }
        }
        
        if (foundStudents.isEmpty()) {
            System.out.println("✗ No students found with name containing: " + searchName);
        } else {
            System.out.println("✓ Found " + foundStudents.size() + " student(s):");
            System.out.println("-".repeat(60));
            for (Student student : foundStudents) {
                System.out.println(student);
            }
            System.out.println("-".repeat(60));
        }
    }
    
    /**
     * Update existing student information
     */
    public void updateStudent() {
        System.out.println("\n=== Update Student ===");
        
        try {
            System.out.print("Enter Student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Student student = findStudentById(id);
            if (student == null) {
                System.out.println("✗ No student found with ID: " + id);
                return;
            }
            
            System.out.println("Current Information:");
            System.out.println(student);
            System.out.println("\nEnter new information (press Enter to keep current value):");
            
            // Update name
            System.out.print("New Name [" + student.getName() + "]: ");
            String newName = scanner.nextLine().trim();
            if (!newName.isEmpty()) {
                student.setName(newName);
            }
            
            // Update age
            System.out.print("New Age [" + student.getAge() + "]: ");
            String ageInput = scanner.nextLine().trim();
            if (!ageInput.isEmpty()) {
                try {
                    int newAge = Integer.parseInt(ageInput);
                    if (newAge >= 16 && newAge <= 100) {
                        student.setAge(newAge);
                    } else {
                        System.out.println("Warning: Age not updated (must be between 16-100)");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Warning: Invalid age format, keeping current value");
                }
            }
            
            // Update course
            System.out.print("New Course [" + student.getCourse() + "]: ");
            String newCourse = scanner.nextLine().trim();
            if (!newCourse.isEmpty()) {
                student.setCourse(newCourse);
            }
            
            System.out.println("✓ Student updated successfully!");
            System.out.println("Updated Information:");
            System.out.println(student);
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
            scanner.nextLine();
        }
    }
    
    /**
     * Delete a student from the system
     */
    public void deleteStudent() {
        System.out.println("\n=== Delete Student ===");
        
        try {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Student student = findStudentById(id);
            if (student == null) {
                System.out.println("✗ No student found with ID: " + id);
                return;
            }
            
            System.out.println("Student to be deleted:");
            System.out.println(student);
            System.out.print("Are you sure you want to delete this student? (y/N): ");
            
            String confirmation = scanner.nextLine().trim().toLowerCase();
            if (confirmation.equals("y") || confirmation.equals("yes")) {
                students.remove(student);
                System.out.println("✓ Student deleted successfully!");
            } else {
                System.out.println("Delete operation cancelled.");
            }
            
        } catch (Exception e) {
            System.out.println("Error: Invalid input!");
            scanner.nextLine();
        }
    }
    
    /**
     * Helper method to find student by ID
     */
    private Student findStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
    /**
     * Helper method to get validated student ID
     */
    private int getValidatedId() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        
        return id;
    }
    
    /**
     * Get total number of students
     */
    public int getTotalStudents() {
        return students.size();
    }
    
    /**
     * Display comprehensive statistics about students
     */
    public void displayStatistics() {
        StudentStatistics.displayStatistics(students);
    }
    
    /**
     * Get the students list (for statistics)
     */
    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students); // Return a copy for safety
    }
}