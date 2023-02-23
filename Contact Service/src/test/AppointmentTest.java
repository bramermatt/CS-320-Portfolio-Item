package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.Appointment;

class AppointmentTest {

  private String id, description;
  private String tooLongId, tooLongDescription;
  private Date date, pastDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp() {
    id = "1234567890";
    description = "The appt object shall have a required description.";
    date = new Date(3021, Calendar.JANUARY, 1);
    tooLongId = "111222333444555666777888999";
    tooLongDescription =
        "This description is too long for the appointment requirements but good for testing.";
    pastDate = new Date(0);
  }

  
  
  
  @Test
  void testUpdateAppointmentId() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateAppointmentID(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateAppointmentID(tooLongId));
    appt.updateAppointmentID(id);
    assertEquals(id, appt.getAppointmentID());
    System.out.println("AppointmentTest.java - test update appointment ID complete.");
  }

  @Test
  void testGetAppointmentId() {
    Appointment appt = new Appointment(id);
    assertNotNull(appt.getAppointmentID());
    assertEquals(appt.getAppointmentID().length(), 10);
    assertEquals(id, appt.getAppointmentID());
    System.out.println("AppointmentTest.java - test get appointment ID complete.");
  }

  @Test
  void testUpdateDate() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class, () -> appt.updateDate(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDate(pastDate));
    appt.updateDate(date);
    assertEquals(date, appt.getAppointmentDate());
    
    System.out.println("AppointmentTest.java - test update date complete.");
  }

  @Test
  void testGetAppointmentDate() {
    Appointment appt = new Appointment(id, date);
    assertNotNull(appt.getAppointmentDate());
    assertEquals(date, appt.getAppointmentDate());
    
    System.out.println("AppointmentTest.java - test get appointment date complete.");
  }

  @Test
  void testUpdateDescription() {
    Appointment appt = new Appointment();
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDescription(null));
    assertThrows(IllegalArgumentException.class,
                 () -> appt.updateDescription(tooLongDescription));
    appt.updateDescription(description);
    assertEquals(description, appt.getDescription());
    
    System.out.println("AppointmentTest.java - test update description complete.");
  }

  @Test
  void testGetDescription() {
    Appointment appt = new Appointment(id, date, description);
    assertNotNull(appt.getDescription());
    assertTrue(appt.getDescription().length() <= 50);
    assertEquals(description, appt.getDescription());
    
    System.out.println("AppointmentTest.java - test get description complete.");
  }
}