package com.library;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AdminLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        String u = req.getParameter("username");
        String p = req.getParameter("password");

        Connection con = DBConnection.getConnection();
        PreparedStatement ps;

        try {
            ps = con.prepareStatement(
                "SELECT * FROM admin WHERE username=? AND password=?");
            ps.setString(1, u);
            ps.setString(2, p);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                req.getSession().setAttribute("admin", u);
                res.sendRedirect("adminDashboard.jsp");
            } else {
                res.getWriter().println("Invalid Admin Login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
