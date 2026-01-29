package com.library;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class BorrowBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int bookId = Integer.parseInt(req.getParameter("bookId"));
        int userId = (int) req.getSession().getAttribute("userId");

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 = con.prepareStatement(
                "INSERT INTO borrow_books(user_id, book_id) VALUES (?,?)");
            ps1.setInt(1, userId);
            ps1.setInt(2, bookId);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(
                "UPDATE books SET quantity = quantity - 1 WHERE id=?");
            ps2.setInt(1, bookId);
            ps2.executeUpdate();

            res.sendRedirect("userDashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
