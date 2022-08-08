package com.servlets.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validationServlet")
public class ValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		doGet(request, response);
		response.setContentType("text/html");
		String Username = request.getParameter("Username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		if(Username == "Happy_123")
		{
			String result = "Your Details are validated!";
			out.println("<h3>Result = " + result + "</h3>");
		}
	}

}
