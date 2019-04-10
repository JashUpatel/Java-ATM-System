<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <% if(session == null){ response.sendRedirect("index.jsp");} %>    
    
<% long card = (long)session.getAttribute("card"); %>
<% String name = (String)session.getAttribute("name"); %>
<% int pin = (int)session.getAttribute("pin"); %>
<% long account = (long)session.getAttribute("account"); %>
<% int balance = (int)session.getAttribute("balance"); %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ATM System.</title>
    <link rel="stylesheet" href="transcstyle.css">
    <link rel="stylesheet" href="all.css">

    <script type="text/javascript">


function redirect(button){
  var x = button.id;

  switch (x) {
    case '1':
    document.write();
    window.location.assign("deposit.jsp");
      break;
    case '2':
    document.write();
    window.location.assign("with.jsp");
      break;
      case '3':
      document.write();
        window.location.assign("pin.jsp");
        break;
      case '4':
      document.write();
      window.location.assign("bal.jsp");
        break;
      case '5':
      var ans =  confirm("Press Ok to Logout?");
      if (ans == true) {
        document.write();
        window.location.assign("logout.jsp");

      } else {
      return false
      }
  break;

    default:
    return false;

  }

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

      <section id="main">
      <div id="log">
    <form class="" action="" method="post">

        <div id="h">
          <center>
          <h1>Welcome &nbsp; <%=name %>
          </h1>
        </center>
        </div>
    <center>
        <table id="tab" class="option">

          <tr >
          <td class="">

          <button  onclick="redirect(this)" id="1" name="deposit">Deposit &nbsp;<i class="fas fa-rupee-sign"></i></button>
          </td>
          <td style=""></td>

          <td class="">
          <button onclick="redirect(this)" id="2" name="withdraw">Withdraw &nbsp;<i class="fas fa-money-bill-wave"></i></button>
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

          <tr>
          <td class=''>
          <a href="pin.html">  <button type="submit" onclick="redirect(this)" id="3" name="pinchange">Change Pin &nbsp;<i class="fas fa-user-shield"></i></button></a>
            </td>
          <td style=""></td>
          <td class="">
          <a href="bal.html"> <button type="submit" onclick="redirect(this)" id="4" name="balance"> Balance Inquiry  &nbsp;<i class="fas fa-money-check-alt"></i></button></a>
          </td>
          </tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>

          <tr>
            <center>
            <td></td>

            <td style="margin-left:auto; margin-right:auto;" id="cancel">
           <button type="submit" onclick="redirect(this)"  id="5"  name="logout">Logout &nbsp;<i class="far fa-times-circle"></i></button>
            </td>
            <td>
            </td>

<center>
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
