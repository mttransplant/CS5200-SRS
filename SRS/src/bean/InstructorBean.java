package bean;

public class InstructorBean {
private String firstName;
private String lastName;
private String email;
private int department;
private String username;
private String password;


public InstructorBean() {
	firstName = null;
	lastName = null;
	email = null;
	department = 0;
	username = null;
	password = null;
}

public void IntructorBean(String firstName, String lastName, String email, int department, String username, String password) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.department = department;
	this.username = username;
	this.password = password;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getDepartment() {
	return department;
}

public void setDepartment(int department) {
	this.department = department;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

}
