/**
 * Custom exception thrown when an operation is attempted on a department
 * that does not exist in the system.
 */
public class DepartmentNotFoundException extends Exception {
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
