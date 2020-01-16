package com.sample.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Book {
	private int code;
	private static int numberOfBooks = 0;
	private String name;
	private boolean lendable;
	private boolean in;
	private String checkOutDate;
	

	public Book (String name) {
		this.name = name;
		in = true;
		this.code = numberOfBooks+1;
		numberOfBooks+=1;

	}

	public String getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isIn() {
		return in;
	}

	public void setIn(boolean in) {
		this.in = in;
	}
	
	public boolean isLendable() {
		return this.lendable;
	}
	
	public void setLendable(boolean lendable, Person person) {
		if(person.librarian){this.lendable = lendable;}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
