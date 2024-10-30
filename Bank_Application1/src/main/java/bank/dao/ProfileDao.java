package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ProfileDao {
	  public Connection createConnection() throws SQLException {
	        DriverManager.registerDriver(new Driver());
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?createDatabaseIfNotExist=true", "root", "root");
	    }
	  public String[] getUserProfileByEmail(String email) throws SQLException {
		  Connection con=createConnection();
		    String[] profileData = new String[4]; 
		    String query = "SELECT * FROM account WHERE email = ?";
		    PreparedStatement ps=con.prepareStatement(query);
		    ps.setString(1, email);
		    try (ResultSet rs = ps.executeQuery()) {
		        if (rs.next()) {
		      
		            System.out.println("Retrieved Data: " + rs.getString("lname") + ", " + rs.getString("fname") + ", " + rs.getLong("phone") + ", " + rs.getLong("account_No") + ", " + rs.getInt("age"));
		            
		            profileData[0] = rs.getString("lname") + " " + rs.getString("fname"); 
		            profileData[1] = String.valueOf(rs.getLong("phone"));
		            profileData[2] = String.valueOf(rs.getLong("account_No")); 
		            profileData[3] = String.valueOf(rs.getInt("age")); 
		        } else {
		            System.out.println("No user found with email: " + email);
		            return null; 
		        }
		    }
 catch (SQLException e) {
		        e.printStackTrace();
		        return null; 
		    }
		    
		    return profileData; 
		}

}
