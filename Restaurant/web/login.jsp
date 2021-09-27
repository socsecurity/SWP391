<%-- 
    Document   : login
    Created on : Sep 27, 2021, 3:14:40 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>System management system | Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="HomeControl" method="POST">
            <label>User</label><br>
            <input type="username" name="username"/><br>
            <br>
            <label>Password</label><br>
            <input type="password" name="password"/><br>
            <p style="color:red">${mess}</p>
            <input type="submit" value="Login" name="btAction"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
