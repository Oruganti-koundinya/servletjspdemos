package com.samples.classes.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/uclasses")
public class UpdateClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			System.out.println("UpdateClassesServlet init");
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

		response.setContentType("text/html");
		String id = request.getParameter("id");
		String teachercode = request.getParameter("teacher_code");
		String lastname = request.getParameter("last_name");
		String firstname = request.getParameter("first_name");
		String subjectcode = request.getParameter("subject_code");


		try (PreparedStatement statement = connection.prepareStatement("update classes set subject_code = ?,first_name = ?,last_name = ?,teacher_code = ? where id = ?")) {

			statement.setString(5, id);
			statement.setString(4, teachercode);
			statement.setString(3, lastname);
			statement.setString(2, firstname);
			statement.setString(1, subjectcode);
			
			int rowsUpdated = statement.executeUpdate();
			System.out.println("Number of rows Update: " + rowsUpdated);

			PrintWriter pw = response.getWriter();
			pw.write("Class updated successfully");
			pw.write("<p><a href=\"classes.html\">Back</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void destroy() {
		try {
			System.out.println("UpdateClassesServlet.destroy() method. DB connection closed");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
