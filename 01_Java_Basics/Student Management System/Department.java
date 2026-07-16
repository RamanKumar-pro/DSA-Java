import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Represents an academic department.
 * It manages lists of its courses, instructors, and students.
 */
public class Department {
    private final String departmentId;
    private final String departmentName;
    private final List<Course> courses;
    private final List<Instructor> instructors;
    private final List<Student> students;

    public Department(String departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // --- Getters ---
    public String getDepartmentId() { return departmentId; }
    public String getDepartmentName() { return departmentName; }

    /**
     * Returns an unmodifiable view of the courses offered by this department.
     */
    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    /**
     * Returns an unmodifiable view of the instructors in this department.
     */
    public List<Instructor> getInstructors() {
        return Collections.unmodifiableList(instructors);
    }

    /**
     * Returns an unmodifiable view of the students in this department.
     */
    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    // --- Association Management ---
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.setOfferingDepartment(this);
        }
    }

    public void addInstructor(Instructor instructor) {
        if (!instructors.contains(instructor)) {
            instructors.add(instructor);
            instructor.setDepartment(this);
        }
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            // Note: A student might not have a direct 'setDepartment' method if they
            // can take courses from multiple departments. This is a design choice.
        }
    }

    @Override
    public String toString() {
        return String.format("Department: %s (%s) | Courses: %d | Instructors: %d | Students: %d",
                departmentName, departmentId, courses.size(), instructors.size(), students.size());
    }

    /**
     * Two departments are considered equal if they have the same ID.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(departmentId, that.departmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId);
    }
}
