package com.sample;

import com.sample.model.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;



@WebServlet(
		name="oncallservlet",
		urlPatterns = "/homepage"
		)
public class OnCallServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		ExcelExporter.export();

		char loggedin = 'n';
		
		if (req.getParameter("loggedin") != null) {
			loggedin = req.getParameter("loggedin").charAt(0);
		}
		
		if (req.getAttribute("loggedin") != null) {
			loggedin = req.getAttribute("loggedin").toString().charAt(0);
		}

		if (loggedin  == 'y' && req.getParameter("createnewsheet") != null) {
			char createnewsheet =
					req.getParameter("createnewsheet").toString().charAt(0);
			if (createnewsheet == 'y') {
				String staff_id = req.getParameter("staffno");
				String from = req.getParameter("from");
				String to = req.getParameter("to");
				String quarts = req.getParameter("quarter_hours");
				String activity = req.getParameter("activity");
				String reason = req.getParameter("reason");
				DBAccess.CreateNewSheet(staff_id, from, to, quarts, activity, reason);
			}
		}

		//Get UID and password from homepage
		String password = req.getParameter("password");
		String staffno = req.getParameter("staffno"); 
		if (req.getAttribute("staffno") != null) {
			staffno = (String) req.getAttribute("staffno");
		}

		//create user using password
		People user = DBAccess.GetLogin(staffno);
		if (user != null) {
			try {
				if (loggedin == 'y' || user.getPassword().equals(password)) {
					// Create cookies for log in.      
					Cookie loggedIn = new Cookie("loggedin", "y");
					

					// Set expiry date after 1 Hr for cookie.
					loggedIn.setMaxAge(60*60); 

					//send to homepage
					req.setAttribute("loggedin", loggedIn);
					req.setAttribute("staffno", staffno);
					req.setAttribute("password", password);
					ArrayList<People> employees = new ArrayList<>(DBAccess.getStaff(staffno));
					int empNo = employees.size();
					req.setAttribute("employees", employees);
					req.setAttribute("empNo", empNo);
					req.setAttribute("user", user);
					DBAccess.ResetFailedLogins(staffno);
					RequestDispatcher view = req.getRequestDispatcher("homepage.jsp");
					view.forward(req, resp);
				}


				else {
					char fails = DBAccess.IncrementFailedLogins(staffno);
					if (fails == 'n') {
						String loa = "Your user name or password is incorrect, please try again";
						req.setAttribute("loa", loa);
						RequestDispatcher view = req.getRequestDispatcher("index.jsp");
						view.forward(req, resp);
					}
					else {
						String loa = "Your account has been locked out due to too many failed password attempts, please contact your line manager";
						req.setAttribute("loa", loa);
						RequestDispatcher view = req.getRequestDispatcher("index.jsp");
						view.forward(req, resp);
					}	
				}
			}				


			catch (NullPointerException e) {
				String loa = "Please enter your user name and password and try again";
				req.setAttribute("loa", loa);
				RequestDispatcher view = req.getRequestDispatcher("index.jsp");
				view.forward(req, resp);
			}
		}
		else {
			char fails = DBAccess.IncrementFailedLogins(staffno);	
			String loa = "Your account has been locked out due to too many failed password attempts, please contact your line manager.";
			req.setAttribute("loa", loa);
			RequestDispatcher view = req.getRequestDispatcher("index.jsp");
			view.forward(req, resp);
		}
	}
}
