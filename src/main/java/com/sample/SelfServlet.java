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
        name="selfservlet",
        urlPatterns = "/self"
)

public class SelfServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String n = req.getParameter("sa");
        if (true) {
        ArrayList<Timesheets> sheets = new ArrayList<>(DBAccess.getTimesheets(n));
        int sheetno = sheets.size();
        req.setAttribute("sheetno", sheetno);
        req.setAttribute("sheets", sheets);
        req.setAttribute("id", n);
        RequestDispatcher view = req.getRequestDispatcher("self.jsp");
        view.forward(req, resp);
        }
        else {
        	
        }

    }
	
	
	
	
	
	
}
