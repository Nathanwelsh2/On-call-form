<%@page import = "java.util.*" %>
<%@page import = "com.sample.model.*" %>
<%@page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<body>
<center>

<%
Integer empNo = (Integer) request.getAttribute("empNo");
People user = (People) request.getAttribute("user");
response.addCookie((Cookie) request.getAttribute("loggedin"));

out.println("<br> Hi "+user.getName());

ArrayList <People> employees = (ArrayList) request.getAttribute("employees");
if (employees.size()>0){
out.println("<br> your employees are:");
out.print("<br><form method='post' action='self'><table border = '1'><thead><tbody><tr><td>Employee name</td><td>Staff ID</td><td>Select Employee</td></tr>");
       for (Integer i = 0; i < empNo; i++) {
			out.println("<tr><td>" + employees.get(i).getName()+"</td><td>"+employees.get(i).getStaffID()+"</td><td><INPUT TYPE='radio' name='sa' value='"+employees.get(i).getStaffID()+"'/></td></tr><br>");
		}
	out.print("<br><button type='submit'>Get the selected timesheets</button></form>");

		}

else{

out.print("<form method='post' action='self'><br><button name='sa' type='submit' value='"+user.getStaffID()+"'>Get my timesheets</button></form>");
}


out.print("<br><form method='post' action='newsheet'><br><button type='submit' name='ns' value='"+user.getStaffID()+"'>Create a new timesheet</button></form>");

%>
</body>
</html>