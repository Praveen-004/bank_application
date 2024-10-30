package bank1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.SaveUserDao;

@WebServlet("/transfer")
public class TransferFunds extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SaveUserDao userDao = new SaveUserDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long senderAccountNo = Long.parseLong(request.getParameter("senderAccountNo"));
        long recipientAccountNo = Long.parseLong(request.getParameter("recipientAccountNo"));
        long transferAmount = Long.parseLong(request.getParameter("amount"));
        

        try {
            boolean success = userDao.transferFunds(senderAccountNo, recipientAccountNo, transferAmount);
            if (success) {
                
                request.setAttribute("message", "Transfer successful.");
                
            } else {
                request.setAttribute("message", "Transfer failed. Please check the details and try again.");
            }
            request.getRequestDispatcher("TransferResult.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "An error occurred. Please try again later.");
            request.getRequestDispatcher("transferResult.jsp").forward(request, response);
        }
    }
}
