/**
 * Custom exception thrown when an operation is attempted on a student
 * that does not exist in the system.
 */
public class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}
