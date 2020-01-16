<%@page import = "java.util.*" %>
<%@page import = "com.sample.model.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<%
Integer sheetno = (Integer) request.getAttribute("sheetno");
String id = (String) request.getAttribute("id");

ArrayList <Timesheets> sheets = (ArrayList) request.getAttribute("sheets");
if (sheets.size()>0){
out.println(id+"s timesheets are are:");
out.println("<table border = '1'><thead><tbody><tr>"
+"<td>Sheet number</td>"
+"<td>staff ID</td>"
+"<td>Date from</td>"
+"<td>Date_to</td>"
+"<td>Quarter hours</td>"
+"<td>Activity</td>"
+"<td>Reason</td>"
+"</tr>");
       for (Integer i = 0; i < sheetno; i++) {
			out.println("<tr><td>" + sheets.get(i).getSheet_ID()+"</td>"
			+"<td>" + sheets.get(i).getStaff_ID()+"</td>"
			+"<td>" + sheets.get(i).getDate_from()+"</td>"
			+"<td>" + sheets.get(i).getDate_To()+"</td>"
			+"<td>" + sheets.get(i).getQuarter_Hours()+"</td>"
			+"<td>" + sheets.get(i).getActivity()+"</td>"
			+"<td>" + sheets.get(i).getReason()+"</td></tr>");
		}
		out.println("</table>");
		}
%>
</body>
</html>