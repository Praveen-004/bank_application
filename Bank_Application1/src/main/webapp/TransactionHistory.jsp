<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transaction History</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 60%;
            margin: 50px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #dddddd;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        .message {
            text-align: center;
            margin-top: 20px;
            color: red;
        }

        .back-button {
            display: block;
            width: fit-content;
            margin: 30px auto;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-align: center;
            border-radius: 5px;
            text-decoration: none;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Transaction History</h1>

        <table>
            <thead>
                <tr>
                    <th>Sender Account No</th>
                    <th>Recipient Account No</th>
                    <th>Transfer Amount</th>
                    <th>Transfer Date</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<String[]> transactionHistory = (List<String[]>) request.getAttribute("transactionHistory");
                    if (transactionHistory != null && !transactionHistory.isEmpty()) {
                        for (String[] transaction : transactionHistory) {
                %>
                    <tr>
                        <td><%= transaction[0] %></td>
                        <td><%= transaction[1] %></td>
                        <td><%= transaction[2] %></td>
                        <td><%= transaction[3] %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="4" style="text-align: center;">No transaction history found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <div class="message">
            <%
                String message = (String) request.getAttribute("message");
                if (message != null && !message.isEmpty()) {
            %>
                <p><%= message %></p>
            <%
                }
            %>
        </div>

      
        <a href="home.jsp" class="back-button">Back to Home</a>
    </div>
</body>
</html>
