package com.sample;

import com.sample.model.GameService;
import com.sample.model.GameType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name="newsheteetservlet",
        urlPatterns = "/newsheet"
)

public class NewSheetServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	
            String n = req.getParameter("ns");
            req.setAttribute("id", n);
            RequestDispatcher view = req.getRequestDispatcher("NewTimeSheet.jsp");
            view.forward(req, resp);

        }

    }

