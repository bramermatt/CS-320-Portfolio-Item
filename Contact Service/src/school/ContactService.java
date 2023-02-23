package school;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	private List<Contact> contactList = new ArrayList<>();
	
	  {
		    UUID.randomUUID().toString().substring(
		        0, Math.min(toString().length(), 10));
		  }


		  public void newContact(String firstname, String lastname, String phone,
		                         String address) {
		    Contact contact =
		        new Contact(newUniqueId(), firstname, lastname, phone, address);
		    contactList.add(contact);
		  }

		  public void deleteContact(String id) throws Exception {
		    contactList.remove(searchForContact(id));
		  }

		  public void updateFirstName(String id, String firstName) throws Exception {
		    searchForContact(id).setFirstName(firstName);
		  }

		  public void updateLastName(String id, String lastName) throws Exception {
		    searchForContact(id).setLastName(lastName);
		  }

		  public void updatePhoneNumber(String id, String phone)
		      throws Exception {
		    searchForContact(id).setPhone(phone);
		  }

		  public void updateAddress(String id, String address) throws Exception {
		    searchForContact(id).setAddress(address);
		  }

		  public List<Contact> getContactList() { return contactList; }

		  private String newUniqueId() {
		    return UUID.randomUUID().toString().substring(
		               0, Math.min(toString().length(), 10));
		  }

		  private Contact searchForContact(String id) throws Exception {
		    int index = 0;
		    while (index < contactList.size()) {
		      if (id.equals(contactList.get(index).getContactID())) {
		        return contactList.get(index);
		      }
		      index++;
		    }
		    throw new Exception("The Task does not exist!");
		  }
		}