package com.sample;

import com.sample.model.*;
import com.sample.model.GameService;
import com.sample.model.GameType;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@WebServlet(
		name="oncallservlet",
		urlPatterns = "/homepage"
		)
public class OnCallServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	

		char loggedin = 'n';

		try {
			loggedin = req.getParameter("loggedin").charAt(0);
		}
		catch (NullPointerException e) {
		}

		if (loggedin  == 'y') {
			char createnewsheet = req.getParameter("createnewsheet").charAt(0);
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
		
		//Get UID and password
		String password = req.getParameter("password");
		String staffno = req.getParameter("staffno");  

		//create user using password
		People user = DBAccess.GetLogin(staffno);
		try {
			if (loggedin == 'y' ||user.getPassword().equals(password)) {

				// Create cookies for first and last names.      
				Cookie loggedIn = new Cookie("loggedin", "y");

				// Set expiry date after 24 Hrs for both the cookies.
				loggedIn.setMaxAge(60*60*24); 

				//send to homepage
				req.setAttribute("loggedin", loggedIn);
				req.setAttribute("staffno", staffno);
				req.setAttribute("password", password);
				ArrayList<People> employees = new ArrayList<>(DBAccess.getStaff(req.getParameter("staffno")));
				int empNo = employees.size();
				req.setAttribute("employees", employees);
				req.setAttribute("empNo", empNo);
				req.setAttribute("user", user);
				DBAccess.ResetFailedLogins(staffno);
				RequestDispatcher view = req.getRequestDispatcher("homepage.jsp");
				view.forward(req, resp);
			}


			else {
				String loa = "Your user name or password is incorrect, please try again";
				DBAccess.IncrementFailedLogins(staffno);
				req.setAttribute("loa", loa);
				RequestDispatcher view = req.getRequestDispatcher("index.jsp");
				view.forward(req, resp);
			}
		}
		catch (NullPointerException e) {
			String loa = "Please enter your user name and password and try again";
			req.setAttribute("loa", loa);
			RequestDispatcher view = req.getRequestDispatcher("index.jsp");
			view.forward(req, resp);
		}
	}
}
