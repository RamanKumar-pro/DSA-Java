import java.time.LocalDate;
import java.time.Period;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * An abstract base class representing a person in the management system.
 * It cannot be instantiated directly but provides common attributes and functionality
 * for subclasses like Student and Instructor.
 */
public abstract class Person {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    
    private final String id;
    private final String name;
    private final LocalDate dob;
    private String email;
    private String address;
    private String contactNo;

    public Person(String idPrefix, String name, LocalDate dob, String email, String address, String contactNo) {
        this.id = idPrefix + idCounter.incrementAndGet();
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.contactNo = contactNo;
    }

    // --- Getters ---
    public String getId() { return id; }
    public String getName() { return name; }
    public LocalDate getDob() { return dob; }
    public String getEmail() { return email; }
    public String getAddress() { return address; }
    public String getContactNo() { return contactNo; }

    /**
     * Calculates the age of the person based on their date of birth.
     * @return The current age in years.
     */
    public int getAge() {
        if (dob == null) {
            return 0;
        }
        return Period.between(dob, LocalDate.now()).getYears();
    }

    // --- Setters for mutable fields ---
    public void setEmail(String email) { this.email = email; }
    public void setAddress(String address) { this.address = address; }
    public void setContactNo(String contactNo) { this.contactNo = contactNo; }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Age: %d, Email: %s",
                id, name, getAge(), email);
    }
}
