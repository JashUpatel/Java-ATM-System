

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class depositServlet
 */
@WebServlet("/depositServlet")
public class depositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
   		try {
   			String ch = (String)request.getParameter("dp");
   			if(ch.equals("nodeposit")) {
   				
   	   				request.setAttribute("msg", "");
   	  				RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
   	  				rd.forward(request, response);
   	   				
   	   			}
   			else if(ch.equals("deposit")){
   			
   			PrintWriter out = response.getWriter();
			
   			if(request.getParameter("amount")=="")
			{
				//out.println("Pin value cannot be set empty!");
   				request.setAttribute("msg", "Amount value cannot be left empty!");
				RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
				rd.forward(request, response);
			}
			else {
								
			try {		
			 Integer.parseInt(request.getParameter("amount"));
			
			}
			catch(NumberFormatException ex)
			{
				//out.println("Pin must be in numeric format!");
				request.setAttribute("msg", "Amount must be in numeric format !");
				RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
				rd.forward(request, response);
			}
			HttpSession session = request.getSession();
			long card = (long)session.getAttribute("card"); 
			int balance = (int)session.getAttribute("balance");
			int amount = Integer.parseInt(request.getParameter("amount"));
			int deposit = balance + amount;	
			String url = "jdbc:mysql://localhost:3306/atm";
			String uname = "root";
			String pass = "";
		    
			//String query = "UPDATE account SET pin = ";
			//String q = " WHERE card = "; 
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
			Connection con = DriverManager.getConnection(url, uname, pass);
			PreparedStatement ps = con.prepareStatement("UPDATE account SET balance = ? WHERE card = ?");

    	    // set the preparedstatement parameters
    	    ps.setInt(1,deposit);
    	    ps.setLong(2,card);
    	     int check = ps.executeUpdate();
    	     if(check>0)
    	     {
    	    	 //out.print("updated successfully!");
    	    	request.setAttribute("msg", "Amount Deposited Successfully.");
 				RequestDispatcher rd = request.getRequestDispatcher("bal.jsp");
 				rd.forward(request, response);
    	     }
    	     else{
    	    	// out.println("pin not changed !");
    	    	request.setAttribute("msg", "Amount not Deposited !");
  				RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
  				rd.forward(request, response);
    	     }
    	    ps.close();
				
				
			}

			//Statement st = con.createStatement();
			//ResultSet rs = st.executeQuery(query + pin + q);
   		}	
   			else {
   				request.setAttribute("msg", "Amount not Deposited !");
	  				RequestDispatcher rd = request.getRequestDispatcher("deposit.jsp");
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
