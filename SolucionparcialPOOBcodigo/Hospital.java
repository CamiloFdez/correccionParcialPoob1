import java.util.*;
import java.time.*;

public class Hospital {
    private String name;
    private String address;
    private ArrayList<Office> offices;   
    private ArrayList<Doctor> doctors; 
    private Location location;         
    private ArrayList<Treatment> treatments;  
    
    /**
     * Constructor for the Hospital class.
     */
    public Hospital(String name, String address, Location location) {
        this.name = name;
        this.address = address;
        this.location = location;
        this.offices = new ArrayList<>();
        this.doctors = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }
    
    /**
     * Creates a medical appointment for a patient.
     * It checks if there is an available doctor with the requested specialty and an available office.
     * If both conditions are met, the appointment is generated.
     * 
     * @param p - The patient requesting the appointment.
     * @param requestedSpecialty - The requested medical specialty.
     * @param date - The date of the appointment.
     * @param timeSlot - The requested time slot for the appointment.
     */
    public void createAppointment(Patient p, String requestedSpeciality, LocalDate date, int timeSlot) {
        for (Doctor d : doctors) {
         
            if (d.getSpecialty().equals(requestedSpeciality) && d.isAvailable(date, timeSlot)) {
                Office o = getOffice();  
                if (o != null) {
                    generateAppointment(p, d, o, date, timeSlot); 
                    return; 
                }
            }
        }
    }
    
    /**
     * Generates a medical appointment between a patient and a doctor in an office.
     * 
     * @param patient - The patient receiving the appointment.
     * @param doctor - The doctor assigned to the appointment.
     * @param office - The office where the appointment will take place.
     * @param date - The date of the appointment.
     * @param timeSlot - The requested time slot for the appointment.
     */
    public void generateAppointment(Patient patient, Doctor doctor, Office office, LocalDate date, int timeSlot) {
        Appointment a = new Appointment(doctor, office, date, timeSlot); 
        patient.addAppointment(a);  
    }
    
    /**
     * Returns an available office for scheduling an appointment.
     */
    public Office getOffice() {
        for (Office office : offices) {
            return office; 
        }
        return null;  
    }
}

