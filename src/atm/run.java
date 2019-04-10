package atm;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class run
 */
@WebServlet("/run")
public class run extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public run() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String card = request.getParameter("card");
		int pin = Integer.parseInt(request.getParameter("pin"));
		
		String url = "jdbc:mysql://localhost:3306/atm";
		String uname = "root";
		String pass = "";
		
		
		PrintWriter out = response.getWriter();
		out.println(card);
		out.println(pin);
		
		try {
			String query = "SELECT * from account where card = 9123014702580369"; 
			
			
		out.println("try");
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url,uname,pass);
		//Connection con = db.getConnection();
		PreparedStatement st = con.prepareStatement(query);
		//st.setString(1, "9123014702580369");
		ResultSet rs = st.executeQuery();
		String m = rs.getString("name");
		out.println("mkji");
		out.println(m);

		st.close();
		
		con.close();
		//if(rs.next())
		//String name =rs.getString("name");
		//System.out.print(name);
			
		if(rs.next())
		{
			int cpin = rs.getInt("pin");
			System.out.println(cpin);
			out.println(cpin);
			out.println("cpin");
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
			
			//response.sendRedirect("transc.jsp");
			System.out.print(card);
			}
			else
			{
				//request.setAttribute("msg", "Wrong Credentials !");
				//RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				//rd.forward(request, response);
			}
		}
		else {
			out.println("name");
			out.println("password");
			
			//request.setAttribute("msg", "User not Found !");
			//RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			//rd.forward(request, response);
		}
		
		con.close();
		st.close();
		
		
		}
		catch(Exception e)
		{
			out.println("cath");
			e.printStackTrace();
		}
		
//		doGet(request, response);
	}

}
