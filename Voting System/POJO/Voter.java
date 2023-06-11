package POJO;

import java.sql.Date;

public class Voter {
	
	//id | first_name | last_name | email | password | dob | status | role
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private Date dob;
	private boolean status;
	private String role;
	
	public Voter(int id, String fname, String lname, String email, String password, Date dob, boolean status,
			String role) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = status;
		this.role = role;
	}
	
	
	public Voter(String fname, String lname, String email, String password, Date dob, String role) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.status = false;
		this.role = role;
	}



	public Voter() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return " | Voter ID : " + id + " | FName : " + fname + " | LName : " + lname + " | Email :" + email + " | Password="
				+ password + " | DOB : " + dob + " | Status : " + status + " | Role : " + role;
	}

}
