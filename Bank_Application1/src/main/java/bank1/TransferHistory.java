package bank1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bank.dao.SaveUserDao;

@WebServlet("/transactionHis")
public class TransferHistory extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SaveUserDao userDao = new SaveUserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senderAccount = null;
        
        
        Cookie[] cookies1 = req.getCookies();
        
        if (cookies1 != null) {
            for (Cookie cookie1 : cookies1) {
                if ("sender_account".equals(cookie1.getName())) {
                    senderAccount = cookie1.getValue();
                    break;
                }
            }
        }

    
        if (senderAccount == null) {
            req.setAttribute("message", "No sender account found.");
            req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
            return;
        }

       
        long accountNo;
        try {
            accountNo = Long.parseLong(senderAccount);
        } catch (NumberFormatException e) {
            req.setAttribute("message", "Invalid sender account number.");
            req.getRequestDispatcher("errorPage.jsp").forward(req, resp);
            return;
        }

      
        List<String[]> transactionHistory;
        try {
            transactionHistory = userDao.getTransactionHistory(accountNo);
            req.setAttribute("transactionHistory", transactionHistory);
        } catch (SQLException e) {
            req.setAttribute("message", "Error retrieving transaction history.");
            e.printStackTrace(); 
            req.getRequestDispatcher("errorPage.jsp").forward(req, resp); 
            return;
        }
        
        
        req.getRequestDispatcher("TransactionHistory.jsp").forward(req, resp);
    }
}
