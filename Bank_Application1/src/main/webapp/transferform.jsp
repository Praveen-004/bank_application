<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transfer Funds</title>
    <style>
        body {
            background-color: #f0f8ff; /* Light background */
            font-family: Arial, sans-serif;
        }
        .header {
            background-color: #4A90E2;
            padding: 20px;
            text-align: center;
            font-size: 24px;
            color: white;
            font-weight: bold;
        }
        .container {
            background-color: lightblue;
            padding: 30px;
            border-radius: 20px;
            width: 400px;
            margin: 50px auto;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        h1 {
            color: #000;
            font-size: 22px;
            margin-bottom: 15px;
        }
        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }
        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        button {
            width: 100%;
            padding: 10px;
            background-color: #4A90E2;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #357ABD;
        }
    </style>
</head>
<body>
    <div class="header">
        Transfer Funds
    </div>
    <div class="container">
        <form action="transfer" method="post">
            <div class="form-group">
                <label for="senderAccountNo">Sender Account No:</label>
                <input type="text" id="senderAccountNo" name="senderAccountNo" required>
            </div>
            <div class="form-group">
                <label for="recipientAccountNo">Recipient Account No:</label>
                <input type="text" id="recipientAccountNo" name="recipientAccountNo" required>
            </div>
            <div class="form-group">
                <label for="amount">Amount:</label>
                <input type="number" id="amount" name="amount" step="0.01" min="0" required>
            </div>
            <button type="submit">Transfer</button>
        </form>
    </div>
</body>
</html>
