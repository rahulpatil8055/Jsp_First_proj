<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
</head>
<body>
    <%@ include file="Links.jsp"%>
    <form action="./LoginServlet" method="get">
    
       Username:<input type="text" name="uname"><br>
        Password:<input type="password" name="pass"><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>