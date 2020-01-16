package com.sample.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBAccess {

	static String url = "jdbc:postgresql://localhost:5432/postgres";
	static String user = "postgres";
	static String password = "mypassword";

	public static People GetLogin(String UID) {

		People dbuser = null;
		try (

				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM employees where staff_id = "+UID)) {
			if (rs.next()) {
				dbuser = new People(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				return dbuser;
			}
		} 


		catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;
		}
		return dbuser;
	}

	public static ArrayList getStaff(String UID) {
		ArrayList <People> people = new ArrayList<>();

		try (

				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM employees where manager = "+UID)) {
			while (rs.next()) {
				people.add(new People(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
			}
			return people;
		} 


		catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;
		}
	}

	public static ArrayList getTimesheets(String ID) {
		ArrayList <Timesheets> sheets = new ArrayList<>();

		try (

				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM timesheets where staff_id = "+ID)) {
			while (rs.next()) {
				sheets.add(new Timesheets(rs.getString(1), rs.getString(2), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(3), rs.getString(4)));
			}
			return sheets;
		} 


		catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;
		}
	}

	public static void IncrementFailedLogins(String UID) {

		try (
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT Attempts FROM LogOnAttempts where staff_id = "+UID)) {
			if (rs.next()) {
				int loa = rs.getInt(1);
				loa++;
				Connection con1 = DriverManager.getConnection(url, user, password);
				Statement is = con.createStatement();
				is.executeQuery("update LogOnAttempts set Attempts = '"+loa+"' where staff_id ="+UID); {

				}
			}
		} 


		catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

	public static void ResetFailedLogins(String UID) {

		try (
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement()){
				st.executeQuery("update LogOnAttempts set Attempts = '"+0+"' where staff_id ="+UID); {
		} 
		}
		catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}
	

	
	public static void CreateNewSheet(String UID, String from, String to, String quarts, String activity, String reason) {
		
		try (
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT max(Sheet_ID) FROM Timesheets")) {
			if (rs.next()) {
				int loa = rs.getInt(1);
				loa++;
				String q = "q";
				Connection con1 = DriverManager.getConnection(url, user, password);
				Statement is = con.createStatement();
				java.sql.Date sqlfrom = Date.valueOf(from);
				java.sql.Date sqlto = Date.valueOf(to);
				is.executeQuery("INSERT INTO Timesheets (Sheet_ID, Staff_ID, Date_From, Date_To, Quarter_Hours, Activity, Reason)"
						+"values ("+loa+", "+UID+", '"+sqlfrom+"', '"+sqlto+"', "+quarts+", '"+activity+"', '"+reason+"');"); {
				}
			}
		} 

		catch (SQLException ex) {

			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

}