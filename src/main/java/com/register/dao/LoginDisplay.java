package com.register.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginDisplay")
public class LoginDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String name = request.getParameter("uname");
		    String password = request.getParameter("pass");

		    // JDBC variables
		    Connection conn = null;
		    PreparedStatement ps = null;
		    ResultSet rs = null;

		    try {
		        // Load the JDBC driver
		        Class.forName("com.mysql.cj.jdbc.Driver");

		        // Establish the database connection
		        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "Rahul@9018");

		        // SQL query to retrieve user data from the database
		        String sql = "SELECT * FROM login WHERE name = ? and password= ?";
		        ps = conn.prepareStatement(sql);
		        ps.setString(1, name);
		        ps.setString(2, password);

		        // Execute the query
		        rs = ps.executeQuery();
		        
		        response.setContentType("text/html");
		        PrintWriter out = response.getWriter();
		        out.println("<html><body>");
		        out.println("<h2>Register Information</h2>");

		        if (rs.next()) {
		            out.println("<p>Name: " + rs.getString("name") + "</p>");
		            out.println("<p>Password: " + rs.getString("password") + "</p>");
		            out.println("<p>City: " + rs.getString("city") + "</p>");
		            
		        } else {
		            out.println("<p>User not found</p>");
		            
	
		        }

		        out.println("</body></html>");
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    } finally {
		        // Close resources in the finally block
		        try {
		            if (rs != null) {
		                rs.close();
		            }
		            if (ps != null) {
		                ps.close();
		            }
		            if (conn != null) {
		                conn.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
		
	}