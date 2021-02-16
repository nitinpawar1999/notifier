<link rel="stylesheet" type="text/css" href="css/register-page.css">


<% if(request.getAttribute("error") != null){ %>
<script>
  alert('${error}')</script>
<%}%>
<html>
<div class="register-page">
  <h2>Sign Up</h2>
  <div class="form">
    <form action="<%=request.getContextPath()%>/register" method="post" class="register-form">
      <input type="text" name="userName" placeholder="User Name" required />
      <input type="text" name="emailAddress" placeholder="Email Address" required />
      <input type="number" name="mobNumber" placeholder="Mobile Number" required />
      <input type="password" name="password" placeholder="Password" id="password" minlength="8" required=""
        oninvalid="this.setCustomValidity('Please Enter Valid Password Minimum Length - 8')"
        oninput="setCustomValidity('')" />
      <input type="password" name="conPass" placeholder="Confirm Password" id="confirm_password" required />
      <input type="submit" value="Submit" />
      <p class="message">Already registered? <a href="#"
          onclick="javascript:window.history.back(-1);return false;">Login</a></p>
    </form>

  </div>
</div>

</html>

<script>
  var password = document.getElementById("password")
    , confirm_password = document.getElementById("confirm_password");

  function validatePassword() {
    if (password.value != confirm_password.value) {
      confirm_password.setCustomValidity("Passwords Don't Match");
    } else {
      confirm_password.setCustomValidity('');
    }
  }

  function error(msg) {
    alert(msg);
  }
  password.onchange = validatePassword;
  confirm_password.onkeyup = validatePassword;
</script>