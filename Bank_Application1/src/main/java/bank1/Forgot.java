package bank1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

@WebServlet("/forgot")
public class Forgot extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ps1=req.getParameter("ps1");
		String ps2=req.getParameter("ps2");
		String email=req.getParameter("email");
		if(ps1.equals(ps2))
		{
			try {
				DriverManager.registerDriver(new Driver());
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?user=root&password=root");
				PreparedStatement ps=con.prepareStatement("UPDATE account SET password = ? WHERE email=?");
				ps.setString(1, ps2);
				ps.setString(2, email);
				ps.execute();
				RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else
		{
			System.out.println("Incorrect Password");
			RequestDispatcher rd=req.getRequestDispatcher("forgotPwd.jsp");
			rd.include(req, resp);
		}
		
	}
}
