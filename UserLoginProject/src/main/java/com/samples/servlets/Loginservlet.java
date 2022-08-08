package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginServlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			ServletContext context = config.getServletContext();
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(context.getInitParameter("dburl"),
					context.getInitParameter("dbuser"), context.getInitParameter("dbpassword"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try (PreparedStatement statement = connection.prepareStatement("select * from user where email = ? and password = ?")) {
			statement.setString(1, username);
			statement.setString(2, password);

			ResultSet results = statement.executeQuery();
			
			if (results.next()) {
				RequestDispatcher rd = request.getRequestDispatcher("homeServlet");
				request.setAttribute("message", "User Authenticated. Welcome to InterServlet Communication");
				rd.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("Login Failed");
				
				RequestDispatcher rd = request.getRequestDispatcher("login.html");
				rd.include(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}