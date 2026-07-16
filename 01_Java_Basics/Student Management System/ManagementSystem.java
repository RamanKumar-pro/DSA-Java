import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * The central logic unit for the Student Management System.
 * It handles all data storage and business logic, acting as a single source of truth.
 */
public class ManagementSystem {
    private final Map<String, Student> students = new HashMap<>();
    private final Map<String, Instructor> instructors = new HashMap<>();
    private final Map<String, Course> courses = new HashMap<>();
    private final Map<String, Department> departments = new HashMap<>();

    // --- Add Methods ---
    public Student addStudent(String name, LocalDate dob, String email, String address, String contactNo, LocalDate admissionDate) {
        Student student = new Student(name, dob, email, address, contactNo, admissionDate);
        students.put(student.getId(), student);
        return student;
    }
    public Course addCourse(String courseCode, String courseName, int credits, int maxCapacity) {
        Course course = new Course(courseCode, courseName, credits, maxCapacity);
        courses.put(course.getCourseCode(), course);
        return course;
    }
    public Department addDepartment(String deptId, String deptName) {
        Department dept = new Department(deptId, deptName);
        departments.put(dept.getDepartmentId(), dept);
        return dept;
    }
    public Instructor addInstructor(String name, LocalDate dob, String email, String address, String contactNo, LocalDate joinDate) {
        Instructor instructor = new Instructor(name, dob, email, address, contactNo, joinDate);
        instructors.put(instructor.getId(), instructor);
        return instructor;
    }

    // --- Finders ---
    public Student findStudentById(String studentId) throws StudentNotFoundException {
        if (!students.containsKey(studentId)) throw new StudentNotFoundException("Student with ID '" + studentId + "' not found.");
        return students.get(studentId);
    }
    public Course findCourseByCode(String courseCode) throws CourseNotFoundException {
        if (!courses.containsKey(courseCode)) throw new CourseNotFoundException("Course with code '" + courseCode + "' not found.");
        return courses.get(courseCode);
    }
    public Department findDepartmentById(String deptId) throws DepartmentNotFoundException {
        if (!departments.containsKey(deptId)) throw new DepartmentNotFoundException("Department with ID '" + deptId + "' not found.");
        return departments.get(deptId);
    }

    // --- Core Business Logic & CRUD ---
    public void enrollStudentInCourse(String studentId, String courseCode) throws StudentNotFoundException, CourseNotFoundException, CourseFullException {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);
        if (course.isFull()) throw new CourseFullException("Course '" + course.getCourseName() + "' is full.");
        student.enrollInCourse(course);
        course.addStudent(student);
    }

    public void assignMark(String studentId, String courseCode, double mark) throws StudentNotFoundException, CourseNotFoundException {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);
        student.assignMark(course, mark);
    }

    public void unenrollStudentFromCourse(String studentId, String courseCode) throws StudentNotFoundException, CourseNotFoundException {
        Student student = findStudentById(studentId);
        Course course = findCourseByCode(courseCode);
        student.unenrollFromCourse(course);
        course.removeStudent(student);
    }

    public boolean removeStudent(String studentId) throws StudentNotFoundException {
        Student student = findStudentById(studentId);
        // Unenroll from all courses
        for (Course course : student.getEnrolledCoursesWithMarks().keySet()) {
            course.removeStudent(student);
        }
        // Remove from any department lists (if applicable)
        departments.values().forEach(dept -> dept.getStudents().remove(student));
        // Remove from main registry
        students.remove(studentId);
        return true;
    }

    // --- Reporting ---
    public List<Student> getStudentsByDepartmentSortedByGpa(String deptId) throws DepartmentNotFoundException {
        Department dept = findDepartmentById(deptId);
        // This is a simplified assumption: students belong to a department if they are in any of its courses.
        // A more robust system might have a direct Student-Department link.
        Set<Student> studentsInDept = new HashSet<>();
        for (Course course : dept.getCourses()) {
            studentsInDept.addAll(course.getEnrolledStudents());
        }
        return studentsInDept.stream()
                .sorted(Comparator.comparingDouble(Student::calculateGPA).reversed())
                .collect(Collectors.toList());
    }

    public Student getDepartmentTopper(String deptId) throws DepartmentNotFoundException {
        List<Student> sortedStudents = getStudentsByDepartmentSortedByGpa(deptId);
        return sortedStudents.isEmpty() ? null : sortedStudents.get(0);
    }

    // --- Data Retrieval ---
    public Collection<Student> getAllStudents() { return Collections.unmodifiableCollection(students.values()); }
    public Collection<Course> getAllCourses() { return Collections.unmodifiableCollection(courses.values()); }
    public Collection<Instructor> getAllInstructors() { return Collections.unmodifiableCollection(instructors.values()); }
    public Collection<Department> getAllDepartments() { return Collections.unmodifiableCollection(departments.values()); }
}
