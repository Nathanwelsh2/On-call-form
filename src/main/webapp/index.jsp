<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>webapp attempt</title>
</head>
<body>
<form method="post" action="homepage">
<%
String loa = (String) request.getAttribute("loa");

if (loa !=null){out.print(loa);}
else{out.print("Hi welcome to the timesheet tool");}
%>
    <br>
    <input type="text" name="staffno" value="Staff number">
    <input type="hidden" name="login" value="y">
    <br>
        <input type="password" name="password" value="Password">

    </br>
    <input type="submit">

</form>

</body>
</html>