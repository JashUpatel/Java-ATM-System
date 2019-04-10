package atm;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class qry {
	
	public static void main(String args[]) throws Exception
	{
		String url = "jdbc:mysql://localhost:3306/atm";
		String uname = "root";
		String pass = "jash.u.patel007";
		String query = "SELECT * from account where card= ?"; 
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
//		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, "9123014702580369");
		ResultSet rs = st.executeQuery();
		if(rs.next())
		{
		String name =rs.getString("name");
		System.out.print(name);
		}
		else
		{
			System.out.println("xxx");
		}
		st.close();
		con.close();
		}
}
