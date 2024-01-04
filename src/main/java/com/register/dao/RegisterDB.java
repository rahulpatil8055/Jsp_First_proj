package com.register.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/RegisterDB")
public class RegisterDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    try {
	        String name = request.getParameter("name");
	        String password = request.getParameter("pass");
	        String city = request.getParameter("city");
	        RegisterQuery q = new RegisterQuery();
	        int count = q.insert(name, password, city);
	        
	        if (count > 0) {
	            response.sendRedirect("Success1.html");
	        } else {
	            response.sendRedirect("Error.html");
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace(); // Log the exception or handle it appropriately
	        response.sendRedirect("Error.html");
	    }
	}
	
}
