<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .login-container {
      background-color: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      width: 300px;
    }

    .login-container h2 {
      text-align: center;
      color: #333;
    }

    .login-form {
      margin-top: 20px;
    }

    .form-group {
      margin-bottom: 15px;
    }

    .form-group label {
      display: block;
      font-size: 14px;
      color: #333;
      margin-bottom: 5px;
    }

    .form-group input {
      width: 100%;
      padding: 8px;
      font-size: 14px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .form-group button {
      background-color: #007BFF;
      color: #fff;
      padding: 8px 12px;
      font-size: 14px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      margin-right: 5px;
    }

    .form-group button.cancel {
      background-color: #ccc;
      color: #333;
    }

    .form-group button:hover,
    .form-group button.cancel:hover {
      opacity: 0.8;
    }
  </style>
</head>
<body>

  <div class="login-container">
    <h2>Login</h2>
    <form class="login-form" id="loginForm" action="user" method="post">
      <div class="form-group">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>
      </div>
      <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>
      </div>
      <div class="form-group">
        <button type="submit">Login</button>
        <button type="button" class="cancel" onclick="resetForm()">Cancel</button>
      </div>
    </form>
  </div>


  


</body>
</html>
