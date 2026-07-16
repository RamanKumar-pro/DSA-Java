import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents an Instructor, inheriting from the Person class.
 * An instructor can be assigned to a department and teach multiple courses.
 */
public class Instructor extends Person {
    private final LocalDate dateOfJoining;
    private Department department; // Direct object association
    private final List<Course> assignedCourses;

    public Instructor(String name, LocalDate dob, String email, String address, String contactNo, LocalDate dateOfJoining) {
        super("INS", name, dob, email, address, contactNo); // "INS" prefix for instructor IDs
        this.dateOfJoining = dateOfJoining;
        this.assignedCourses = new ArrayList<>();
    }

    // --- Getters ---
    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public Department getDepartment() {
        return department;
    }

    /**
     * Returns an unmodifiable view of the courses assigned to this instructor.
     */
    public List<Course> getAssignedCourses() {
        return Collections.unmodifiableList(assignedCourses);
    }

    // --- Setters / Association Management ---
    public void setDepartment(Department department) {
        this.department = department;
    }

    public void assignCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
            // Also set this instructor on the course object for bidirectional association
            course.setCourseInstructor(this);
        }
    }

    public void removeCourse(Course course) {
        if (assignedCourses.remove(course)) {
            // Remove the instructor from the course object as well
            course.setCourseInstructor(null);
        }
    }

    @Override
    public String toString() {
        String departmentName = (department != null) ? department.getDepartmentName() : "N/A";
        return String.format("Instructor -> %s | Joined: %s | Department: %s",
                super.toString(), dateOfJoining, departmentName);
    }
}
