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
<h2>Welcome ${sessionScope.user}</h2>

<form action="profileServlet" method="post">
Email: <input name="email"><br>
New Password: <input type="password" name="password"><br>
<button>Update</button>
</form>

<a href="exam.jsp">Start Exam</a>
<a href="LogoutServlet">Logout</a>


</body>
</html>