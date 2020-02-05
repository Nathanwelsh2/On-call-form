<%@page import = "java.util.*" %>
<%@page import = "com.sample.model.*" %>
<%@page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(document).ready (function(){

                $('tr .checkbox').click(function () {                  checkedState = $(this).attr('checked');
                  $(this).parent('tr').children().each(function () {
                      $(this).attr('checked', false);
                      $("div").hide();
                  });
                  $(this).attr('checked', checkedState);
              });


        $("tr .checkbox").click(function () {  

               $(this).siblings().checkedState = false;    
                $("p").toggle();
                

            
            
              });

            });
        </script>
        </head>
<body>
<centre>

<%
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
		
%>
</body>
</html>