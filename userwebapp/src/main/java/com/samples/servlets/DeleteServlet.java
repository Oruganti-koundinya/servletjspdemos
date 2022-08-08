package com.samples.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/deleteServlet", loadOnStartup = 3)
public class DeleteServlet extends HttpServlet {

	Connection connection;

	@Override
	public void init(ServletConfig config) throws ServletException {

		try {
			System.out.println("DeleteServlet init");
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
		String email = request.getParameter("email");

		try (PreparedStatement statement = connection.prepareStatement("delete from user where email = ?")) {

			statement.setString(1, email);
			int rowsDeleted = statement.executeUpdate();
			System.out.println("Number of rows Deleted: " + rowsDeleted);

			PrintWriter pw = response.getWriter();
			pw.write("User deleted successfully");
			pw.write("<p><a href=\"userhome.html\">Home</a></p>");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void destroy() {
		try {
			System.out.println("DeleteServlet.destroy() method. DB connection closed");
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}