import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SMS {
    private static final ManagementSystem ms = new ManagementSystem();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Student Management System");
        loadSampleData();

        while (true) {
            printMainMenu();
            try {
                int choice = getIntInput();
                switch (choice) {
                    case 1: handleStudentActions(); break;
                    case 2: handleCourseActions(); break;
                    case 3: handleAdminActions(); break;
                    case 4: handleReportingActions(); break;
                    case 5: System.out.println("Exiting... Thank you!"); return;
                    default: System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void printMainMenu() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                MAIN MENU");
        System.out.println("=".repeat(50));
        System.out.println("1. Student Actions");
        System.out.println("2. Course & Enrollment Actions");
        System.out.println("3. Administrative Actions");
        System.out.println("4. Reporting");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // --- SUB-MENU HANDLERS ---

    private static void handleStudentActions() {
        System.out.println("\n--- Student Actions ---");
        System.out.println("1. View Student Details");
        System.out.println("2. Back to Main Menu");
        System.out.print("Enter your choice: ");
        if (getIntInput() == 1) viewStudentDetails();
    }
    
    private static void handleCourseActions() {
        System.out.println("\n--- Course & Enrollment Actions ---");
        System.out.println("1. Enroll Student in Course");
        System.out.println("2. Unenroll Student from Course");
        System.out.println("3. Assign Mark to Student");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch(choice) {
            case 1: enrollStudent(); break;
            case 2: unenrollStudent(); break;
            case 3: assignMark(); break;
            default: System.out.println("Invalid choice.");
        }
    }

    private static void handleAdminActions() {
        System.out.println("\n--- Administrative Actions ---");
        System.out.println("1. Add New Student");
        System.out.println("2. Add New Course");
        System.out.println("3. Add New Department");
        System.out.println("4. Remove Student");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch(choice) {
            case 1: addStudent(); break;
            case 2: addCourse(); break;
            case 3: addDepartment(); break;
            case 4: removeStudent(); break;
            default: System.out.println("Invalid choice.");
        }
    }

    private static void handleReportingActions() {
        System.out.println("\n--- Reporting Actions ---");
        System.out.println("1. View Department Topper");
        System.out.println("2. View Department Students by GPA");
        System.out.println("3. List All Students");
        System.out.println("4. List All Courses");
        System.out.print("Enter your choice: ");
        int choice = getIntInput();
        switch(choice) {
            case 1: viewDepartmentTopper(); break;
            case 2: viewDepartmentStudentsByGpa(); break;
            case 3: ms.getAllStudents().forEach(System.out::println); break;
            case 4: ms.getAllCourses().forEach(System.out::println); break;
            default: System.out.println("Invalid choice.");
        }
    }

    // --- FULLY IMPLEMENTED ACTION METHODS ---

    private static void addStudent() {
        try {
            System.out.println("\n--- Add New Student ---");
            System.out.print("Enter Name: ");
            String name = sc.nextLine();
            System.out.print("Enter DoB (YYYY-MM-DD): ");
            LocalDate dob = LocalDate.parse(sc.nextLine());
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            System.out.print("Enter Address: ");
            String address = sc.nextLine();
            System.out.print("Enter Contact No: ");
            String contactNo = sc.nextLine();
            
            Student newStudent = ms.addStudent(name, dob, email, address, contactNo, LocalDate.now());
            System.out.println("Student added successfully! Generated ID: " + newStudent.getId());
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
        }
    }

    private static void addCourse() {
        try {
            System.out.println("\n--- Add New Course ---");
            System.out.print("Enter Course Code (e.g., CS101): ");
            String code = sc.nextLine();
            System.out.print("Enter Course Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Credits: ");
            int credits = getIntInput();
            System.out.print("Enter Max Capacity: ");
            int capacity = getIntInput();

            Course newCourse = ms.addCourse(code, name, credits, capacity);
            System.out.println("Course added successfully! -> " + newCourse);
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid number format for credits or capacity.");
        }
    }

    private static void addDepartment() {
        System.out.println("\n--- Add New Department ---");
        System.out.print("Enter Department ID (e.g., CS): ");
        String id = sc.nextLine();
        System.out.print("Enter Department Name: ");
        String name = sc.nextLine();
        Department newDept = ms.addDepartment(id, name);
        System.out.println("Department added successfully! -> " + newDept);
    }

    private static void removeStudent() {
        try {
            System.out.print("Enter Student ID to remove: ");
            String studentId = sc.nextLine();
            ms.removeStudent(studentId);
            System.out.println("Student removed successfully.");
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewStudentDetails() {
        try {
            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine();
            Student student = ms.findStudentById(studentId);
            System.out.println(student);
            System.out.println("Enrolled Courses:");
            student.getEnrolledCoursesWithMarks().forEach((course, mark) -> 
                System.out.printf("  - %s, Mark: %.1f\n", course.getCourseName(), mark)
            );
        } catch (StudentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void enrollStudent() {
        try {
            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine();
            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine();
            ms.enrollStudentInCourse(studentId, courseCode);
            System.out.println("Enrollment successful!");
        } catch (StudentNotFoundException | CourseNotFoundException | CourseFullException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void unenrollStudent() {
        try {
            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine();
            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine();
            ms.unenrollStudentFromCourse(studentId, courseCode);
            System.out.println("Unenrollment successful.");
        } catch (StudentNotFoundException | CourseNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void assignMark() {
        try {
            System.out.print("Enter Student ID: ");
            String studentId = sc.nextLine();
            System.out.print("Enter Course Code: ");
            String courseCode = sc.nextLine();
            System.out.print("Enter Mark (0-100): ");
            double mark = sc.nextDouble();
            sc.nextLine(); // Consume newline
            ms.assignMark(studentId, courseCode, mark);
            System.out.println("Mark assigned successfully!");
        } catch (StudentNotFoundException | CourseNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input for mark. Please enter a number.");
            sc.nextLine();
        }
    }
    
    private static void viewDepartmentTopper() {
        try {
            System.out.print("Enter Department ID (e.g., CS, MA): ");
            String deptId = sc.nextLine();
            Student topper = ms.getDepartmentTopper(deptId);
            if (topper != null) {
                System.out.println("Department Topper: " + topper);
            } else {
                System.out.println("No students found in this department.");
            }
        } catch (DepartmentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewDepartmentStudentsByGpa() {
        try {
            System.out.print("Enter Department ID (e.g., CS, MA): ");
            String deptId = sc.nextLine();
            List<Student> students = ms.getStudentsByDepartmentSortedByGpa(deptId);
            System.out.println("--- Students of Department " + deptId + " (Sorted by GPA) ---");
            if (students.isEmpty()) {
                System.out.println("No students found.");
            } else {
                students.forEach(System.out::println);
            }
        } catch (DepartmentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void loadSampleData() {
        Department cs = ms.addDepartment("CS", "Computer Science");
        Department ma = ms.addDepartment("MA", "Mathematics");
        Course cs101 = ms.addCourse("CS101", "Intro to Programming", 3, 3);
        cs.addCourse(cs101);
        Course ma201 = ms.addCourse("MA201", "Calculus II", 4, 40);
        ma.addCourse(ma201);
        Student stu1 = ms.addStudent("Alice", LocalDate.of(2002, 5, 20), "a@a.com", "Addr1", "111", LocalDate.of(2023, 9, 1));
        Student stu2 = ms.addStudent("Bob", LocalDate.of(2001, 8, 15), "b@b.com", "Addr2", "222", LocalDate.of(2023, 9, 1));
        Student stu3 = ms.addStudent("Charlie", LocalDate.of(2002, 1, 30), "c@c.com", "Addr3", "333", LocalDate.of(2023, 9, 1));
        try {
            ms.enrollStudentInCourse(stu1.getId(), cs101.getCourseCode());
            ms.enrollStudentInCourse(stu1.getId(), ma201.getCourseCode());
            ms.enrollStudentInCourse(stu2.getId(), cs101.getCourseCode());
            ms.enrollStudentInCourse(stu3.getId(), cs101.getCourseCode());
            ms.assignMark(stu1.getId(), cs101.getCourseCode(), 88);
            ms.assignMark(stu1.getId(), ma201.getCourseCode(), 92);
            ms.assignMark(stu2.getId(), cs101.getCourseCode(), 76);
            ms.assignMark(stu3.getId(), cs101.getCourseCode(), 95);
        } catch (Exception e) {
            System.out.println("Error loading sample data: " + e.getMessage());
        }
        System.out.println("Sample data loaded.");
    }

    // Helper to get integer input robustly
    private static int getIntInput() {
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the rest of the line
        return choice;
    }
}
