<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,com.library.DBConnection" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<h2>Borrowed Books (Admin)</h2>

<table>
<tr>
<th>User ID</th><th>Book</th><th>Status</th><th>Action</th>
</tr>

<%
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(
"SELECT borrow_books.id, borrow_books.book_id, borrow_books.user_id, books.title, borrow_books.status FROM borrow_books JOIN books ON borrow_books.book_id=books.id");

while(rs.next()){
%>
<tr>
<td><%=rs.getInt("user_id")%></td>
<td><%=rs.getString("title")%></td>
<td><%=rs.getString("status")%></td>
<td>
<% if("Borrowed".equals(rs.getString("status"))){ %>
<a href="ReturnBookServlet?id=<%=rs.getInt("id")%>&bookId=<%=rs.getInt("book_id")%>">Mark Submitted</a>
<% } %>
</td>
</tr>
<% } %>
</table>

<a href="adminDashboard.jsp">Back to Admin Dashboard</a>
</body>
</html>