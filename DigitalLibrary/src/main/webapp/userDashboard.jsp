<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,com.library.DBConnection" %>
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
    background-color: #f0f0f0;
    
}
.center-div {
    
    /*background: #82b9b6;*/
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
            	/*position: absolute;*/
    			top: 20%;
   	 			left: 50%;
    			/*transform: translate(-50%, -50%);*/
                text-align: center;        /* center anchor inside div */
            }
        }
        

a {
	background-color: #070707;
	text-decoration: none;
	font-size: 20px;
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
<h2>User Dashboard</h2>
<div class="center-div">
<a href="viewBooks.jsp">View Books</a> |
<a href="LogoutServlet">Logout</a>
</div>

<h3>Your Borrowed Books</h3>

<table>
<tr><th>Book</th><th>Status</th></tr>

<%
int uid = (int) session.getAttribute("userId");
Connection con = DBConnection.getConnection();
PreparedStatement ps = con.prepareStatement(
"SELECT books.title, borrow_books.status FROM borrow_books JOIN books ON borrow_books.book_id=books.id WHERE borrow_books.user_id=?");
ps.setInt(1, uid);
ResultSet rs = ps.executeQuery();

while(rs.next()){
%>
<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
</tr>
<% } %>
</table>
</body>
</html>