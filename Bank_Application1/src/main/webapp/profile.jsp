<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile Page</title>
    <style>
        body {
            background-color: #f0f8ff; /* Light background color */
            font-family: Arial, sans-serif;
        }
        .header {
            background-color: #4A90E2; /* Blue background */
            padding: 20px;
            text-align: center;
            font-size: 24px;
            color: white;
            font-weight: bold;
        }
        .form-container {
            background-color: lightblue; /* Light blue form container */
            padding: 30px;
            border-radius: 20px;
            width: 400px;
            margin: 50px auto;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        .form-container h2 {
            color: #000;
            font-size: 22px;
            margin-bottom: 15px;
        }
        .profile-field {
            margin-bottom: 15px;
            font-size: 18px;
        }
        .label {
            font-weight: bold;
            color: #333;
        }
        .value {
            color: #000;
        }
        .button {
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #4A90E2;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            margin: 5px; /* Space between buttons */
        }
        .button:hover {
            background-color: #357ABD;
        }
    </style>
    <script>
        function refreshPage() {
            location.reload(); // Refresh the page
        }
    </script>
</head>
<body>

<%--<% 
    // Assuming 'user' is an object of type User set in request scope
    ProfileProg profile = (ProfileProg ) request.getAttribute("profileData");
%>

<div class="profile">
    <h2>User Profile</h2>
    <p><strong>Name:</strong> <%= profile %></p>
    <p><strong>Account Number:</strong> <%= user.getAccountNumber() %></p>
    <p><strong>Address:</strong> <%= user.getAddress() %></p>
    <p><strong>Balance:</strong> $<%= user.getBalance() %></p>
</div> --%>
	<form action="profile1" method="post">
    <div class="header">
        Profile Information
    </div>
    <div class="form-container">
        <h2>Your Details</h2>
        <div class="profile-field">
            <span class="label">Full Name:</span> 
            <span class="value"><%= request.getAttribute("fullName") %></span>
        </div>
        <div class="profile-field">
            <span class="label">Phone Number:</span> 
            <span class="value"><%= request.getAttribute("phoneNumber") %></span>
        </div>
        <div class="profile-field">
            <span class="label">Account Number:</span> 
            <span class="value"><%= request.getAttribute("accountNumber") %></span>
        </div>
        <div class="profile-field">
            <span class="label">Age:</span> 
            <span class="value"><%= request.getAttribute("age") %></span>
        </div>
        
        <a href="home.jsp" class="button">Back to Home</a>
       
    </div>
    </form>
     
</body>
</html>
