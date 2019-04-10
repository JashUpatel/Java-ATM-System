<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<% request.getAttribute("msg"); %>

<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ATM System.</title>
    <link rel="stylesheet" href="indexstyle.css">
    <link rel="stylesheet" href="all.css">
    <script type="text/javascript">
    //var width=window.innerWidth;,,,,screen.Width;
    //if($(window).width()<=375)
    var wid = window.screen.availWidth;
      var hide = document.getElementById('img');
    if(wid<375){

      hide.style.display="none";
      hide.style.font-size="";
    document.getElementById('img').classList.add('fa-3x');
     document.getElementById('img').classList.remove('fa-5x');
    document.getElementsByTagName('h3').setAttribute('font-size',"1em")
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
<form class="" action="loginServlet" method="post" autocomplete="off">


        <div id="h">
          <center>
          <h1>login</h1>
        </center>
        </div>
<center>
        <table id="tab">
          <tr><td><input autocomplete="off"  name="hidden" type="text" style="display:none;"></td></tr>

          <tr>
          <td>
            <i class="far fa-credit-card" style="color:ac9766"></i> &nbsp;
          <label for="cardno"> Card Number</label>
          <td></td>
          </td>
          <td>
          <input type="integer" name="card" placeholder="      123456789012"  readonly="readonly" onfocus="javascript: this.removeAttribute('readonly')" required minlength="16" maxlength="16" pattern="[0-9]*" title="Card Number Contain Exactly 16 Digits Numeric Value" onemptied="Please Enter Card Number!" >
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
          <td>
            <i class="fas fa-key"></i> &nbsp;
          <label for="pin">Pin</label>
          </td>
          <td></td>
          <td>
          <input type="password" name="pin" minlength="4" maxlength="4" autocomplete="off"  placeholder="       XXXX" required  onfocus=""  pattern="[0-9]*" title="Please Provide Your 4 Digits Numberic Pin For Authentication!" oninput="" >
        </td>

          </tr>
          <tr>


          </tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>

          <tr>
            <td></td>
            <td></td>
            <td style="float:right; margin-right:60px;">
              <button type="submit" name="login">Login &nbsp;<i class="fas fa-sign-in-alt"></i> </button>
            </td>
          </tr>
        </table>
        <h3 style="text-decoration:underline; color:#fff; text-shadow: 1.5px 1.5px 5px #0c1f31;font-size: 1.45em;">
        ${msg}
         </h3>
         
</center>

</form>
      </div>

    </section>
    <footer style="height:85px">
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