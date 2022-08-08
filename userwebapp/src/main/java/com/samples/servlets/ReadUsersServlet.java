package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet(urlPatterns = "/readuserServlet", loadOnStartup = 4)
public class ReadUsersServlet extends HttpServlet {

	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			System.out.println("ReadServlet init");
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doGet");
		try (Statement statement = connection.createStatement();) {

			// resultset = read from db where email = 'x'
			// if resultset.hasnext() { pw.write("User already exists"); }

			ResultSet results = statement.executeQuery("select * from user");
			PrintWriter out = response.getWriter();
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>Email</th>");
			out.println("</tr>");
			while (results.next()) {
				out.println("<tr>");
				out.println("<td>" + results.getString(1) + "</td>");
				out.println("<td>" + results.getString(2) + "</td>");
				out.println("<td>" + results.getString(3) + "</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<p><a href=\"userhome.html\">Home</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void destroy() {
		try {
			System.out.println("AddUserSevlet.destroy() method. DB connection closed");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}