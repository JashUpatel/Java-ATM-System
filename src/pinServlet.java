

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class pin
 */
@WebServlet("/pinServlet")
public class pinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
   		try {
   			String ch = (String)request.getParameter("ch");
   			if(ch.equals("nochange")) {
   				
   	   				request.setAttribute("msg", "");
   	  				RequestDispatcher rd = request.getRequestDispatcher("pin.jsp");
   	  				rd.forward(request, response);
   	   				
   	   			}
   			else if(ch.equals("change")){
   			
   			PrintWriter out = response.getWriter();
			
   			if(request.getParameter("pin")=="")
			{
				//out.println("Pin value cannot be set empty!");
   				request.setAttribute("msg", "Pin value cannot be set empty !");
				RequestDispatcher rd = request.getRequestDispatcher("pin.jsp");
				rd.forward(request, response);
			}
			else {
				if(!(request.getParameter("cpin").equals(request.getParameter("pin"))))
				{
					//out.println("Pin value Doesn't  Match!");	
					request.setAttribute("msg", "Pin value Doesn't  Match !");
					RequestDispatcher rd = request.getRequestDispatcher("pin.jsp");
					rd.forward(request, response);
				}
				else {
						
					
			try {		
			 Integer.parseInt(request.getParameter("pin"));
			 Integer.parseInt(request.getParameter("cpin"));
			}
			catch(NumberFormatException ex)
			{
				//out.println("Pin must be in numeric format!");
				request.setAttribute("msg", "Pin must be in numeric format !");
				RequestDispatcher rd = request.getRequestDispatcher("pin.jsp");
				rd.forward(request, response);
			}
			HttpSession session = request.getSession();
			long card = (long)session.getAttribute("card"); 
			
			int pin = Integer.parseInt(request.getParameter("pin"));
			int cpin = Integer.parseInt(request.getParameter("cpin"));
				
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
			PreparedStatement ps = con.prepareStatement("UPDATE account SET pin = ? WHERE card = ?");

    	    // set the preparedstatement parameters
    	    ps.setInt(1,pin);
    	    ps.setLong(2,card);
    	     int check = ps.executeUpdate();
    	     if(check>0)
    	     {
    	    	 //out.print("updated successfully!");
    	    	request.setAttribute("msg", "Pin Changed Sucessfully.");
 				RequestDispatcher rd = request.getRequestDispatcher("pin.jsp");
 				rd.forward(request, response);
    	     }
    	     else{
    	    	// out.println("pin not changed !");
    	    	request.setAttribute("msg", "Pin not changed !");
  				RequestDispatcher rd = request.getRequestDispatcher("pin.jsp");
  				rd.forward(request, response);
    	     }
    	    ps.close();
				}
				
			}

			//Statement st = con.createStatement();
			//ResultSet rs = st.executeQuery(query + pin + q);
   		}	
   			else {
   				request.setAttribute("msg", "Pin not changed !");
	  				RequestDispatcher rd = request.getRequestDispatcher("pin.jsp");
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
