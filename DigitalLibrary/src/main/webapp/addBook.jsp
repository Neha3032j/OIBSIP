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
<form action="AddBookServlet" method="post">
Title: <input name="title"><br>
Author: <input name="author"><br>
Category: <input name="category"><br>
Quantity: <input name="quantity"><br>
<button>Add Book</button>
</form>

</body>
</html>