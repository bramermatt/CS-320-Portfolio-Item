package test;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

import school.Contact;

public class ContactTest {

 @Test
	public void testContact() {
		Contact contactID = new Contact("123445", "Matthew", "Bramer", "5025551527", "2026 Bluebird");
		assertTrue(contactID.getContactID().equals("123445"));
		
	}
	
 @Test
	public void testContactTooLong() {
		Assert.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12344555555", "MatthewThomas", "BramerBramer", "502555152712345", "2026 Bluebird Bluebird Bluebird");
		});
	}

}
