/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.37
 * Generated at: 2020-01-31 16:13:26 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.sample.model.*;
import javax.servlet.http.Cookie;

public final class Approveview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            $(document).ready (function(){\n");
      out.write("\n");
      out.write("                $('tr .checkbox').click(function () {                  checkedState = $(this).attr('checked');\n");
      out.write("                  $(this).parent('tr').children().each(function () {\n");
      out.write("                      $(this).attr('checked', false);\n");
      out.write("                      $(\"div\").hide();\n");
      out.write("                  });\n");
      out.write("                  $(this).attr('checked', checkedState);\n");
      out.write("              });\n");
      out.write("\n");
      out.write("\n");
      out.write("        $(\"tr .checkbox\").click(function () {  \n");
      out.write("\n");
      out.write("               $(this).siblings().checkedState = false;    \n");
      out.write("                $(\"p\").toggle();\n");
      out.write("                \n");
      out.write("\n");
      out.write("            \n");
      out.write("            \n");
      out.write("              });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("        </head>\n");
      out.write("<body>\n");
      out.write("<centre>\n");
      out.write("\n");

Integer empNo = (Integer) request.getAttribute("empNo");
ArrayList <People> employees = (ArrayList) request.getAttribute("employees");
Integer sheetno = (Integer) request.getAttribute("sheetno");
String id = (String) request.getAttribute("id");
ArrayList <ApprovalSheets> sheets = (ArrayList) request.getAttribute("sheets");

if (employees.size()>0){
out.println("your sheets for approval are: ");
out.print("<form method='post' action='self'>");
        
        out.println("<form method='post' action='self'>"
                +"<table border = '1'><thead><tbody><tr>"
                +"<td>Name</td>"
                +"<td>Sheet number</td>"
                +"<td>staff ID</td>"
                +"<td>Date from</td>"
                +"<td>Date_to</td>"
                +"<td>Hours</td>"
                +"<td>Activity</td>"
                +"<td>Reason</td>"
                +"<td>Itask</td>"
                +"<td>Approve</td>"
                +"<td>Delete</td>"
                +"</tr>");
                for (Integer i = 0; i < sheetno; i++) {
                    out.print("<tr><td>" + sheets.get(i).getName()+"</td>"
                    +"<td>" + sheets.get(i).getSheet_ID()+"</td>"
                    +"<td>" + sheets.get(i).getStaff_ID()+"</td>"
                    +"<td>" + sheets.get(i).getFrom()+"</td>"
                    +"<td>" + sheets.get(i).getTo()+"</td>"
                    +"<td>" + sheets.get(i).getHours()+"</td>"
                    +"<td>" + sheets.get(i).getActivity()+"</td>"
                    +"<td>" + sheets.get(i).getReason()+"</td>"
                    +"<td>" + sheets.get(i).getItask()+"</td>"
                    +"<td><input type='checkbox' name='"+i+"' value='"+sheets.get(i).getSheet_ID()+"' class='checkbox'/></td>"
                    +"<td><input type='checkbox' name='"+i+"' value='"+sheets.get(i).getSheet_ID()+"' class='checkbox'/></td>"
                    +"</tr>");
                }
                        out.print("</table></form>");
                        out.print("<p>sdfhjbabhsdhdsafbhdfabhdsabfh;bfhd;asbhfdasbhfd</p>");
                        out.print("<div>3567876557898765789876</div>");
                    }
		

      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}