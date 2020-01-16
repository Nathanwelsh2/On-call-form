package com.sample;

import javax.servlet.annotation.WebServlet;
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
		name="createsheteetservlet",
		urlPatterns = "/createsheet"
		)

public class CreateSheetServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String staff_id = req.getParameter("staff_id");
		String from = req.getParameter("from");
		String to = req.getParameter("to");
		String quarts = req.getParameter("quarter_hours");
		String activity = req.getParameter("activity");
		String reason = req.getParameter("reason");
		
		






	}
}
