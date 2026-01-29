<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<form action="LoginServlet" method="post">
    Username: <input name="username"><br>
    Password: <input type="password" name="password"><br>
    <button>Login</button>
</form>
<p>${error}</p>

</body>
</html>