package com.game;

import java.io.IOException;
import java.util.Random;
import javax.servlet.*;
import javax.servlet.http.*;

public class GuessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        String action = req.getParameter("action");

        // 🔹 START NEW GAME
        if ("start".equals(action)) {
            Random rand = new Random();
            int number = rand.nextInt(100) + 1;

            session.setAttribute("number", number);
            session.setAttribute("attempts", 10);
            session.setAttribute("score", 100);

            req.setAttribute("message", "Game Started!");
            req.setAttribute("attempts", 10);

            RequestDispatcher rd = req.getRequestDispatcher("game.jsp");
            rd.forward(req, res);
            return;
        }

        // 🔹 PROCESS GUESS
        int guess = Integer.parseInt(req.getParameter("guess"));
        int number = (int) session.getAttribute("number");
        int attempts = (int) session.getAttribute("attempts");
        int score = (int) session.getAttribute("score");

        attempts--;
        score -= 10;

        session.setAttribute("attempts", attempts);
        session.setAttribute("score", score);

        if (guess == number) {
            req.setAttribute("result", "🎉 Correct! You Won!");
            req.setAttribute("score", score);
            req.getRequestDispatcher("result.jsp").forward(req, res);

        } else if (attempts == 0) {
            req.setAttribute("result", "❌ Game Over! Number was " + number);
            req.setAttribute("score", 0);
            req.getRequestDispatcher("result.jsp").forward(req, res);

        } else {
            String msg = (guess > number) ? "Too High!" : "Too Low!";
            req.setAttribute("message", msg);
            req.setAttribute("attempts", attempts);
            req.getRequestDispatcher("game.jsp").forward(req, res);
        }
    }
}
