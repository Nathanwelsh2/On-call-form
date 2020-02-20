package com.sample.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.FolderNotFoundException;
import javax.swing.text.StyledEditorKit.ForegroundAction;


public class DBAccess {

	static String url = "jdbc:postgresql://localhost:5432/postgres";
	static String user = "postgres";
	static String password = "mypassword";

	public static People GetLogin(String UID) {

		People dbuser = null;
		Connection con;
		Statement st = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();} catch (SQLException e) {
				e.printStackTrace();
			}
		try (
				ResultSet att = st.executeQuery("select Attempts from LogOnAttempts where staff_id = "+UID)){
			if (att.next()) {
				if (Integer.parseInt(att.getString(1)) >= 3) {
					return null;
				}
			}} catch (SQLException e) {
				e.printStackTrace();
			}
		try(
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
				ResultSet rs = st.executeQuery("SELECT * FROM employees where manager = "+UID+"order by staff_id")) {
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
				ResultSet rs = st.executeQuery("select t.*, e.name from timesheets t left join employees e on t.staff_id = e.staff_id where t.staff_id = "+ID)) {
			while (rs.next()) {
				sheets.add(new Timesheets(rs.getString(1), rs.getString(2), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(3), rs.getString(4), rs.getString(9)));
			}
			return sheets;
		} 

		catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;
		}
	}

	public static char IncrementFailedLogins(String UID) {
		char fails = 'n';
		try (
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("SELECT Attempts FROM LogOnAttempts where staff_id = "+UID)) {
			if (rs.next()) {
				int loa = rs.getInt(1);
				loa++;
				if (loa >= 3) {fails = 'y';}
				try(
						Connection con1 = DriverManager.getConnection(url, user, password);
						Statement is = con.createStatement()){
					is.executeUpdate("update LogOnAttempts set Attempts = '"+loa+"' where staff_id ="+UID); }

				catch (SQLException ex) {
					Logger lgr = Logger.getLogger(DBAccess.class.getName());
					lgr.log(Level.SEVERE, ex.getMessage(), ex);
				}	
			}
		} 


		catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		return fails;
	}

	public static void ResetFailedLogins(String UID) {

		try (
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement()){
			st.executeUpdate("update LogOnAttempts set Attempts = '"+0+"' where staff_id ="+UID); {
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
				is.executeUpdate("INSERT INTO Timesheets (Sheet_ID, Staff_ID, Date_From, Date_To, Quarter_Hours, Activity, Reason)"
						+"values ("+loa+", "+UID+", '"+sqlfrom+"', '"+sqlto+"', "+quarts+", '"+activity+"', '"+reason+"');"); {
						}
			}
		} 

		catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
	}

	public static void ResetPassword (String id, String newpassword) {

		try (
				Connection con1 = DriverManager.getConnection(url, user, password);
				Statement st = con1.createStatement()){
			st.executeUpdate("update Employees set Password = '"+newpassword+"' where staff_id ="+id);{

			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}
		ResetFailedLogins(id);
	}

	public static ArrayList getApprovalSheets(String UID) {
		ArrayList <ApprovalSheets> approvalsheets = new ArrayList<>();

		try (
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select e.name, t.* from employees e left join timesheets t on t.staff_id = e.staff_id "
						+"where sheet_id is not null and e.manager = "+UID+" order by t.staff_id, sheet_id;")) {
			while (rs.next()) {
				approvalsheets.add(new ApprovalSheets(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getString(6)
						, rs.getString(7)
						, rs.getString(8)
						, rs.getString(9)
						));
			}
			return approvalsheets;
		} 

		catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;
		}
	}

	public static String getMaxSheets() {

		try (
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select max(sheet_id) from timesheets;")){
			while (rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void ApproveRejectSheets(ArrayList<String> approved, ArrayList<String> rejected) {
		int as = approved.size();
		int rs = rejected.size();
		String a = null, r = null;
		for (int i = 0; i < as; i++) {

			if (i==0) {a = approved.get(i);}	
			else a+= ", "+approved.get(i);
		}
		for (int i = 0; i < rs; i++) {

			if (i==0) {r = rejected.get(i);}	
			else r+= ", "+rejected.get(i);
		}
		try {
			Connection con1 = DriverManager.getConnection(url, user, password);
			Statement st = con1.createStatement();{}	

			st.executeUpdate("INSERT INTO approved_timesheets (Sheet_ID, Staff_ID, Date_From, Date_To, Quarter_Hours, Activity, Reason, itask)" + 
					"		select * from timesheets where sheet_id in ("+a+");");

			st.executeUpdate("INSERT INTO rejected_timesheets (Sheet_ID, Staff_ID, Date_From, Date_To, Quarter_Hours, Activity, Reason, itask)\n" + 
					"		select * from timesheets where sheet_id in ("+r+");");
				
			st.executeUpdate("delete from timesheets where sheet_id in ("+a+")");
			st.executeUpdate("delete from timesheets where sheet_id in ("+r+")");

		}
		catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		}


	}

	public static ArrayList getExcel(String UID, ArrayList<String> approved) {
		ArrayList <ApprovalSheets> approvalsheets = new ArrayList<>();
		int as = approved.size();
		String a = null;
		for (int i = 0; i < as; i++) {

			if (i==0) {a = approved.get(i);}	
			else a+= ", "+approved.get(i);
		}

		try (
				Connection con = DriverManager.getConnection(url, user, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select e.name, t.* from employees e left join timesheets t on t.staff_id = e.staff_id "
						+"where sheet_id in ("+a+") and e.manager = "+UID+" order by t.staff_id, sheet_id;")) {
			while (rs.next()) {
				approvalsheets.add(new ApprovalSheets(rs.getString(1)
						, rs.getString(2)
						, rs.getString(3)
						, rs.getString(4)
						, rs.getString(5)
						, rs.getString(6)
						, rs.getString(7)
						, rs.getString(8)
						, rs.getString(9)
						));
			}
			
			return approvalsheets;
		} 
		

		catch (SQLException ex) {
			Logger lgr = Logger.getLogger(DBAccess.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
			return null;
		}
	}




}