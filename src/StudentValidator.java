/**
 * StudentValidator Class
 * Provides validation utilities for student data
 * Demonstrates separation of concerns and utility class design
 */
public class StudentValidator {
    
    // Constants for validation
    public static final int MIN_AGE = 16;
    public static final int MAX_AGE = 100;
    public static final int MIN_ID = 1;
    public static final int MAX_NAME_LENGTH = 50;
    public static final int MAX_COURSE_LENGTH = 30;
    
    /**
     * Validate student ID
     * @param id Student ID to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidId(int id) {
        return id >= MIN_ID;
    }
    
    /**
     * Validate student name
     * @param name Student name to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        
        String trimmedName = name.trim();
        return trimmedName.length() <= MAX_NAME_LENGTH && 
               trimmedName.matches("^[a-zA-Z\\s]+$"); // Only letters and spaces
    }
    
    /**
     * Validate student age
     * @param age Student age to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidAge(int age) {
        return age >= MIN_AGE && age <= MAX_AGE;
    }
    
    /**
     * Validate course name
     * @param course Course name to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidCourse(String course) {
        if (course == null || course.trim().isEmpty()) {
            return false;
        }
        
        String trimmedCourse = course.trim();
        return trimmedCourse.length() <= MAX_COURSE_LENGTH;
    }
    
    /**
     * Get validation error message for ID
     * @param id The invalid ID
     * @return Error message
     */
    public static String getIdErrorMessage(int id) {
        return "Invalid ID: " + id + ". ID must be a positive number.";
    }
    
    /**
     * Get validation error message for name
     * @param name The invalid name
     * @return Error message
     */
    public static String getNameErrorMessage(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Name cannot be empty.";
        }
        if (name.trim().length() > MAX_NAME_LENGTH) {
            return "Name too long. Maximum " + MAX_NAME_LENGTH + " characters allowed.";
        }
        return "Name can only contain letters and spaces.";
    }
    
    /**
     * Get validation error message for age
     * @param age The invalid age
     * @return Error message
     */
    public static String getAgeErrorMessage(int age) {
        return "Invalid age: " + age + ". Age must be between " + MIN_AGE + " and " + MAX_AGE + ".";
    }
    
    /**
     * Get validation error message for course
     * @param course The invalid course
     * @return Error message
     */
    public static String getCourseErrorMessage(String course) {
        if (course == null || course.trim().isEmpty()) {
            return "Course cannot be empty.";
        }
        return "Course name too long. Maximum " + MAX_COURSE_LENGTH + " characters allowed.";
    }
}