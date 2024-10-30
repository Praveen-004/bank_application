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

@WebServlet("/balance")
public class BalanceDisplay extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        try {
            long balance = su.balanceFetch(email);
            req.setAttribute("balance", balance);
            req.getSession().setAttribute("balanceViewed", true); 
            RequestDispatcher rd = req.getRequestDispatcher("balance.jsp");
            rd.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Database error while fetching balance.");
            RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
            rd.forward(req, resp);
        }
    }
}


