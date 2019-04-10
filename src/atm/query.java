package atm;


import java.io.IOException;

import java.io.PrintWriter;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class query
 */
@WebServlet("/query")
public class query extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public query() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		try {
		
		long card = Long.parseLong(request.getParameter("card"));
		int pin = Integer.parseInt(request.getParameter("pin"));
		PrintWriter out = response.getWriter();
//		out.println("uper "+card);
//		out.println("uper "+pin);
		String url = "jdbc:mysql://localhost:3306/atm";
		String uname = "root";
		String pass = "jash.u.patel007";
		String query = "SELECT * from account where pin = "; 
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, uname, pass);
//		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","jash.u.patel007");
		
		PreparedStatement st = con.prepareStatement(query);
		//st.setString(1, "9123014702580369");
		ResultSet rs = st.executeQuery();
		String m = rs.getString("name");
		
		
	//	Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery("select * from account");
		//ResultSet rs = st.executeQuery(query + "1111");
		
		while(rs.next()) {
			out.print("output --> "+rs.getString(1));
		}
		
//		out.println("hey");
//		out.println(m);
		
//		out.println("at bottom "+card);
//		out.println("at bottom "+pin);
		

		con.close();
		st.close();

		}
		catch(Exception e)
		{
			System.out.println("inside catch");
			e.printStackTrace();
		}
		
	}

}
