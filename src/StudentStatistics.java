import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * StudentStatistics Class
 * Provides statistical analysis of student data
 * Demonstrates data analysis and HashMap usage
 */
public class StudentStatistics {
    
    /**
     * Calculate average age of all students
     * @param students List of students
     * @return Average age
     */
    public static double calculateAverageAge(ArrayList<Student> students) {
        if (students.isEmpty()) {
            return 0.0;
        }
        
        int totalAge = 0;
        for (Student student : students) {
            totalAge += student.getAge();
        }
        
        return (double) totalAge / students.size();
    }
    
    /**
     * Find the youngest student
     * @param students List of students
     * @return Youngest student or null if list is empty
     */
    public static Student findYoungestStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            return null;
        }
        
        Student youngest = students.get(0);
        for (Student student : students) {
            if (student.getAge() < youngest.getAge()) {
                youngest = student;
            }
        }
        
        return youngest;
    }
    
    /**
     * Find the oldest student
     * @param students List of students
     * @return Oldest student or null if list is empty
     */
    public static Student findOldestStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            return null;
        }
        
        Student oldest = students.get(0);
        for (Student student : students) {
            if (student.getAge() > oldest.getAge()) {
                oldest = student;
            }
        }
        
        return oldest;
    }
    
    /**
     * Get course distribution (count of students per course)
     * @param students List of students
     * @return Map of course names to student counts
     */
    public static Map<String, Integer> getCourseDistribution(ArrayList<Student> students) {
        Map<String, Integer> courseCount = new HashMap<>();
        
        for (Student student : students) {
            String course = student.getCourse();
            courseCount.put(course, courseCount.getOrDefault(course, 0) + 1);
        }
        
        return courseCount;
    }
    
    /**
     * Get age distribution (count of students per age group)
     * @param students List of students
     * @return Map of age groups to student counts
     */
    public static Map<String, Integer> getAgeDistribution(ArrayList<Student> students) {
        Map<String, Integer> ageGroups = new HashMap<>();
        
        for (Student student : students) {
            String ageGroup = getAgeGroup(student.getAge());
            ageGroups.put(ageGroup, ageGroups.getOrDefault(ageGroup, 0) + 1);
        }
        
        return ageGroups;
    }
    
    /**
     * Determine age group for a given age
     * @param age Student age
     * @return Age group string
     */
    private static String getAgeGroup(int age) {
        if (age < 18) return "16-17 (Minor)";
        else if (age < 21) return "18-20 (Young Adult)";
        else if (age < 25) return "21-24 (Adult)";
        else return "25+ (Mature)";
    }
    
    /**
     * Display comprehensive statistics
     * @param students List of students
     */
    public static void displayStatistics(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students available for statistics.");
            return;
        }
        
        System.out.println("\n=== Student Statistics ===");
        System.out.println("Total Students: " + students.size());
        System.out.printf("Average Age: %.1f years%n", calculateAverageAge(students));
        
        Student youngest = findYoungestStudent(students);
        Student oldest = findOldestStudent(students);
        
        System.out.println("Youngest Student: " + youngest.getName() + " (Age: " + youngest.getAge() + ")");
        System.out.println("Oldest Student: " + oldest.getName() + " (Age: " + oldest.getAge() + ")");
        
        System.out.println("\n--- Course Distribution ---");
        Map<String, Integer> courseDistribution = getCourseDistribution(students);
        for (Map.Entry<String, Integer> entry : courseDistribution.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " student(s)");
        }
        
        System.out.println("\n--- Age Distribution ---");
        Map<String, Integer> ageDistribution = getAgeDistribution(students);
        for (Map.Entry<String, Integer> entry : ageDistribution.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " student(s)");
        }
        
        System.out.println("-".repeat(50));
    }
}