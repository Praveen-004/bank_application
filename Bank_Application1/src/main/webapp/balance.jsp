<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Balance Page</title>
    <style>
        .navbar {
            background-color: #4A90E2;
            padding: 15px 20px;
            display: flex;
            align-items: center;
            color: black;
            text-align: center;
            font-weight: bold;
            font-size: 30px;
            border-bottom: 1px solid #000;
        }
        .balance-box {
            width: 400px;
            border: 2px solid black;
            padding: 20px;
            text-align: left;
            font-size: 18px;
            margin: 20px auto; 
        }
        .input-field {
            font-size: 16px;
            padding: 5px;
            margin-right: 10px;
            width: 150px;
        }
        .submit-button {
            font-size: 16px;
            padding: 5px 15px;
            display: inline-block; 
            margin-top: 10px; 
        }
        .button-container {
            text-align: center; 
            margin-top: 20px; 
        }
    </style>
</head>
<body>
<%
    Long balance = (Long) request.getAttribute("balance");
    Boolean balanceViewed = (Boolean) request.getSession().getAttribute("balanceViewed");
%>

<div class="navbar">
    <h1>BALANCE</h1>
</div>

<div class="balance-box">
    <label for="balance">Available amount in your account:</label>
    <span id="balance" class="input-field"><%= balance != null ? balance : 0 %></span>
</div>

<div class="button-container">
    <form action="<%= balanceViewed != null && balanceViewed ? "home.jsp" : "balance" %>" method="post">
        <input type="submit" value="<%= balanceViewed != null && balanceViewed ? "Go to Home" : "OK" %>" class="submit-button"/>
    </form>
</div>

<%
    if (balanceViewed != null && balanceViewed) {
        request.getSession().removeAttribute("balanceViewed");
    }
%>

</body>
</html>
