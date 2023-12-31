<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Accounting Dashboard</title>
    <link rel="stylesheet" href="admin-dashboard.css"> 
</head>
<body>
    <header>
        <h1>Welcome To Admin Dashboard </h1>
        <h1>Username: <c:out value="<%=request.getParameter(\"username\")%>"/></h1>
        <a href="login.jsp?action=logout" 	class="logout-button">Logout</a>
    </header>

    <main>
        <div class="app-grid">
            <a href="create-account.jsp?id=1" class="app-link">Create Account</a>
            <a href="/deposit" class="app-link">Deposit</a>
            <a href="/withdraw" class="app-link">Withdraw</a>
            <a href="/transfer" class="app-link">Transfer</a>
            <a href="/check-balance" class="app-link">Check Balance</a>
            <a href="/transaction-history" class="app-link">Transaction History</a>
        </div>
    </main>
</body>
</html>
<%request.setAttribute("login", "admin"); %>