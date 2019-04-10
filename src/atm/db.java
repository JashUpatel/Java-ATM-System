package atm;
import java.sql.*;

public class db {
	
	public static Connection con = null;
	public static Connection getConnection()
	{
	String url = "jdbc:mysql://localhost/atm";
	String name = "root";
	String pass = "";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url, name, pass);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
	}
	

}
