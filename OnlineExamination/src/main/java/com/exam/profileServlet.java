package com.exam;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class profileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        HttpSession s = req.getSession();
        String user = (String) s.getAttribute("user");

        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
              "UPDATE users SET email=?, password=? WHERE username=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ps.setString(3, user);
            ps.executeUpdate();
            res.sendRedirect("profile.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

