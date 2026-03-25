import java.util.Scanner;

/**
 * Main Class - Entry Point
 * Handles the menu system and user interaction
 * Demonstrates menu-driven programming and application flow control
 */
public class Main {
    private static StudentManager studentManager;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        // Initialize components
        studentManager = new StudentManager();
        scanner = new Scanner(System.in);
        
        // Display welcome message
        displayWelcomeMessage();
        
        // Main application loop
        boolean running = true;
        while (running) {
            try {
                displayMenu();
                int choice = getUserChoice();
                running = processChoice(choice);
            } catch (Exception e) {
                System.out.println("Error: Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
        
        // Cleanup and exit
        displayExitMessage();
        scanner.close();
    }
    
    /**
     * Display welcome message and system information
     */
    private static void displayWelcomeMessage() {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║          STUDENT RECORD MANAGEMENT SYSTEM               ║");
        System.out.println("║                                                          ║");
        System.out.println("║  A comprehensive solution for managing student records   ║");
        System.out.println("║  Built with Java - Demonstrating OOP Principles        ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Welcome! Current students in system: " + studentManager.getTotalStudents());
        System.out.println();
    }
    
    /**
     * Display the main menu options
     */
    private static void displayMenu() {
        System.out.println("┌─────────────────────────────────────────┐");
        System.out.println("│           MAIN MENU                     │");
        System.out.println("├─────────────────────────────────────────┤");
        System.out.println("│  1. Add Student                         │");
        System.out.println("│  2. View All Students                   │");
        System.out.println("│  3. Search Student                      │");
        System.out.println("│  4. Update Student                      │");
        System.out.println("│  5. Delete Student                      │");
        System.out.println("│  6. View Statistics                     │");
        System.out.println("│  7. Exit                                │");
        System.out.println("└─────────────────────────────────────────┘");
        System.out.print("Enter your choice (1-7): ");
    }
    
    /**
     * Get and validate user menu choice
     */
    private static int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return choice;
    }
    
    /**
     * Process the user's menu choice
     * @param choice The menu option selected by user
     * @return boolean indicating whether to continue running
     */
    private static boolean processChoice(int choice) {
        System.out.println(); // Add spacing
        
        switch (choice) {
            case 1:
                studentManager.addStudent();
                break;
                
            case 2:
                studentManager.viewAllStudents();
                break;
                
            case 3:
                studentManager.searchStudent();
                break;
                
            case 4:
                studentManager.updateStudent();
                break;
                
            case 5:
                studentManager.deleteStudent();
                break;
                
            case 6:
                studentManager.displayStatistics();
                break;
                
            case 7:
                return false; // Exit the application
                
            default:
                System.out.println("✗ Invalid choice! Please select a number between 1-7.");
        }
        
        // Pause before showing menu again (except for exit)
        if (choice != 7) {
            pauseForUser();
        }
        
        return true; // Continue running
    }
    
    /**
     * Pause execution and wait for user to press Enter
     */
    private static void pauseForUser() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
        clearScreen();
    }
    
    /**
     * Clear screen (simulate) by printing empty lines
     */
    private static void clearScreen() {
        // Print multiple empty lines to simulate screen clearing
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }
    
    /**
     * Display exit message when application closes
     */
    private static void displayExitMessage() {
        System.out.println();
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    THANK YOU!                           ║");
        System.out.println("║                                                          ║");
        System.out.println("║     Thank you for using Student Record Manager          ║");
        System.out.println("║              Have a great day!                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Final Statistics:");
        System.out.println("Total Students Managed: " + studentManager.getTotalStudents());
        System.out.println("Application closed successfully.");
    }
}