package school;

import java.util.Date;

public class Appointment {
	final private byte APPOINTMENT_ID_LENGTH;
	final private byte APPOINTMENT_DESCRIPTION_LENGTH;
	final private String INITIALIZER;
	private String appointmentID;
	private Date appointmentDate;
	private String description;
	
	{
		APPOINTMENT_ID_LENGTH = 10;
		APPOINTMENT_DESCRIPTION_LENGTH = 50;
		INITIALIZER = "INITIAL";
	}
	
	public Appointment() {
		Date today = new Date();
		appointmentID = INITIALIZER;
		appointmentDate = today;
		description = INITIALIZER;
	}
	
	public Appointment(String ID) {
		Date today = new Date();
		updateAppointmentID(ID);
		appointmentDate = today;
		description = INITIALIZER;
	}
	
	public Appointment(String ID, Date date) {
		updateAppointmentID(ID);
		updateDate(date);
		description = INITIALIZER;
	}
	
	public Appointment(String ID, Date date, String description) {
		updateAppointmentID(ID);
		updateDate(date);
		updateDescription(description);
	}
	
	public void updateAppointmentID(String ID) {
		if (ID == null) {
			throw new IllegalArgumentException("Appointment ID cannot be null.");
		} else if (ID.length() > APPOINTMENT_ID_LENGTH) {
			throw new IllegalArgumentException("Appointment ID cannot exceed " + APPOINTMENT_ID_LENGTH + " characters.");
		} else {
			this.appointmentID = ID;
		}
	}
	
	public String getAppointmentID() { return appointmentID; }
	
	  public void updateDate(Date date) {
		    if (date == null) {
		      throw new IllegalArgumentException("Appointment date cannot be null.");
		    } else if (date.before(new Date())) {
		      throw new IllegalArgumentException(
		          "Cannot make appointment in the past.");
		    } else {
		      this.appointmentDate = date;
		    }
		  }
	  
	  
	  public Date getAppointmentDate() { return appointmentDate; }

	  public void updateDescription(String description) {
	    if (description == null) {
	      throw new IllegalArgumentException(
	          "Appointment description cannot be null.");
	    } else if (description.length() > APPOINTMENT_DESCRIPTION_LENGTH) {
	      throw new IllegalArgumentException(
	          "Appointment description cannot exceed " +
	          APPOINTMENT_DESCRIPTION_LENGTH + " characters.");
	    } else {
	      this.description = description;
	    }
	  }

	  public String getDescription() { return description; }

}