package com.library;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ReturnBookServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int borrowId = Integer.parseInt(req.getParameter("id"));
        int bookId = Integer.parseInt(req.getParameter("bookId"));

        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement ps1 = con.prepareStatement(
                "UPDATE borrow_books SET status='Submitted' WHERE id=?");
            ps1.setInt(1, borrowId);
            ps1.executeUpdate();

            PreparedStatement ps2 = con.prepareStatement(
                "UPDATE books SET quantity = quantity + 1 WHERE id=?");
            ps2.setInt(1, bookId);
            ps2.executeUpdate();

            res.sendRedirect("borrowedUsers.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

