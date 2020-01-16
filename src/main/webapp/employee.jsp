<%@page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<%

String n = (String) request.getAttribute("nm");
out.println("<br> Hi employee page"+n);


%>
</body>
</html>