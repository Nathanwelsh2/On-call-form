package com.sample.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Timecalc {
	
	
	static Calendar calendar = Calendar.getInstance();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    
    public static String getTime() {
    	return dateFormat.format(calendar.getTime());
    }

}
