package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/classreport")
public class ClassReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			System.out.println("ClassReportServlet init");
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
		String classcode = request.getParameter("class_code");
//		System.out.println("doGet");
		try (PreparedStatement statement = connection.prepareStatement("select * from classreport where class_code = ?")) {
			
			statement.setString(1, classcode);
			
			ResultSet results = statement.executeQuery();
			PrintWriter out = response.getWriter();
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>student_id</th>");
			out.println("<th>student_name</th>");
			out.println("<th>class_code</th>");
			out.println("<th>class_name</th>");
			out.println("<th>teacher_code</th>");
			out.println("<th>first_name</th>");
			out.println("<th>last_name</th>");
			out.println("<th>subject_code</th>");
			out.println("<th>subject_name</th>");
			out.println("</tr>");
			while (results.next()) {
				out.println("<tr>");
				out.println("<td>" + results.getInt(1) + "</td>");
				out.println("<td>" + results.getString(2) + "</td>");
				out.println("<td>" + results.getString(3) + "</td>");
				out.println("<td>" + results.getString(4) + "</td>");
				out.println("<td>" + results.getString(5) + "</td>");
				out.println("<td>" + results.getString(6) + "</td>");
				out.println("<td>" + results.getString(7) + "</td>");
				out.println("<td>" + results.getString(8) + "</td>");
				out.println("<td>" + results.getString(9) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			PrintWriter pw = response.getWriter();
			pw.write("Class Report executed successfully");
			out.println("<p><a href=\"LearnersAcademy.html\">Back</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void destroy() {
		try {
			System.out.println("ClassReportServlet.destroy() method. DB connection closed");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
