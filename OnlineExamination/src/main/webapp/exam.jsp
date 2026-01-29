<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Java Quiz</title>
    <link rel="stylesheet" href="style.css">
    <script src="script.js"></script>
</head>
<body>

    <div class="container">
        <h1>Java Basics Quiz</h1>

        <form action="ExamServlet" method="post" id="examForm">
    <div class="question">
        <p><strong>1. Java is?</strong></p>
        <label><input type="radio" name="q1" value="OS"> OS</label>
        <label><input type="radio" name="q1" value="Language"> Language</label>
        <label><input type="radio" name="q1" value="Browser"> Browser</label>
        <label><input type="radio" name="q1" value="Device"> Device</label>
    </div>

    <div class="question">
        <p><strong>2. JSP stands for?</strong></p>
        <label><input type="radio" name="q2" value="Java Server Pages"> Java Server Pages</label>
        <label><input type="radio" name="q2" value="Java Script"> Java Script</label>
        <label><input type="radio" name="q2" value="JSON"> JSON</label>
        <label><input type="radio" name="q2" value="None"> None</label>
    </div>

    <button type="submit" class="submit-btn">Submit</button>
</form>


        <div id="timer" class="timer">Time Left: <span id="time">15</span></div>
    </div>

</body>
</html>