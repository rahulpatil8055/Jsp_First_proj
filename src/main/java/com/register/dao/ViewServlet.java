package com.register.dao;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	HttpSession session=request.getSession(true);
	String name=(String)session.getAttribute("username");
	if(name!=null) {
		out.print("Welcome:"+name);
		RequestDispatcher rd=request.getRequestDispatcher("View.jsp");
		rd.include(request, response);
	}else {
		out.print("Please Login First to View Details");
		RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
	}
	}
}