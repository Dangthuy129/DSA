import java.util.Scanner;

public class Main {
    // Code cải tiến từ Main class với try-catch bổ sung
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n=== Student Management ===");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Students");
                System.out.println("5. Display Students");
                System.out.println("6. Sort Students (Bubble Sort)");
                System.out.println("7. Sort Students (Selection Sort)");
                System.out.println("8. Exit");
                System.out.print("Enter your choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> { // Add Student
                        try {
                            System.out.print("Enter Student Name: ");
                            String name = scanner.nextLine();
                            if (!name.matches("[a-zA-Z\\s]+")) throw new IllegalArgumentException("Name must contain only letters and spaces.");

                            System.out.print("Enter Student Marks (0-10): ");
                            double marks = Double.parseDouble(scanner.nextLine());
                            if (marks < 0 || marks > 10) throw new IllegalArgumentException("Marks must be between 0 and 10.");

                            studentList.addStudent(name, marks);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 2 -> { // Edit Student
                        try {
                            System.out.print("Enter Student ID to edit: ");
                            int id = Integer.parseInt(scanner.nextLine());

                            StudentLinkedList.Node studentNode = studentList.findStudentById(id);
                            if (studentNode == null) throw new IllegalArgumentException("Student ID not found.");

                            System.out.print("Enter New Name: ");
                            String newName = scanner.nextLine();
                            if (!newName.matches("[a-zA-Z\\s]+")) throw new IllegalArgumentException("Name must contain only letters and spaces.");

                            System.out.print("Enter New Marks (0-10): ");
                            double newMarks = Double.parseDouble(scanner.nextLine());
                            if (newMarks < 0 || newMarks > 10) throw new IllegalArgumentException("Marks must be between 0 and 10.");

                            studentList.editStudent(id, newName, newMarks);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 3 -> { // Delete Student
                        try {
                            System.out.print("Enter Student ID to delete: ");
                            int id = Integer.parseInt(scanner.nextLine());

                            studentList.deleteStudent(id);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    case 4 -> { // Search Student
                        System.out.print("Enter name to search: ");
                        String name = scanner.nextLine();
                        studentList.searchStudentByName(name);
                    }
                    case 5 -> studentList.displayStudents(); // Display Students
                    case 6 -> studentList.bubbleSort();       // Bubble Sort
                    case 7 -> studentList.selectionSort();    // Selection Sort
                    case 8 -> { // Exit
                        System.out.println("Exiting...");
                        return;
                    }
                    case 9 -> {
                        System.out.print("Enter student ID to search: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        studentList.binarySearchById(id);
                    }
                    default -> System.out.println("Invalid choice. Please select from the menu.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }



        }
    }

}

