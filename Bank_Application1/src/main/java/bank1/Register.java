package bank1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.SaveUserDao;
import bank.dto.User;

@WebServlet("/register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String aa = req.getParameter("aadhar");
		String ph = req.getParameter("phone");
		String a = req.getParameter("age");

		
		int age = 0;
		long phone = 0;
		long aadhar = 0;
		try {
			age = Integer.parseInt(a);
			phone = Long.parseLong(ph);
			aadhar = Long.parseLong(aa);
		} catch (NumberFormatException e) {
			req.setAttribute("errorMessage", "Invalid input for age, phone, or aadhar number.");
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.include(req, resp);
			return;
		}

		User user = new User(fname, lname, pwd, email, age, phone, aadhar);
		SaveUserDao sud = new SaveUserDao();
		
		try {
			int result = sud.insertUser(user);
			if (result > 0) {
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("errorMessage", "Registration failed. Please try again.");
				RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
				rd.include(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			req.setAttribute("errorMessage", "Database error. Please try again later.");
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.include(req, resp);
		}
	}
}
