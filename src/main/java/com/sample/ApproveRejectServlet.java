package com.sample;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sample.model.DBAccess;

@WebServlet(
		name="approverejectservlet",
		urlPatterns = "/approvereject"
		)

public class ApproveRejectServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get details
		int maxsheets = Integer.parseInt(req.getParameter("maxsheets"));
		String uid = req.getParameter("uid");
		
		//create arrays for affected timesheets
		ArrayList <String> accepted = new ArrayList();
		ArrayList <String> rejected = new ArrayList();
		
		//populate arrays
		for (int i = 0; i <= maxsheets; i++) {
			try {
				switch (req.getParameter(Integer.toString(i))) {

				case "0":
					accepted.add(Integer.toString(i));
					break;

				case "1":
					rejected.add(Integer.toString(i));
					break;

				default:break;
				}
			}
			catch (NullPointerException e) {}
		}
		
		//send arrays to DBAccess class to move data
			//both arrays go to method like
				DBAccess.ApproveRejectSheets(accepted, rejected);
		
			//send user to homepage	
		req.setAttribute("loggedin", "y");
		req.setAttribute("createnewsheet", "n");
		req.setAttribute("staffno", uid);
		RequestDispatcher dispatcher =
			       getServletContext().getRequestDispatcher("/homepage");
			    dispatcher.forward(req, resp);
	}
}
