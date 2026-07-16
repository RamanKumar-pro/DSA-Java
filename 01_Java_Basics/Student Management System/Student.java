import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Student, inheriting from the Person class.
 * A student can enroll in courses and be assigned marks.
 */
public class Student extends Person {
    private final LocalDate dateOfAdmission;
    private final Map<Course, Double> enrolledCoursesWithMarks;

    public Student(String name, LocalDate dob, String email, String address, String contactNo, LocalDate admissionDate) {
        super("STU", name, dob, email, address, contactNo); // "STU" prefix for student IDs
        this.dateOfAdmission = admissionDate;
        this.enrolledCoursesWithMarks = new HashMap<>();
    }

    // --- Getters ---
    public LocalDate getDateOfAdmission() {
        return dateOfAdmission;
    }

    public Map<Course, Double> getEnrolledCoursesWithMarks() {
        return Collections.unmodifiableMap(enrolledCoursesWithMarks);
    }

    // --- Course Management ---
    public void enrollInCourse(Course course) {
        enrolledCoursesWithMarks.putIfAbsent(course, 0.0);
    }
    
    public void unenrollFromCourse(Course course) {
        enrolledCoursesWithMarks.remove(course);
    }

    public void assignMark(Course course, double mark) {
        if (enrolledCoursesWithMarks.containsKey(course)) {
            if (mark < 0.0 || mark > 100.0) {
                System.out.println("Warning: Mark should be between 0 and 100.");
            } else {
                enrolledCoursesWithMarks.put(course, mark);
            }
        } else {
            System.out.println("Warning: Cannot assign mark. Student not enrolled in course " + course.getCourseName());
        }
    }

    public double calculateGPA() {
        if (enrolledCoursesWithMarks.isEmpty()) {
            return 0.0;
        }

        double totalPoints = 0.0;
        int totalCredits = 0;

        for (Map.Entry<Course, Double> entry : enrolledCoursesWithMarks.entrySet()) {
            Course course = entry.getKey();
            double mark = entry.getValue();
            int credits = course.getCredits();

            int gradePoint = 0;
            if (mark > 85) gradePoint = 10;
            else if (mark > 75) gradePoint = 9;
            else if (mark > 65) gradePoint = 8;
            else if (mark > 55) gradePoint = 7;
            else if (mark > 50) gradePoint = 6;
            else if (mark > 45) gradePoint = 5;
            else if (mark > 40) gradePoint = 4;

            totalPoints += (double) gradePoint * credits;
            totalCredits += credits;
        }
        
        return (totalCredits == 0) ? 0.0 : totalPoints / totalCredits;
    }

    @Override
    public String toString() {
        return String.format("Student -> %s | Admission: %s | GPA: %.2f",
                super.toString(), dateOfAdmission, calculateGPA());
    }
}
