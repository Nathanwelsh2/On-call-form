package com.sample.model;

import java.time.LocalDate;

public class Timesheets {
    String Sheet_ID, Staff_ID, Quarter_Hours, name;
    String Activity;
    String Reason;
    String Date_from;
    String Date_To;
    
    
	public Timesheets(String sheet_ID, String staff_ID, String quarter_Hours, String activity, String reason, String date_from,
			String date_To, String name) {
		super();
		Sheet_ID = sheet_ID;
		Staff_ID = staff_ID;
		Quarter_Hours = quarter_Hours;
		Activity = activity;
		Reason = reason;
		Date_from = date_from;
		Date_To = date_To;
		this.name = name;
	}
	
	public String getName() {
		return name;
	}


	public String getSheet_ID() {
		return Sheet_ID;
	}


	public String getStaff_ID() {
		return Staff_ID;
	}


	public String getQuarter_Hours() {
		return Quarter_Hours;
	}


	public String getActivity() {
		return Activity;
	}


	public String getReason() {
		return Reason;
	}


	public String getDate_from() {
		return Date_from;
	}


	public String getDate_To() {
		return Date_To;
	}
	
	
}
