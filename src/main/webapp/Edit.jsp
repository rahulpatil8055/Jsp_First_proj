<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.register.dao.DbConnection, java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
<style>
    @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap");

* {
  margin: 0;
  padding: 0;
  font-family: "Poppins";
  box-sizing: border-box;
}

body {
  display: flex;
  justify-content: center;
  align-items: center;
  background: #1f293a;
  min-height: 100vh;
}



.login-box {
  position: absolute;
  width: 400px;
}

.login-box form {
  width: 100%;
  padding: 0 50px;
}

h2 {
  font-size: 2em;
  color: #0ef;
  text-align: center;
}
.input-box {
  position: relative;
  margin: 25px 0;
color:white;
}

.input-box input {
  width: 100%;
  height: 50px;
  background: transparent;
  border: 2px solid #2c4766;
  outline: none;
  border-radius: 40px;
  font-size: 1em;
  color: #fff;
  padding: 0 20px;
  transition: 0.5s;
}

.input-box input:focus,
.input-box input:valid {
  border-color: #0ef;
}

.input-box label {
  position: absolute;
  top: 50%;
  left: 20px;
  transform: translateY(-50%);
  font-size: 1em;
  color: #fff;
  pointer-events: none;
  transition: 0.5s ease;
}

.input-box input:focus ~ label,
.input-box input:valid ~ label {
  top: 1px;
  font-size: 0.8em;
  background-color: #1f293a;
  padding: 0 6px;
  color: #0ef;
}

.forgot-password {
  margin: -15px 0 10px;
  text-align: center;
}

.forgot-password a {
  font-size: 0.85em;
  color: #fff;
  text-decoration: none;
}

.forgot-password a:hover {
  text-decoration: underline;
}

.btn {
  width: 100%;
  height: 45px;
  border-radius: 45px;
  background: #0ef;
  border: none;
  outline: none;
  cursor: pointer;
  font-size: 1em;
  color: #1f293a;
  font-weight: 600;
}

.signup-link {
  margin: 20px 0 10px;
  text-align: center;
color:#FFD700;
}

.signup-link a {
  font-size: 1em;
  color: #0ef;
  text-decoration: none;
  font-weight: 600;
}

.signup-link a:hover {
  text-decoration: underline;
}
  </style>
</head>
<body>
<%
String name=request.getParameter("name");
Connection con=DbConnection.getConnect();
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("Select * from login where name='"+name+"'");
rs.next();

%>
<div class="login-box">
    <h2>Registration Form</h2>
    <form action="./Update" method="post">
    
      <div class="input-box">
        Enter Name: <input type="text" name="name" value=<%=rs.getString(1) %> />
      </div>
      <div class="input-box">
        Enter Password: <input type="password" name="pass" value=<%=rs.getString(2) %> />
      </div>
      <div class="input-box">
        Enter City: <input type="text" name="city" value=<%=rs.getString(3) %> />
      </div>
      <input type="submit" value="Update" class="btn" />
    </form>
    
 </div>
</body>
</html>