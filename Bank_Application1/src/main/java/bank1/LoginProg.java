package bank1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;

@WebServlet("/login")
public class LoginProg extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try {
            // Register JDBC driver and establish a connection
            DriverManager.registerDriver(new Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?user=root&password=root");

            // Prepare SQL statement
            PreparedStatement ps = con.prepareStatement("SELECT * FROM account WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Check password
                if (rs.getString("password").equals(password)) {
                    // Set cookie for email
                	String s=null;
                	s=String.valueOf(rs.getLong("account_No"));
                    Cookie cookie = new Cookie("email", email);
                    res.addCookie(cookie);
                    
                    Cookie cookie1= new Cookie("sender_account", s);
                    res.addCookie(cookie1);
                    
                    
                    // Forward to home page upon successful login
                    RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
                    rd.forward(req, res);
                } else {
                    // Password incorrect
                    req.setAttribute("errorMessage", "Incorrect password. Please try again.");
                    RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                    rd.include(req, res);
                }
            } else {
                // Email not found
                req.setAttribute("errorMessage", "Email not registered. Please check and try again.");
                RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
                rd.include(req, res);
            }

            // Close resources
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "Database error occurred. Please try again later.");
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.include(req, res);
        }
    }
}
