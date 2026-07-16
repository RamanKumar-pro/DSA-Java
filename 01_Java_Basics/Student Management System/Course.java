import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents a course in the management system.
 * Manages its own enrollment and capacity.
 */
public class Course {
    private final String courseCode; // e.g., "CS101"
    private final String courseName;
    private final int credits;
    private final int maxCapacity;
    private Department offeringDepartment;
    private Instructor courseInstructor;
    private final List<Student> enrolledStudents;

    public Course(String courseCode, String courseName, int credits, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    // --- Getters ---
    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getCredits() { return credits; }
    public Department getOfferingDepartment() { return offeringDepartment; }
    public Instructor getCourseInstructor() { return courseInstructor; }
    public int getCurrentEnrollment() { return enrolledStudents.size(); }
    public int getMaxCapacity() { return maxCapacity; }

    /**
     * Returns an unmodifiable view of the enrolled students list.
     */
    public List<Student> getEnrolledStudents() {
        return Collections.unmodifiableList(enrolledStudents);
    }

    // --- Setters for mutable associations ---
    public void setCourseInstructor(Instructor courseInstructor) {
        this.courseInstructor = courseInstructor;
    }

    public void setOfferingDepartment(Department offeringDepartment) {
        this.offeringDepartment = offeringDepartment;
    }

    // --- Enrollment Management ---
    /**
     * Adds a student to the course if there is capacity.
     * @param student The student to enroll.
     * @return true if enrollment was successful, false otherwise.
     */
    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            return true;
        }
        System.out.println("Enrollment failed: Course " + courseName + " is full.");
        return false;
    }

    /**
     * Removes a student from the course.
     * @param student The student to remove.
     */
    public void removeStudent(Student student) {
        enrolledStudents.remove(student);
    }

    public boolean isFull() {
        return enrolledStudents.size() >= maxCapacity;
    }

    @Override
    public String toString() {
        return String.format("Course: %s (%s), Credits: %d, Enrollment: %d/%d",
                courseName, courseCode, credits, getCurrentEnrollment(), maxCapacity);
    }

    /**
     * Two courses are considered equal if they have the same course code.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }
}
