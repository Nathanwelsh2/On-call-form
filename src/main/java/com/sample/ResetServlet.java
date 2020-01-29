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
import com.sample.model.People;
import com.sample.model.Timesheets;

@WebServlet(
		name="passwordresetservlet",
		urlPatterns = "/ResetPassword"
		)

public class ResetServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get details
		String uid = req.getParameter("UID");
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		
		//set password and reset attempts
		DBAccess.ResetPassword(id, password);
		
		//set details
		req.setAttribute("loggedin", "y");
		req.setAttribute("createnewsheet", "n");
		req.setAttribute("staffno", uid);
		
		RequestDispatcher dispatcher =
			       getServletContext().getRequestDispatcher("/homepage");
			    dispatcher.forward(req, resp);



	}
}
