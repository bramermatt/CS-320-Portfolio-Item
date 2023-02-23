package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.AppointmentService;

class AppointmentServiceTest {
  private String id, description, tooLongDescription;
  private Date date, pastDate;

  @SuppressWarnings("deprecation")
  @BeforeEach
  void setUp() {
    id = "1234567890";
    description = "The appt object shall have a required description.";
    date = new Date(3021, Calendar.JANUARY, 1);
    tooLongDescription =
        "This description is too long for the appointment requirements but good for testing.";
    pastDate = new Date(0);
  }

  @Test
  void testNewAppointment() {
    AppointmentService service = new AppointmentService();

    service.newAppointment();
    assertNotNull(service.getAppointmentList().get(0).getAppointmentID());
    assertNotNull(service.getAppointmentList().get(0).getAppointmentDate());
    assertNotNull(service.getAppointmentList().get(0).getDescription());

    service.newAppointment(date);
    assertNotNull(service.getAppointmentList().get(1).getAppointmentID());
    assertEquals(date,
                 service.getAppointmentList().get(1).getAppointmentDate());
    assertNotNull(service.getAppointmentList().get(1).getDescription());

    service.newAppointment(date, description);
    assertNotNull(service.getAppointmentList().get(2).getAppointmentID());
    assertEquals(date,
                 service.getAppointmentList().get(2).getAppointmentDate());
    assertEquals(description,
                 service.getAppointmentList().get(2).getDescription());

    assertNotEquals(service.getAppointmentList().get(0).getAppointmentID(),
                    service.getAppointmentList().get(1).getAppointmentID());
    assertNotEquals(service.getAppointmentList().get(0).getAppointmentID(),
                    service.getAppointmentList().get(2).getAppointmentID());
    assertNotEquals(service.getAppointmentList().get(1).getAppointmentID(),
                    service.getAppointmentList().get(2).getAppointmentID());

    assertThrows(IllegalArgumentException.class,
                 () -> service.newAppointment(pastDate));
    assertThrows(IllegalArgumentException.class,
                 () -> service.newAppointment(date, tooLongDescription));
    
    System.out.println("AppointmentServiceTest.java - test new appointment complete.");
  }

  @Test
  void deleteAppointment() throws Exception {
    AppointmentService service = new AppointmentService();

    service.newAppointment();
    service.newAppointment();
    service.newAppointment();

    String firstId = service.getAppointmentList().get(0).getAppointmentID();
    String secondId = service.getAppointmentList().get(1).getAppointmentID();
    String thirdId = service.getAppointmentList().get(2).getAppointmentID();

    assertNotEquals(firstId, secondId);
    assertNotEquals(firstId, thirdId);
    assertNotEquals(secondId, thirdId);
    assertNotEquals(id, firstId);
    assertNotEquals(id, secondId);
    assertNotEquals(id, thirdId);

    assertThrows(Exception.class, () -> service.deleteAppointment(id));

    service.deleteAppointment(firstId);
    assertThrows(Exception.class, () -> service.deleteAppointment(firstId));
    assertNotEquals(firstId,
                    service.getAppointmentList().get(0).getAppointmentID());
    
    System.out.println("AppointmentServiceTest.java - delete appointment complete.");
    
  }
}