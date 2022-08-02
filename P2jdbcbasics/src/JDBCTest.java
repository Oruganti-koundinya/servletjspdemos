import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	public static void main(String[] args) {
		
		readFromDB();
		//insertIntoDB();
		//UpdateDB();
		//DeleteFromDB();

	}
	private static void DeleteFromDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Venkatesha@09");			
				Statement statement = connection.createStatement();) {
			int Deleterows = statement.executeUpdate("Delete From account Where accno = 1");
			System.out.println("Number of rows Deleted :" +Deleterows);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void UpdateDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Venkatesha@09");			
				Statement statement = connection.createStatement();) {
			int Updaterows = statement.executeUpdate("Update account set balance = 50000 where accno =3");
			System.out.println("Number of rows updated :" +Updaterows);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void insertIntoDB() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Venkatesha@09");			
				Statement statement = connection.createStatement();)
		{
			int rowsinserted = statement.executeUpdate("Insert into account values(3, 'Ravana', 'Asura', 150000)");
			System.out.println("Number of rows inserted :" + rowsinserted);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private static void readFromDB()
	{
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Venkatesha@09");			
				Statement statement = connection.createStatement();)
		{
			ResultSet resultSet = statement.executeQuery("select * from account");
			while (resultSet.next()) {				
				System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3) + ", " + resultSet.getInt(4));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


//Connection connection = null;
//Statement statement = null;
//try {
//	connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "Venkatesha@09");
//	statement = connection.createStatement();
//	ResultSet resultSet = statement.executeQuery("select * from account");
//	while (resultSet.next()) {				
//		System.out.println(resultSet.getInt(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3) + ", " + resultSet.getInt(4));
//	}
//} catch (SQLException e) {
//	e.printStackTrace();
//} finally  {
//	try {
//		statement.close();
//		connection.close();
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//}