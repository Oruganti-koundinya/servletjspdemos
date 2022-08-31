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


@WebServlet("/aclasses")
public class AddClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			System.out.println("AddClasses init");
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
		String classname = request.getParameter("class_name");
		String classcode = request.getParameter("class_code");
		String noofstudents = request.getParameter("numberof_students");
		String subjectcode = request.getParameter("subject_code");
		String teacherid = request.getParameter("teacher_id");
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");


		try (PreparedStatement statement = connection.prepareStatement("insert into classes values (?,?,?,?,?,?,?,?)");) {

			// resultset = read from db where email = 'x'
			// if resultset.hasnext() { pw.write("User already exists"); }
			statement.setString(1, id);
			statement.setString(2, classname);
			statement.setString(3, classcode);
			statement.setString(4, noofstudents);
			statement.setString(5, subjectcode);
			statement.setString(6, teacherid);
			statement.setString(7, firstname);
			statement.setString(8, lastname);

			int rowsInserted = statement.executeUpdate();
			System.out.println("Number of rows inserted: " + rowsInserted);

			PrintWriter pw = response.getWriter();
			pw.write("Class Successfully added");
			pw.write("<p><a href=\"classes.html\">Back</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void destroy() {
		try {
			System.out.println("AddClassesServlet.destroy() method. DB connection closed");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
