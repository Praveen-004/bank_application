package bank1;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.ProfileDao;

@WebServlet("/profile1")
public class ProfileProg extends HttpServlet { 
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfileDao pd=new ProfileDao();
        String email = req.getParameter("email");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("email".equals(cookie.getName())) {
                    email = cookie.getValue();
                    break;
                }
            }
        }

        if (email != null) {
            String[] profileData;
			try {
				profileData = pd.getUserProfileByEmail(email);
			     if (profileData != null) {
		                req.setAttribute("fullName", profileData[0]);
		                req.setAttribute("phoneNumber", profileData[1]);
		                req.setAttribute("accountNumber", profileData[2]);
		                req.setAttribute("age", profileData[3]);
		            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
       
        }

        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }
}


