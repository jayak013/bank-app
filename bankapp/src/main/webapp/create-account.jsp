<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

form {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	display: grid;
	grid-template-columns: repeat(2, 1fr);
	gap: 2px;
}

label {
	display: block;
	margin-bottom: 8px;
}

input, select {
	width: 100%;
	padding: 8px;
	margin-bottom: 16px;
	box-sizing: border-box;
}

button {
	grid-column: span 2;
	background-color: #4caf50;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

button:hover {
	background-color: #45a049;
}
</style>
<title>Customer Registration Form</title>
</head>
<body>

	<form action="/admin/create-bank-account?action=create" method="post">
		<label for="name">Name:</label> <input type="text" id="name"
			name="name" required> <label for="dob">Date of Birth:</label>
		<input type="date" id="dob" name="dob" required> <label
			for="gender">Gender:</label> <select id="gender" name="gender"
			required>
			<option value="male">Male</option>
			<option value="female">Female</option>
			<option value="others">Others</option>
		</select> <label for="mobile">Mobile Number:</label> <input type="tel"
			id="mobile" name="mobile" pattern="[0-9]{10}" required> <label
			for="email">Email:</label> <input type="email" id="email"
			name="email" required> <label for="aadhaar">Aadhaar
			Number:</label> <input type="text" id="aadhaar" name="aadhaar"
			pattern="[0-9]{12}" required> <label for="username">Username:</label>
		<input type="text" id="username" name="username" required> <label
			for="password">Password:</label> <input type="password" id="password"
			name="password" required> <label for="address">Address:</label>
		<input id="address" name="address" required></input>

		<button type="submit">Submit</button>
		<button onclick="redirectForm()">Go Back</button>
	</form>
<script>
	function redirectForm(){
		window.location.href = "admin-dashboard.jsp";
	}
</script>
</body>
</html>
