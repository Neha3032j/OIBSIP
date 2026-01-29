package com.exam;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        String u = req.getParameter("username");
        String p = req.getParameter("password");

        Connection con = DBConnection.getConnection();
        if (con == null) {
            res.getWriter().println("Database connection error");
            return;
        }
        try {
            PreparedStatement ps = con.prepareStatement(
              "SELECT * FROM users WHERE username=? AND password=?");
            ps.setString(1, u);
            ps.setString(2, p);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HttpSession s = req.getSession();
                s.setAttribute("user", u);
                res.sendRedirect("profile.jsp");
            } else {
                req.setAttribute("error", "Invalid Login");
                req.getRequestDispatcher("login.jsp").forward(req, res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
