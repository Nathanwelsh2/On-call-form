<%@page import = "java.util.*" %>
<%@page import = "com.sample.model.*" %>
<%@page import="javax.servlet.http.Cookie"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>webapp attempt</title>
</head>
<body>
<%
Cookie[] cookies = request.getCookies();
Cookie cookie = null;     
for (int i = 0; i < cookies.length; i++) {
		String cc = cookies[i].getName();
		String comp = "loggedin";
	if(cc.equals(comp)){
	cookie = cookies[i];
	}}
String id = (String) request.getAttribute("id");
String UID = (String) request.getAttribute("UID");
out.print("Please set a password for "+id
+"<form method='post' action='ResetPassword'>"
+"<input type='text' name='password'>"
+"<input type='hidden' name='id' value='"+id+"'>"
+"<input type='hidden' name='UID' value='"+UID+"'>"
+"<input type='hidden' name='loggedin' value='"+cookie.getValue()+"'>"
+"<input type='submit'>"
+"</form>");
%>


</body>
</html>