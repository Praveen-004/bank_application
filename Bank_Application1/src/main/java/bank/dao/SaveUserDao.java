package bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mysql.cj.jdbc.Driver;
import bank.dto.Deposit;
import bank.dto.User;

public class SaveUserDao {
    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?createDatabaseIfNotExist=true", "root", "root");
    }

    public void createTable() throws SQLException {
        Connection con = createConnection();
        String createAccountTableSQL = "CREATE TABLE IF NOT EXISTS account ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "email VARCHAR(45), "
                + "account_No BIGINT(12), "
                + "fname VARCHAR(45), "
                + "lname VARCHAR(45), "
                + "password VARCHAR(45), "
                + "age INT, "
                + "phone BIGINT(10), "
                + "aadhar_No BIGINT(12), "
                + "balance BIGINT DEFAULT 0"
                + ")";
        
        String createTransactionTableSQL = "CREATE TABLE IF NOT EXISTS Transaction ("
                + "id INT PRIMARY KEY AUTO_INCREMENT, "
                + "sender_account_no BIGINT(12) NOT NULL, "
                + "recipient_account_no BIGINT(12) NOT NULL, "
                + "transfer_amount BIGINT NOT NULL, "
                + "transfer_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")";
        
        try (PreparedStatement psAccount = con.prepareStatement(createAccountTableSQL);
             PreparedStatement psTransaction = con.prepareStatement(createTransactionTableSQL)) {
            psAccount.execute();
            psTransaction.execute();
        } finally {
            con.close();
        }
    }

    public int insertUser(User user) throws SQLException {
        createTable(); 
        Connection con = createConnection();
        
        String insertSQL = "INSERT INTO account (email, account_No, fname, lname, password, age, phone, aadhar_No) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = con.prepareStatement(insertSQL)) {
            ps.setString(1, user.getEmail());
            ps.setLong(2, user.getAccountNo());
            ps.setString(3, user.getFname());
            ps.setString(4, user.getLname());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getAge());
            ps.setLong(7, user.getPhone());
            ps.setLong(8, user.getAadhar());

            return ps.executeUpdate();
        } finally {
            con.close();
        }
    }

    public int updateBalance(Deposit deposit, String email) throws SQLException {
        Connection con = createConnection();
        String updateBalanceSQL = "UPDATE account SET balance = balance + ? WHERE email = ?";
        
        try (PreparedStatement ps = con.prepareStatement(updateBalanceSQL)) {
            ps.setLong(1, deposit.getAmt());
            ps.setString(2, email);
            return ps.executeUpdate();
        } finally {
            con.close();
        }
    }

    public long balanceFetch(String email) throws SQLException {
        Connection con = createConnection();
        String balanceFetchSQL = "SELECT balance FROM account WHERE email=?";
        
        try (PreparedStatement ps = con.prepareStatement(balanceFetchSQL)) {
            ps.setString(1, email);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                return res.getLong("balance");
            }
        } finally {
            con.close();
        }
        return 0;
    }
    


    public boolean transferFunds(long senderAccountNo, long recipientAccountNo, long transferAmount) throws SQLException {
        Connection con = null;
        PreparedStatement psSenderBalance = null;
        PreparedStatement psRecipientBalance = null;
        PreparedStatement psUpdateSender = null;
        PreparedStatement psUpdateRecipient = null;
        PreparedStatement psTransactionLog = null;
        ResultSet rsSenderBalance = null;
        ResultSet rsRecipientBalance = null;

        try {
            con = createConnection();
            con.setAutoCommit(false); // Begin transaction

            // Get sender's balance
            String getSenderBalanceQuery = "SELECT balance FROM account WHERE account_No = ?";
            psSenderBalance = con.prepareStatement(getSenderBalanceQuery);
            psSenderBalance.setLong(1, senderAccountNo);
            rsSenderBalance = psSenderBalance.executeQuery();

            if (!rsSenderBalance.next() || rsSenderBalance.getLong("balance") < transferAmount) {
                System.out.println("Insufficient balance or sender account not found.");
                return false;
            }

            long senderBalance = rsSenderBalance.getLong("balance");

            // Get recipient's balance
            String getRecipientBalanceQuery = "SELECT balance FROM account WHERE account_No = ?";
            psRecipientBalance = con.prepareStatement(getRecipientBalanceQuery);
            psRecipientBalance.setLong(1, recipientAccountNo);
            rsRecipientBalance = psRecipientBalance.executeQuery();

            if (!rsRecipientBalance.next()) {
                System.out.println("Recipient account not found.");
                return false;
            }

            long recipientBalance = rsRecipientBalance.getLong("balance");

            // Update balances
            long newSenderBalance = senderBalance - transferAmount;
            long newRecipientBalance = recipientBalance + transferAmount;

            // Update sender's balance
            String updateSenderQuery = "UPDATE account SET balance = ? WHERE account_No = ?";
            psUpdateSender = con.prepareStatement(updateSenderQuery);
            psUpdateSender.setLong(1, newSenderBalance);
            psUpdateSender.setLong(2, senderAccountNo);
            psUpdateSender.executeUpdate();

            // Update recipient's balance
            String updateRecipientQuery = "UPDATE account SET balance = ? WHERE account_No = ?";
            psUpdateRecipient = con.prepareStatement(updateRecipientQuery);
            psUpdateRecipient.setLong(1, newRecipientBalance);
            psUpdateRecipient.setLong(2, recipientAccountNo);
            psUpdateRecipient.executeUpdate();

            // Log the transaction
            String transactionLogQuery = "INSERT INTO Transaction (sender_account_no, recipient_account_no, transfer_amount) VALUES (?, ?, ?)";
            psTransactionLog = con.prepareStatement(transactionLogQuery);
            psTransactionLog.setLong(1, senderAccountNo);
            psTransactionLog.setLong(2, recipientAccountNo);
            psTransactionLog.setLong(3, transferAmount);
            psTransactionLog.executeUpdate();

            con.commit(); // Commit transaction
            System.out.println("Transfer successful.");
            return true;

        } catch (SQLException e) {
            if (con != null) con.rollback(); // Rollback on failure
            e.printStackTrace();
            return false;
        } finally {
            // Clean up resources
            if (rsSenderBalance != null) rsSenderBalance.close();
            if (psSenderBalance != null) psSenderBalance.close();
            if (rsRecipientBalance != null) rsRecipientBalance.close();
            if (psRecipientBalance != null) psRecipientBalance.close();
            if (psUpdateSender != null) psUpdateSender.close();
            if (psUpdateRecipient != null) psUpdateRecipient.close();
            if (psTransactionLog != null) psTransactionLog.close();
            if (con != null) con.close();
        }
    }
    
    public List<String[]> getTransactionHistory(long accountNo) throws SQLException {
        List<String[]> transactionHistory = new ArrayList<>();
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "root"; 

     
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT sender_account_no, recipient_account_no, transfer_amount, transfer_date " +
                           "FROM transaction WHERE sender_account_no = ?";

            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setLong(1, accountNo);
                ResultSet rs = stmt.executeQuery();

               
                while (rs.next()) {
                    
                    String senderAccount = String.valueOf(rs.getLong("sender_account_no"));
                    String recipientAccount = String.valueOf(rs.getLong("recipient_account_no"));
                    String transferAmount = String.valueOf(rs.getLong("transfer_amount"));
                    String transferDate = rs.getDate("transfer_date").toString(); // Convert Date to String

                 
                    transactionHistory.add(new String[] { senderAccount, recipientAccount, transferAmount, transferDate });
                }
            }
        } catch (SQLException e) {
           
            e.printStackTrace();
            throw e; 
        }

        return transactionHistory;
    }

 public int deleteAccount(String email) throws SQLException
 {
	 Connection con = createConnection();
     PreparedStatement ps=con.prepareStatement("delete from account where email=?");
     ps.setString(1, email);
    int a= ps.executeUpdate();
	 ps.close();
	 con.close();
	 return a;
 }

    
  
}
