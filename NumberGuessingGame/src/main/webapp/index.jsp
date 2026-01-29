<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Number Guessing Game</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h2>🎯 Number Guessing Game</h2>

<form action="GuessServlet" method="post">
    <input type="hidden" name="action" value="start">
    <button type="submit">Start New Game</button>
</form>

</body>
</html>
