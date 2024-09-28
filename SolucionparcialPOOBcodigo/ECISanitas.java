import java.util.*;
import java.time.*;

public class ECISanitas {
    private TreeMap<String, Hospital> hospitals;
    private TreeMap<String, Patient> patients;
    private TreeMap<String, Illness> illness;
    
    /**
     * Constructor for the ECISanitas class.
     */
    public ECISanitas() {
        hospitals = new TreeMap<>();
        patients = new TreeMap<>();
        illness = new TreeMap<>();
    }
    
    /**
     * Schedules a medical appointment for a patient at a specific hospital.
     * Searches for the patient and hospital by their IDs, and if both exist,
     * delegates the appointment creation to the hospital.
     * 
     * Invariants:
     * - The patient must exist in the system.
     * - The hospital must exist in the system.
     * - The doctor with the requested specialty must be available on the chosen date and time slot.
     * - The office assigned to the appointment must be available at that time.
     * - The requested time slot must be within the valid range.
     * 
     * @param patientId - The ID of the patient requesting the appointment.
     * @param hospitalName - The name of the hospital where the appointment will be scheduled.
     * @param requestedSpecialty - The medical specialty requested for the appointment.
     * @param date - The requested date for the appointment.
     * @param timeSlot - The specific time slot requested for the appointment.
    */
    public void scheduleAppointment(String patientid, String hospitalName, String requestedSpeciality, LocalDate date, int timeSlot) {
        Patient p = getPatient(patientid); 
        Hospital h = getHospital(hospitalName);  
        
      
        if (p != null && h != null) {
            h.createAppointment(p, requestedSpeciality, date, timeSlot); 
        }
    }
    
    /**
     * Retrieves a patient by their ID.
     * 
     * @param patientId The ID of the patient.
     */
    public Patient getPatient(String patientid) {
        return patients.get(patientid);
    }
        
    /**
     * Retrieves a hospital by its name.
     * 
     * @param hospitalName The name of the hospital.
     */
    public Hospital getHospital(String hospitalName) {
        return hospitals.get(hospitalName);
    }
    
}