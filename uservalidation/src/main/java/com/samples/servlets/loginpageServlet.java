package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginpageServlet")
public class loginpageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String Username = request.getParameter("username");
		String Password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		if(Username.equals("servlet_01") && Password.equals("admin"))
		{
			out.println("<h3>Your Details are Validated</h3>");
			out.write("<p><a  href=\"userlogin.html\">Logout</p></a>");
			 //response.sendRedirect("<h3>Your Details are Validated</h3>");
	            //return;
		}
		else
		{
			out.println("<h3>Your Details are Invalid!.html</h3>");
			out.write("<p><a  href=\"userlogin.html\">Try Again</p></a>");
//			response.sendRedirect("<h3>Your Details are Invalid!.html</h3>");
//			return;
		}
	}

}
