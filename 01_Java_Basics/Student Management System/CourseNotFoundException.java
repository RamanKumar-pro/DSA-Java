/**
 * Custom exception thrown when an operation is attempted on a course
 * that does not exist in the system.
 */
public class CourseNotFoundException extends Exception {
    public CourseNotFoundException(String message) {
        super(message);
    }
}
