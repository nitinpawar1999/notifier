<link rel="stylesheet" type="text/css" href="views/css/login.css">

<% if(request.getAttribute("error") != null){ %>
  <script>
    alert('${error}')</script>
  <%}%>
<html>


<h1>RemindMe</h1>

<div class="login-page">
  <h2>Login Page</h2>
  <div class="form">
    <form name="login" class="login-form" action="<%=request.getContextPath()%>/login" method="post">
      <input type="email" name="emailAddress" placeholder="Email Address" required=""
        oninvalid="this.setCustomValidity('Please Enter valid email')"
        oninput="setCustomValidity('')" />

      <input type="password" id ="pass" name="password" placeholder="Password" minlength="8" required="" 
        oninvalid="this.setCustomValidity('Please Enter Valid Password Minimum Length - 8')"
        oninput="setCustomValidity('')" />
        
      <input type="submit" value="Login" />
      <p class="message">Not a member? <a href="views/register.jsp">Sign Up</a></p>
    </form>
  </div>
</div>

</html>