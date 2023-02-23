package school;

public class Task {
	
	private String taskID;
	private String name;
	private String description;
	
	public Task() {
		taskID = "INITIAL";
		name = "INITIAL";
		description = "INITIAL DESCRIPTION";
	}
	
	public Task(String taskID) {
		checkTaskID(taskID);
		name = "INITIAL";
		description = "INITIAL DESCRIPTION";
	}
	
	public Task(String taskID, String name) {
		checkTaskID(taskID);
		setName(name);
		description = "INITIAL DESCRIPTION";
	}
	
	public Task(String taskID, String name, String description) {
		checkTaskID(taskID);
		setName(name);
		setDescription(description);
	}	
	
	public final String getTaskID() { 
		return taskID;
	}
	
	public final String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException(
			"Task name is invalid. Ensure it is shorter than 20 characters and not empty.");
		} else {
			this.name = name;
		}
	}
	
	public final String getDescription() {
		return description;
	}
	
	public void setDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException (
					"Task description is invalid. Ensure it is shorter than 50 characters and not empty.");	
		} else {
			this.description = taskDescription;
		}
	}
	
	private void checkTaskID(String taskID) {
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException(
					"Error: The task ID was null or longer than 10 characters.");
		} else {
			this.taskID = taskID;
		}
	}
}