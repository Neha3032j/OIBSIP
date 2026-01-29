package com.exam;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ExamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        int score = 0;

        if ("Language".equals(req.getParameter("q1"))) score++;
        if ("Java Server Pages".equals(req.getParameter("q2"))) score++;

        req.setAttribute("score", score);
        req.getRequestDispatcher("result.jsp").forward(req, res);
    }
}
