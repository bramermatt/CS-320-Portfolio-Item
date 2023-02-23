package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.ContactService;

public class ContactServiceTest {
	  protected String contactID, firstNameTest, lastNameTest, phoneNumberTest,
	      addressTest;
	  protected String tooLongContactId, tooLongFirstName, tooLongLastName,
	      tooLongPhone, tooShortPhone, tooLongAddress;
	  
	  @BeforeEach
	  void setUp() {
	    contactID = "10293A475F";
	    firstNameTest = "John";
	    lastNameTest = "Smith";
	    phoneNumberTest = "5553331234";
	    addressTest = "1 Audrey Jersey City NJ 07305";
	    tooLongContactId = "112233445566778899";
	    tooLongFirstName = "John Jacob Jingle";
	    tooLongLastName = "-heimer Schmidt";
	    tooLongPhone = "55512341234";
	    tooShortPhone = "1234567";
	    tooLongAddress = "1 Audrey Zapp Drive, Jersey City, NJ 07305";
	  }
	  
	  @Test
	  void newContactTest() {
	    ContactService service = new ContactService();
	    service.newContact(contactID, null, null, null);
	    assertAll(
	        "service",
	        ()
	            -> assertNotNull(service.getContactList().get(0).getContactID()),
	        ()
	            -> assertEquals("INITIAL",
	                            service.getContactList().get(0).getFirstName()),
	        ()
	            -> assertEquals("INITIAL",
	                            service.getContactList().get(0).getLastName()),
	        ()
	            -> assertEquals("1235559999",
	                            service.getContactList().get(0).getPhone()),
	        ()
	            -> assertEquals("INITIAL",
	                            service.getContactList().get(0).getAddress()));
	    service.newContact(firstNameTest, null, null, null);
	    assertAll(
	        "service",
	        ()
	            -> assertNotNull(service.getContactList().get(1).getContactID()),
	        ()
	            -> assertEquals(firstNameTest,
	                            service.getContactList().get(1).getFirstName()),
	        ()
	            -> assertEquals("INITIAL",
	                            service.getContactList().get(1).getLastName()),
	        ()
	            -> assertEquals("1235559999",
	                            service.getContactList().get(1).getPhone()),
	        ()
	            -> assertEquals("INITIAL",
	                            service.getContactList().get(1).getAddress()));
	    service.newContact(firstNameTest, lastNameTest, null, null);
	    assertAll(
	        "service",
	        ()
	            -> assertNotNull(service.getContactList().get(2).getContactID()),
	        ()
	            -> assertEquals(firstNameTest,
	                            service.getContactList().get(2).getFirstName()),
	        ()
	            -> assertEquals(lastNameTest,
	                            service.getContactList().get(2).getLastName()),
	        ()
	            -> assertEquals("1235559999",
	                            service.getContactList().get(2).getPhone()),
	        ()
	            -> assertEquals("INITIAL",
	                            service.getContactList().get(2).getAddress()));
	    service.newContact(firstNameTest, lastNameTest, phoneNumberTest, null);
	    assertAll(
	        "service",
	        ()
	            -> assertNotNull(service.getContactList().get(3).getContactID()),
	        ()
	            -> assertEquals(firstNameTest,
	                            service.getContactList().get(3).getFirstName()),
	        ()
	            -> assertEquals(lastNameTest,
	                            service.getContactList().get(3).getLastName()),
	        ()
	            -> assertEquals(phoneNumberTest,
	                            service.getContactList().get(3).getPhone()),
	        ()
	            -> assertEquals("INITIAL",
	                            service.getContactList().get(3).getAddress()));
	    service.newContact(firstNameTest, lastNameTest, phoneNumberTest,
	                       addressTest);
	    assertAll(
	        "service",
	        ()
	            -> assertNotNull(service.getContactList().get(4).getContactID()),
	        ()
	            -> assertEquals(firstNameTest,
	                            service.getContactList().get(4).getFirstName()),
	        ()
	            -> assertEquals(lastNameTest,
	                            service.getContactList().get(4).getLastName()),
	        ()
	            -> assertEquals(phoneNumberTest,
	                            service.getContactList().get(4).getPhone()),
	        ()
	            -> assertEquals(addressTest,
	                            service.getContactList().get(4).getAddress()));
	  }

	  @Test
	  void deleteContactTest() {
	    ContactService service = new ContactService();
	    service.newContact(contactID, null, null, null);
	    assertThrows(Exception.class, () -> service.deleteContact(contactID));
	    assertAll(()
	                  -> service.deleteContact(
	                      service.getContactList().get(0).getContactID()));
	  }

	  @Test
	  void updateFirstNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact(firstNameTest, null, null, null);
	    service.updateFirstName(service.getContactList().get(0).getContactID(),
	                            firstNameTest);
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateFirstName(
	                         service.getContactList().get(0).getContactID(),
	                         tooLongFirstName));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateFirstName(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.updateFirstName(contactID, firstNameTest));
	  }

	  @Test
	  void updateLastNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact(lastNameTest, null, null, null);
	    service.updateLastName(service.getContactList().get(0).getContactID(),
	                           lastNameTest);
	    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateLastName(
	                         service.getContactList().get(0).getContactID(),
	                         tooLongLastName));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateLastName(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.updateLastName(contactID, lastNameTest));
	  }

	  @Test
	  void updatePhoneNumberTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact(phoneNumberTest, null, null, null);
	    service.updatePhoneNumber(service.getContactList().get(0).getContactID(),
	                              phoneNumberTest);
	    assertEquals(phoneNumberTest,
	                 service.getContactList().get(0).getPhone());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updatePhoneNumber(
	                         service.getContactList().get(0).getContactID(),
	                         tooLongPhone));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updatePhoneNumber(
	                         service.getContactList().get(0).getContactID(),
	                         tooShortPhone));
	    assertThrows(
	        IllegalArgumentException.class,
	        ()
	            -> service.updatePhoneNumber(
	                service.getContactList().get(0).getContactID(), contactID));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updatePhoneNumber(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.updatePhoneNumber(contactID, lastNameTest));
	  }

	  @Test
	  void updateAddressTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact(addressTest, null, null, null);
	    service.updateAddress(service.getContactList().get(0).getContactID(),
	                          addressTest);
	    assertEquals(addressTest, service.getContactList().get(0).getAddress());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateAddress(
	                         service.getContactList().get(0).getContactID(),
	                         tooLongAddress));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateAddress(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.updateAddress(contactID, addressTest));
	  }
	}
