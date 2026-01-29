<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<style>

body {
	margin: 0;
	position: relative;
	justify-content: center;  
    align-items: center; 
    background-color: #f0f0f0;
    
}
.center-div {
    background: #82b9b6;
    padding: 20px;
    border-radius: 8px;
    }
    @media screen and (min-width: 992px) {
            body {
                height: 100vh;
                justify-content: center;   /* horizontal center */
                align-items: center;       /* vertical center */
            }
            .center-div {
            	position: absolute;
    			top: 50%;
   	 			left: 50%;
    			transform: translate(-50%, -50%);
                text-align: center;        /* center anchor inside div */
            }
a {
	background-color: #070707;
	text-decoration: none;
	font-size: 24px;
	color: white; 
	padding: 12px 24px;
  	border-radius: 6px;
 	border: solid;
}
a:hover {
            background: #0056b3;
        }
</style>
</head>
<body>
<h2> Digital Library</h2>
<div class="center-div">
<a href="adminLogin.jsp">Admin Login</a><br><br><br>
<a href="userLogin.jsp">User Login</a>
</div>
</body>
</html>