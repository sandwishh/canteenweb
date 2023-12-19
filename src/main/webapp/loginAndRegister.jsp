<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
  <link rel="stylesheet" href="style.css">
  <title>Login And Register Page</title>
</head>
<body>
<div class="container" id="container">
  <div class="form-container sign-up">
    <form action="Register" method="post">
      <h1>Create Account</h1>
      <input type="text" placeholder="User Name" name="uname">
      <input type="text" placeholder="Email" name="email">
      <input type="password" placeholder="Create new Password" name="password">
      <select class="select-box" name="department">
        <option value="user">User</option>
      </select>

      <button>Sign Up</button>

    </form>
  </div>
  <div class="form-container sign-in">
    <form action="LoginServlet" method="post">
      <h1>Sign In</h1>
      <input type="text" placeholder="User Name" name="uname">
      <input type="password" placeholder="Password" name="password">
      <select class="select-box" name="department">
        <option value="User">User</option>
        <option value="System Admin">System Admin</option>
        <option value="Canteen Admin">Canteen Admin</option>
      </select>
      <button>Sign In</button>

    </form>
  </div>
  <div class="toggle-container">
    <div class="toggle">
      <div class="toggle-panel toggle-left">
        <h1>Welcome Back!</h1>
        <p>Enter your personal details to use all of site features</p>
        <button class="hidden" id="login">Sign In</button>
      </div>
      <div class="toggle-panel toggle-right">
        <h1>Hello, Friend!</h1>
        <p>Register with your personal details to use all of site features</p>
        <button class="hidden" id="register">Sign Up</button>
      </div>
    </div>
  </div>
</div>


<script>
  const container = document.getElementById('container');
  const registerBtn = document.getElementById('register');
  const loginBtn = document.getElementById('login');

  registerBtn.addEventListener('click', () => {
    container.classList.add("active");
  });
  loginBtn.addEventListener('click', () => {
    container.classList.remove("active");
  });

</script>
</body>

</html>
