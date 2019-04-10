

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			String msg="yooo";
			long card = Long.parseLong(request.getParameter("card"));
			int pin = Integer.parseInt(request.getParameter("pin"));
			PrintWriter out = response.getWriter();
			String url = "jdbc:mysql://localhost:3306/atm";
			String uname = "root";
			String pass = "";
			String query = "SELECT * from account where card = "; 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, uname, pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query + card);
			if(rs.next()) {
				int cpin = rs.getInt("pin");
				if(cpin==pin)
				{
					int balance = rs.getInt("balance");
					long account = rs.getLong("account");
					String name = rs.getString("name");
					
				HttpSession session = request.getSession();
				session.setAttribute("card", card);
				session.setAttribute("name", name);
				session.setAttribute("pin", pin);
				session.setAttribute("account", account);
				session.setAttribute("balance", balance);
				response.sendRedirect("transc.jsp");
				}
				else
				{
					request.setAttribute("msg", "Wrong Credentials !");
					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}

				
			}
			else {
				request.setAttribute("msg", "Account not Found !");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			System.out.println("inside catch");
			e.printStackTrace();
		}
		
		
	}
}
