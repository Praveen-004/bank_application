package bank1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.SaveUserDao;
import bank.dto.Deposit;

@WebServlet("/deposit")
public class DepositBal extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String d = req.getParameter("dep");
        long depo;

        // Validate input
        if (d == null || d.isEmpty()) {
            req.setAttribute("errorMessage", "Please enter a valid amount.");
            RequestDispatcher rd = req.getRequestDispatcher("deposit.jsp");
            rd.forward(req, resp);
            return;
        }

        try {
            depo = Long.parseLong(d);
        } catch (NumberFormatException e) {
            req.setAttribute("errorMessage", "Invalid amount entered.");
            RequestDispatcher rd = req.getRequestDispatcher("deposit.jsp");
            rd.forward(req, resp);
            return;
        }

        Deposit deposit = new Deposit(depo);
        SaveUserDao su = new SaveUserDao();
        String email = null;

        // Retrieve email from cookies
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("email".equals(cookie.getName())) {
                    email = cookie.getValue();
                    break;
                }
            }
        }

        // Check if email is found
        if (email != null) {
            try {
                // Update the balance using the email from the cookie
                int isUpdated = su.updateBalance(deposit, email);
                
                if (isUpdated>0) {
                    // Redirect to home page after successful deposit
                    resp.sendRedirect("home.jsp");
                } else {
                    req.setAttribute("errorMessage", "Failed to update balance. Please try again.");
                    RequestDispatcher rd = req.getRequestDispatcher("deposit.jsp");
                    rd.forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                req.setAttribute("errorMessage", "Database error while updating balance.");
                RequestDispatcher rd = req.getRequestDispatcher("deposit.jsp");
                rd.forward(req, resp);
            }
        } else {
            req.setAttribute("errorMessage", "User not logged in. Please log in again.");
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
        }
    }
}
