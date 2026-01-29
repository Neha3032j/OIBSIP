<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Guess the Number</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Guess a number between 1 and 100</h2>

<p>Attempts Left: ${attempts}</p>
<p>${message}</p>

<form action="GuessServlet" method="post">
    <input type="number" name="guess" required>
    <button type="submit">Submit Guess</button>
</form>

</body>
</html>
