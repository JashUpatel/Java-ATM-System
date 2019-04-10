

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
 * Servlet implementation class withServlet
 */
@WebServlet("/withServlet")
public class withServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    		try {
       			String with = (String)request.getParameter("with");
       			if(with.equals("nowithdraw")) {
       				
       	   				request.setAttribute("msg", "");
       	  				RequestDispatcher rd = request.getRequestDispatcher("with.jsp");
       	  				rd.forward(request, response);
       	   				
       	   			}
       			else if(with.equals("withdraw")){
       			
       			PrintWriter out = response.getWriter();
    			
       			if(request.getParameter("amount")=="")
    			{
    				//out.println("Pin value cannot be set empty!");
       				request.setAttribute("msg", "Amount value cannot be left empty!");
    				RequestDispatcher rd = request.getRequestDispatcher("with.jsp");
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
    				RequestDispatcher rd = request.getRequestDispatcher("with.jsp");
    				rd.forward(request, response);
    			}
    			HttpSession session = request.getSession();
    			long card = (long)session.getAttribute("card"); 
    			int balance = (int)session.getAttribute("balance");
    			int amount = Integer.parseInt(request.getParameter("amount"));
    			if(balance>=amount) {
    			int withdraw = balance - amount;	
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
        	    ps.setInt(1,withdraw);
        	    ps.setLong(2,card);
        	     int check = ps.executeUpdate();
        	     if(check>0)
        	     {
        	    	 //out.print("updated successfully!");
        	    	request.setAttribute("msg", "Amount Withdrawn Successfully.");
     				RequestDispatcher rd = request.getRequestDispatcher("bal.jsp");
     				rd.forward(request, response);
        	     }
        	     else{
        	    	// out.println("pin not changed !");
        	    	request.setAttribute("msg", "Amount not Withdrawn !");
      				RequestDispatcher rd = request.getRequestDispatcher("with.jsp");
      				rd.forward(request, response);
        	     }
        	     ps.close();
     			
    			}
    			else {
    				request.setAttribute("msg", "Insufficient Balance in your Account !");
	  				RequestDispatcher rd = request.getRequestDispatcher("with.jsp");
	  				rd.forward(request, response);
   
    			}
        	    	
    				
    			}

    			//Statement st = con.createStatement();
    			//ResultSet rs = st.executeQuery(query + pin + q);
       		}	
       			else {
       				request.setAttribute("msg", "Amount not withdrawn !");
    	  				RequestDispatcher rd = request.getRequestDispatcher("with.jsp");
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
