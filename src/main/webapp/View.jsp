<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="com.register.dao.DbConnection, java.sql.*" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Connection con=DbConnection.getConnect();
	Statement stmt=con.createStatement();
	ResultSet rs=stmt.executeQuery("Select * from login;");
%>
<table border="1" style="width:40%;">
<tr>
<th>Name</th>
<th>City</th>
</tr>
<% while(rs.next()){%>
<tr>
<td> <%= rs.getString(1) %></td>
<td> <%= rs.getString(3) %></td>
<td><a href="Edit.jsp?name=<%= rs.getString(1) %>">Edit</a></td>
<td><a href="<%=request.getContextPath()%>/Delete?name=<%=rs.getString(1) %>">Delete</a></td>
</tr>
<%} %>
</table>
<a href="index1.html"><h4>Add New User</h4></a>
<a href="LogOutServlet">Logout</a>

 </body>
</html>