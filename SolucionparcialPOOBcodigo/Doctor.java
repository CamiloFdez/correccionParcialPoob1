import java.time.*;

public class Doctor {
    private String id;          
    private String name;          
    private String specialty;    
    private String phone;        
    private Office office;       
    private boolean isAvailable;  

    /**
     * Constructor for the Doctor class.
     */
    public Doctor(String id, String name, String specialty, String phone, Office office) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.phone = phone;
        this.office = office;
        this.isAvailable = true;
    }

    /**
     * Method to get the doctor's ID.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Method to check the doctor's availability on a specific date and time slot.
     *
     * @param date - The date of the appointment.
     * @param timeSlot - The time slot for the appointment.
     */
    public boolean isAvailable(LocalDate date, int timeSlot) {
        return this.isAvailable; 
    }

    /**
     * Method to get the doctor's specialty.
     */
    public String getSpecialty() {
        return this.specialty;
    }

    /**
     * Method to get the doctor's office.
     */
    public Office getOffice() {
        return this.office;
    }
}