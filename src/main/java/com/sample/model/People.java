package com.sample.model;

public class People {
	String staffID;
	String password	;
	String name;
	String email;
	String wage;
	String manager;
	
	public People(String staff_ID, String password, String name, String email, String wage, String manager) {
		super();
		this.staffID = staff_ID;
		this.password = password;
		this.name = name;
		this.email = email;
		this.wage = wage;
		this.manager = manager;
	}

	public String getStaffID() {
		return staffID;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getWage() {
		return wage;
	}

	public String getManager() {
		return manager;
	}


	

	
	

}
