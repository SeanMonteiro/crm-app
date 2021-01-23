package sean.springdemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
		String user = "springstudent";
		String password = "springstudent";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection Successfull");
			conn.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
