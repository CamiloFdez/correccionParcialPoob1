import java.time.*;
import java.util.*;

public class Appointment {
    private String id;         
    private LocalDate date;    
    private int timeSlot;      
    private Doctor doctor;       
    private Office office;       

    /**
     * Constructor for the Appointment class.
     */
    public Appointment(Doctor doctor, Office office, LocalDate date, int timeSlot) {
        this.id = generateId(doctor, office, date, timeSlot); 
        this.doctor = doctor;
        this.office = office;
        this.date = date;
        this.timeSlot = timeSlot;
    }

    /**
     * Method to generate a unique ID based on certain attributes.
     * 
     * @param doctor - The assigned doctor.
     * @param office - The office where the appointment will take place.
     * @param date - The date of the appointment.
     * @param timeSlot - The time slot of the appointment.
     */
    private String generateId(Doctor doctor, Office office, LocalDate date, int timeSlot) {
        return doctor.getId() + "-" + date.toString() + "-" + timeSlot;
    }

    /**
     * Method to get the appointment ID.
     */
    public String getId() {
        return this.id;
    }

    /**
     * Method to get the list of available time slots (8:00 AM to 8:00 PM in 20-minute intervals).
     */
    public static List<LocalTime> getTimeSlots() {
        List<LocalTime> timeSlots = new ArrayList<>();
        LocalTime startTime = LocalTime.of(8, 0); // 8:00 AM
        LocalTime endTime = LocalTime.of(20, 0);  // 8:00 PM

    
        for (LocalTime time = startTime; time.isBefore(endTime.plusMinutes(1)); time = time.plusMinutes(20)) {
            timeSlots.add(time);
        }

        return timeSlots;
    }

    /**
     * Method to get the time corresponding to a time slot number (1 to 36).
     */
    public LocalTime getTimeForSlot() {
        List<LocalTime> timeSlots = getTimeSlots();
        if (timeSlot >= 1 && timeSlot <= timeSlots.size()) {
            return timeSlots.get(timeSlot - 1); 
        } else {
            throw new IllegalArgumentException("Time slot fuera de rango. Debe estar entre 1 y 36.");
        }
    }

    /**
     * Method to get the human-readable time slot number (e.g., 1 for 8:00 AM, 2 for 8:20 AM, etc.)
     */
    public int getTimeSlot() {
        return this.timeSlot;
    }
}