<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Deposit Page</title>
    <style>
        /* Navbar container styling */
        .navbar {
            background-color: #4A90E2;
            padding: 15px 20px;
            display: flex;
            align-items: center;
            color: black;
        }
        .navbar h1 {
            text-align: center;
            font-weight: bold;
            padding: 10px 0;
            border-bottom: 1px solid #000;
            flex-grow: 1; 
        }
        .deposit-box {
            width: 400px;
            border: 2px solid black;
            padding: 20px;
            text-align: left;
            margin: 20px auto; 
            border-radius: 5px;
        }
        .label {
            font-size: 18px;
            display: block; 
            margin-bottom: 10px; 
        }
        .input-field {
            font-size: 16px;
            padding: 5px;
            margin-right: 10px;
            width: calc(100% - 130px); 
            display: inline-block; 
        }
        .submit-button {
            font-size: 16px;
            padding: 5px 15px;
            display: inline-block; 
        }
        .form-group {
            display: flex; 
            align-items: center; 
            margin-bottom: 15px; 
        }
        .back-button {
            display: block;
            width: fit-content;
            margin: 20px auto;
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
    <div class="navbar">
        <h1>DEPOSIT</h1>
    </div>
    <form action="deposit" method="post">
        <div class="deposit-box">
            <div class="form-group">
                <label class="label" for="depositAmount">Enter the amount to deposit:</label>
                <input type="number" id="depositAmount" name="dep" class="input-field" placeholder="Enter amount" required />
                <input type="submit" value="OK" class="submit-button"/>
            </div>
        </div>
    </form>

   
    <a href="home.jsp" class="back-button">Back to Home</a>
</body>
</html>
