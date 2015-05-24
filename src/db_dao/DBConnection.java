package db_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() throws SQLException,
	InstantiationException, IllegalAccessException, ClassNotFoundException{
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3308/bankingsystem";
		String user = "root";
		String password = "12345";
		//DBProperty pro =new DBProperty();
		Connection conn =null;
		Class.forName(driver).newInstance();
		conn=DriverManager.getConnection(url,user,password);
		return conn;
	}
}
