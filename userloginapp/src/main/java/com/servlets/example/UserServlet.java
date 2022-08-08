package com.servlets.example;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UserServlet extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Inside UserServlet service method");
		Scanner sc  = new Scanner(System.in);
		String Username = req.getParameter("string1");
		Username = sc.next();
		String Password = req.getParameter("string2");
		Password = sc.next();
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		if(Username == "servlet123" && Password == "admin")
		{
			String result = "Your Login Details are verified";
			out.println("<h3>Result = " + result + "</h3>");
		}
		else
		{
			String result = "Your Login Details are incorrect Please try again after some time.";
			out.println("<h3>Result = " + result + "</h3>");
		}
	}

}
