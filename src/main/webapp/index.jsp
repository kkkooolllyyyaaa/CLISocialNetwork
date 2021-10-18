<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>JSP Actions Example</title>
</head>
<body>

<h1> Student Registration Page</h1>
<form action="authorization-servlet" method="post">
    First Name: <input type="text" name="username">
    <br> <br>

    Password: <input type="password" name="password"><br>

    <br>
    <input type="submit" value="register">
</form>
</body>
</html>
