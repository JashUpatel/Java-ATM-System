package atm;

import java.sql.*;
public class sqlq {

	
	public static void main(String args[]) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/atm";
		String uname = "root";
		String pass = "";
		String query = "SELECT * from account where pin= ?"; 
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
//		Connection con = DriverManager.getConnection(url,uname,pass);
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1, 1111);
		ResultSet rs = st.executeQuery();
		if(rs.next())
		{
		int bal = rs.getInt("balance");
		String name =rs.getString("name");
		System.out.print(name);
		System.out.println(bal);
		}
		else
		{
			System.out.println("xxx");
		}
		st.close();
		con.close();
	}

}


