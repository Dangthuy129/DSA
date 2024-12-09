import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentLinkedList {
    public Node head;

    public class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    public void addStudent(String name, double marks) {
        try {
            Student newStudent = new Student(name, marks);
            Node newNode = new Node(newStudent);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            System.out.println("Student added successfully!");
            displayStudents();
        } catch (Exception e) {
            System.out.println("Error while adding student: " + e.getMessage());
        }
    }

    public void editStudent(int id, String newName, double newMarks) {
        try {
            Node current = head;
            while (current != null) {
                if (current.student.getId() == id) {
                    System.out.println("Current Student Info: ");
                    System.out.println(current.student);

                    current.student.setName(newName);
                    current.student.setMarks(newMarks);
                    System.out.println("Student updated successfully!");
                    displayStudents();
                    return;
                }
                current = current.next;
            }
            System.out.println("Student not found.");
        } catch (Exception e) {
            System.out.println("Error while editing student: " + e.getMessage());
        }
    }

    public void deleteStudent(int id) {
        try {
            if (head == null) {
                System.out.println("No students to delete.");
                return;
            }
            if (head.student.getId() == id) {
                head = head.next;
                System.out.println("Student deleted successfully!");
                displayStudents();
                return;
            }
            Node current = head;
            while (current.next != null) {
                if (current.next.student.getId() == id) {
                    current.next = current.next.next;
                    System.out.println("Student deleted successfully!");
                    displayStudents();
                    return;
                }
                current = current.next;
            }
            System.out.println("Student not found.");
        } catch (Exception e) {
            System.out.println("Error while deleting student: " + e.getMessage());
        }
    }

    public void displayStudents() {
        try {
            if (head == null) {
                System.out.println("No students to display.");
            } else {
                Node current = head;
                System.out.printf("%-5s %-20s %-10s %-15s\n", "ID", "Name", "Marks", "Rank");
                System.out.println("-----------------------------------------------");

                while (current != null) {
                    System.out.printf("%-5d %-20s %-10.2f %-15s\n", current.student.getId(), current.student.getName(),
                            current.student.getMarks(), current.student.getRank());
                    current = current.next;
                }
            }
        } catch (Exception e) {
            System.out.println("Error while displaying students: " + e.getMessage());
        }
    }

    public void bubbleSort() {
        try {
            if (head == null) {
                System.out.println("No students to sort.");
                return;
            }
            for (Node i = head; i != null; i = i.next) {
                for (Node j = i.next; j != null; j = j.next) {
                    if (i.student.getMarks() > j.student.getMarks()) {
                        Student temp = i.student;
                        i.student = j.student;
                        j.student = temp;
                    }
                }
            }
            System.out.println("Students sorted using Bubble Sort.");
            displayStudents();
        } catch (Exception e) {
            System.out.println("Error during Bubble Sort: " + e.getMessage());
        }
    }

    public void selectionSort() {
        try {
            if (head == null) {
                System.out.println("No students to sort.");
                return;
            }
            for (Node i = head; i != null; i = i.next) {
                Node minNode = i;
                for (Node j = i.next; j != null; j = j.next) {
                    if (j.student.getMarks() < minNode.student.getMarks()) {
                        minNode = j;
                    }
                }
                Student temp = i.student;
                i.student = minNode.student;
                minNode.student = temp;
            }
            System.out.println("Students sorted using Selection Sort.");
            displayStudents();
        } catch (Exception e) {
            System.out.println("Error during Selection Sort: " + e.getMessage());
        }
    }

    public Node findStudentById(int id) {
        try {
            Node current = head;
            while (current != null) {
                if (current.student.getId() == id) {
                    return current;
                }
                current = current.next;
            }
        } catch (Exception e) {
            System.out.println("Error while searching for student by ID: " + e.getMessage());
        }
        return null;
    }
    public void binarySearchById(int targetId) {
        try {
            if (head == null) {
                System.out.println("No students to search.");
                return;
            }
            List<Student> studentsList = new ArrayList<>();
            Node current = head;
            while (current != null) {
                studentsList.add(current.student);
                current = current.next;
            }
            studentsList.sort(Comparator.comparingInt(Student::getId));
            int left = 0;
            int right = studentsList.size() - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                Student midStudent = studentsList.get(mid);

                if (midStudent.getId() == targetId) {
                    System.out.println("Student found: " + midStudent);
                    return;
                } else if (midStudent.getId() < targetId) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            System.out.println("Student with ID " + targetId + " not found.");
        } catch (Exception e) {
            System.out.println("Error during Binary Search: " + e.getMessage());
        }
    }



    public void searchStudentByName(String name) {
        try {
            boolean found = false;
            Node current = head;
            while (current != null) {
                if (current.student.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(current.student);
                    found = true;
                }
                current = current.next;
            }
            if (!found) {
                System.out.println("No student found with name: " + name);
            }
        } catch (Exception e) {
            System.out.println("Error while searching for student by name: " + e.getMessage());
        }
    }
}
