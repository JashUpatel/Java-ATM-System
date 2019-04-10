<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
    
<% long card = (long)session.getAttribute("card"); %>
<% String name = (String)session.getAttribute("name"); %>
<% int pin = (int)session.getAttribute("pin"); %>
<% long account = (long)session.getAttribute("account"); %>
<%
try{
String url = "jdbc:mysql://localhost:3306/atm";
String uname = "root";
String pass = "";
String query = "SELECT * from account where card = "; 
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con = DriverManager.getConnection(url, uname, pass);
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(query + card);
if(rs.next()){ 
int bal = rs.getInt("balance");
session.setAttribute("balance", bal);
}
}
catch(Exception e)
{
	System.out.println("inside catch");
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ATM System.</title>
    <link rel="stylesheet" href="indexstyle.css">
    <link rel="stylesheet" href="all.css">

<script type="text/javascript">

  function cancel(){
    document.write();
    window.location.assign("transc.jsp");

  }
</script>

  </head>
  <body>


      <header>
        <div class="logo">
<i class="fa fa-university fa-5x" id="img" style="color:#ac9766; text-shadow:3px 3px 3px #fff;"></i>
        </div>
        <div class="brand">
          <h1>People's Bank</h1>
          <p>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp kyuki apna time aayega !</p>

        </div>
      </header>

      <section id="mainbal">
      <div id="log" style="opacity:0.9;">
<form class="" action="" method="post">

        <div id="h">
          <center>
          <h1>Balance Inquiry</h1>
        </center>
        </div>
<center>
<h3 style="margin-top:15px;margin-bottom:0;color:#fff;text-decoration:underline;text-shadow: 1px 1px 1.75px #c1c1c1;font-size: 1.45em;">
          ${msg}
          </h3>
        <table id="tab" style="margin-top:1.5%!important;">

             <tr>
          <td>
          <i class="fas fa-fingerprint"></i>&nbsp;
          <label for="cardno">Account Number</label>
          </td>
          <td></td>
          <td style="margin-left:50px;">
          <span> 
              <%=account %>
               &nbsp;
            </span>
          </td>
          </tr>


          <tr>
          <td>
            <i class="fas fa-money-check-alt"></i> &nbsp;
          <label for="cardno">Current Account Balance</label>
          </td>
          <td></td>
          <% int balance = (int)session.getAttribute("balance"); %>
          <td style="margin-left:50px;">
          <span>  <i class="fas fa-rupee-sign"></i> &nbsp;
			<%=balance %>/-
        </span>
          </td>
          </tr>

          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
    <tr style="display:none">
          <td>
            <i class="fas fa-key"></i> &nbsp;
          <label for="pin">Pin</label>
          </td>
          <td></td>
          <td>
          <input type="password" name="pin" placeholder="       XXXXXX">
          </td>
          </tr>

          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>

          <tr>
          

            <td style="float:right;">
              <button onclick="cancel()" style="margin-left:20%; margin-top:25%; width:135%;" type="submit" name="submit"> Cancel Transaction &nbsp;<i class="far fa-times-circle"></i></button>
            </td>
            <td></td>
            <td></td>
          </tr>
        </table>
        </center>

</form>
      </div>

    </section>
    <footer>
      <div id="foot">
      <center>
      <br>
        <p>&copy; 2019 people's bank</p>
        <p>all right Reserved</p>
      </center>
      </div>
    </footer>
  </body>
</html>
