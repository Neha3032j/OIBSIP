package com.library;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?");
            ps.setString(1, email);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                req.getSession().setAttribute("userId", rs.getInt("id"));
                res.sendRedirect("userDashboard.jsp");
            } else {
                res.getWriter().println("Invalid User Login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
