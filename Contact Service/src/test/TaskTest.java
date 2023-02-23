package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import school.Task;

class TaskTest {

	private String ID, name, description;
	private String tooLongID, tooLongName, tooLongDescription;
	
	  @BeforeEach
	  void setUp() {
	    ID = "1234567890";
	    name = "This is Twenty Chars";
	    description = "The task object shall have a required description.";
	    tooLongID = "111222333444555666777888999";
	    tooLongName = "This is way too long to be a task name";
	    tooLongDescription =
	        "The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.";
	  }
	  
	  @Test
	  void getTaskIDTest() {
		  Task task = new Task(ID);
		  Assertions.assertEquals(ID, task.getTaskID());
	  }
	  
	  @Test
	  void getNameTest() {
		  Task task = new Task(ID, name);
		  Assertions.assertEquals(name, task.getName());
	  }
	  
	  @Test
	  void getDescriptionTest() {
		  Task task = new Task(ID, name, description);
		  Assertions.assertEquals(description, task.getDescription());
	  }
	
	  @Test
	  void setNameTest() {
		  Task task = new Task();
		  task.setName(name);
		  Assertions.assertEquals(name, task.getName());
	  }
	  
	  @Test
	  void setDescriptionTest() {
		  Task task = new Task();
		  task.setDescription(description);
		  Assertions.assertEquals(description, task.getDescription());
	  }
	  
	  @Test
	  void TaskIDTooLongTest() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(tooLongID));
	  }
	  
	  @Test
	  void setTooLongNameTest() {
		  Task task = new Task();
		  Assertions.assertThrows(IllegalArgumentException.class,() -> task.setName(tooLongName));
	  }
	  
	  @Test
	  void setTooLongDescriptionTest() {
		  Task task = new Task();
		  Assertions.assertThrows(IllegalArgumentException.class,() -> task.setDescription(tooLongDescription));
	  }
	  
	  @Test
	  void TaskIDNullTest() {
		  Assertions.assertThrows(IllegalArgumentException.class, () -> new Task(null));
	  }
	  
	  @Test
	  void TaskNameNullTest() {
		  Task task = new Task();
		  Assertions.assertThrows(IllegalArgumentException.class, () -> task.setName(null));
	  }
	  
	  @Test
	  void TestDescriptionNullTest() {
		  Task task = new Task();
		  Assertions.assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
	  }
	
}