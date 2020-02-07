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
		name="approvevierwservlet",
		urlPatterns = "/approveview"
		)

public class ApproveViewServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get details
		String uid = req.getParameter("uid");
		ArrayList<People> employees = new ArrayList<>(DBAccess.getStaff(uid));
		int empNo = employees.size();
		ArrayList<Timesheets> approvalsheets = new ArrayList<>(DBAccess.getApprovalSheets(uid));
		int sheetno = approvalsheets.size();
		String maxsheets = DBAccess.getMaxSheets();
		
		//set details
		req.setAttribute("employees", employees);
		req.setAttribute("empNo", empNo);
		req.setAttribute("uid", uid);
		req.setAttribute("sheets", approvalsheets);
		req.setAttribute("sheetno", sheetno);
		req.setAttribute("maxsheets", maxsheets);
		
		//send to view
		RequestDispatcher view = req.getRequestDispatcher("Approveview.jsp");
		view.forward(req, resp);



	}
}
