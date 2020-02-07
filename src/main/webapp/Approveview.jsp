<%@page import = "java.util.*" %>
<%@page import = "com.sample.model.*" %>
<%@page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
<body>
<centre>

<%
Integer empNo = (Integer) request.getAttribute("empNo");
ArrayList <People> employees = (ArrayList) request.getAttribute("employees");
Integer sheetno = (Integer) request.getAttribute("sheetno");
String uid = (String) request.getAttribute("uid");
ArrayList <ApprovalSheets> sheets = (ArrayList) request.getAttribute("sheets");
String maxsheets = (String) request.getAttribute("maxsheets");

if (employees.size()>0){
out.println("your sheets for approval are: ");
        
        out.println("<form method='post' action='approvereject'>"
                +"<input type='hidden' name='uid' value='"+uid+"'>"
                +"<table border = '1'><thead><tbody><tr>"
                +"<td>Name</td>"
                +"<td>Sheet number</td>"
                +"<td>staff ID</td>"
                +"<td>Date from</td>"
                +"<td>Date to</td>"
                +"<td>Hours</td>"
                +"<td>Activity</td>"
                +"<td>Reason</td>"
                +"<td>Itask</td>"
                +"<td>Approve</td>"
                +"<td>Reject</td>"
                +"<td>No action</td>"
                +"</tr>");
                for (Integer i = 0; i < sheetno; i++) {
                    out.print("<tr><td>" + sheets.get(i).getName()+"</td>"
                    +"<td>" + sheets.get(i).getStaff_ID()+"</td>"
                    +"<td>" + sheets.get(i).getSheet_ID()+"</td>"
                    +"<td>" + sheets.get(i).getFrom()+"</td>"
                    +"<td>" + sheets.get(i).getTo()+"</td>"
                    +"<td>" + sheets.get(i).getHours()+"</td>"
                    +"<td>" + sheets.get(i).getActivity()+"</td>"
                    +"<td>" + sheets.get(i).getReason()+"</td>"
                    +"<td>" + sheets.get(i).getItask()+"</td>"
                    +"<td><input type='radio' name='"+sheets.get(i).getStaff_ID()+"' value='0'/></td>"
                    +"<td><input type='radio' name='"+sheets.get(i).getStaff_ID()+"' value='1'/></td>"
                    +"<td><input type='radio' name='"+sheets.get(i).getStaff_ID()+"' value='3' checked='true'/></td>"
                    +"</tr>");
                }
                        out.print("</table><button type='submit' name='maxsheets' value='"+maxsheets+"'>Submit</button>"
                        +"</form>");

                    }
		
%>
</body>
</html>