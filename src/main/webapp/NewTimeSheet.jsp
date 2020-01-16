<%@page import = "java.util.*" %>
<%@page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
<body>
<center>
<%
Cookie[] cookies = request.getCookies();
Cookie cookie = null;     
String user = (String) request.getAttribute("id");
out.println("<br> Hi \nPlease enter your timesheet submission");

for (int i = 0; i < cookies.length; i++) {
		String cc = cookies[i].getName();
		String comp = "loggedin";
	if(cc.equals(comp)){
	cookie = cookies[i];
	}
}

out.print("<form method='post' action='homepage'><table border = '1'><thead><tbody><tr>"
+"<td>Staff ID</td>"
+"<td>date from</td>"
+"<td>date to</td>"
+"<td>quarter hours</td>"
+"<td>activity</td>"
+"<td>reason</td>"
+"</tr>");
out.println("<tr>"
+"<td>"+user+"</td>"
+"<td><input type = 'date' name = 'from'></td>"
+"<td><input type = 'date' name = 'to'></td>"
+"<td><input type = 'number' name = 'quarter_hours' min='1'></td>"
+"<td><select name='activity'><option value='O'>On Call</option><option value='C'>Call out</option></select></td>"
+"<td><input type = 'text' name = 'reason'></td></tr>"
+"<input type='hidden' name='loggedin' value='"+cookie.getValue()+"'>"
+"<input type='hidden' name='createnewsheet' value='y'>"
+"<button type='submit' name='staffno' value='"+ user +"'>Submit this timesheet</button>"
+"</form>");


%>
</body>
</html>