package com.sample.model;

import java.time.LocalDate;

public class ApprovalSheets {
	String Sheet_ID, Staff_ID, hours, Activity, Reason, from, to, name, itask;

	public ApprovalSheets(String name, String staff_id, String sheet_id, String from, String to
			, String hours, String activity, String reason, String itask) {

		super();
		this.name = name;
		this.Sheet_ID = sheet_id;
		this.Staff_ID = staff_id;
		this.hours = hours;
		this.Activity = activity;
		this.Reason = reason;
		this.from = from;
		this.to = to;
		this.itask = itask;
	}

	public String getSheet_ID() {
		return Sheet_ID;
	}

	public String getStaff_ID() {
		return Staff_ID;
	}

	public String getHours() {
		return hours;
	}

	public String getActivity() {
		return Activity;
	}

	public String getReason() {
		return Reason;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public String getName() {
		return name;
	}

	public String getItask() {
		return itask;
	}




}