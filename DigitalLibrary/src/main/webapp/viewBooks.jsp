<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*,com.library.DBConnection" %>
    
    <% String role = (String) session.getAttribute("admin");
Integer userId = (Integer) session.getAttribute("userId");
Connection con = DBConnection.getConnection();
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM books");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

<h2>Books List</h2>

<table>
<tr>
<th>Title</th><th>Author</th><th>Category</th><th>Qty</th><th>Action</th>
</tr>

<%
while(rs.next()){
%>
<tr>
<td><%=rs.getString("title")%></td>
<td><%=rs.getString("author")%></td>
<td><%=rs.getString("category")%></td>
<td><%=rs.getInt("quantity")%></td>

<td>
<% if(role != null){ %>
    <!-- ADMIN OPTIONS -->
    <a href="DeleteBookServlet?id=<%=rs.getInt("id")%>">Delete</a>
<% } else { %>
    <!-- USER OPTION -->
    <% if(rs.getInt("quantity") > 0){ %>
    <a href="BorrowBookServlet?bookId=<%=rs.getInt("id")%>">Borrow</a>
    <% } else { %>
    Not Available
    <% } %>
<% } %>
</td>
</tr>
<% } %> 
</table>

<br>

<% if(role != null){ %>
<a href="adminDashboard.jsp">Back to Admin Dashboard</a>
<% } else { %>
<a href="userDashboard.jsp">Back to User Dashboard</a>
<% } %>
</body>
</html>