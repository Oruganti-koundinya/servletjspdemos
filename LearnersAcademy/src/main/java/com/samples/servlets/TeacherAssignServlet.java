package com.samples.servlets;

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

@WebServlet("/teachersassign")
public class TeacherAssignServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			System.out.println("TeacherAssignServlet init");
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
		String teachercode = request.getParameter("teacher_code");
		String subjectname = request.getParameter("subject_name");
		String subjectcode = request.getParameter("subject_code");
		String classcode = request.getParameter("class_code");


		try (PreparedStatement statement = connection.prepareStatement("update teachers set class_code = ?,subject_code = ?,subject_name = ? where teacher_code = ?")) {

			statement.setString(4, teachercode);
			statement.setString(3, subjectname);
			statement.setString(2, subjectcode);
			statement.setString(1, classcode);
			
			int rowsUpdated = statement.executeUpdate();
			System.out.println("Number of rows Update: " + rowsUpdated);

			PrintWriter pw = response.getWriter();
			pw.write("Teacher Assigned To class and subject successfully");
			pw.write("<p><a href=\"teachers.html\">Back</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void destroy() {
		try {
			System.out.println("TeacherAssignServlet.destroy() method. DB connection closed");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
