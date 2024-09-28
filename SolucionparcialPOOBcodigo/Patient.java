import java.time.*;
import java.util.*;

public class Patient {
    private String idCard;                  
    private String name;                   
    private String address;                
    private LocalDate birthDate;           
    private LocalDate registrationDate;     
    private ArrayList<Appointment> appointments; 
    private MedicalHistory medicalHistory;   

    /**
     * Constructor for the Patient class.
     */
    public Patient(String idCard, String name, String address, LocalDate birthDate) {
        this.idCard = idCard; 
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.registrationDate = LocalDate.now(); 
        this.appointments = new ArrayList<>(); 
        this.medicalHistory = new MedicalHistory(); 
    }

    /**
     * Method to get the patient's identity card.
     *
     * @return The patient's identity card.
     */
    public String getIdCard() {
        return this.idCard;
    }

    /**
     * Method to retrieve a patient's appointment based on its ID or time slots.
     *
     * @param appointmentId - The ID of the appointment to search for.
     * @param timeSlots - List of time slots.
    */
    public Appointment getAppointment(String appointmentId, List<LocalTime> timeSlots) {
        for (Appointment a : appointments) {
          
            if (a.getId().equals(appointmentId) || a.getTimeSlots().equals(timeSlots)) {  
                return a; 
            }
        }
        return null; 
    }

    /**
     * Method to add an appointment to the patient's list of appointments.
     *
     * @param appointment - The appointment to add.
     */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment); 
    }
}
