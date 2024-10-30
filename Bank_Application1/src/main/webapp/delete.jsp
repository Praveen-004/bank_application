<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Account</title>
    <style>
        body {
            background-color: #f0f8ff; 
            font-family: Arial, sans-serif;
        }
        .header {
            background-color: #E74C3C;
            padding: 20px;
            text-align: center;
            font-size: 24px;
            color: white;
            font-weight: bold;
        }
        .form-container {
            background-color: lightblue; 
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
        .button {
            padding: 10px 20px;
            font-size: 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px;
            text-decoration: none; 
            display: inline-block; 
        }
        .delete-button {
            background-color: #E74C3C; 
            color: white;
        }
        .delete-button:hover {
            background-color: #C0392B;
        }
        .cancel-button {
            background-color: #4A90E2; 
            color: white;
        }
        .cancel-button:hover {
            background-color: #357ABD; 
        }
    </style>
</head>
<body>
    <div class="header">
        Confirm Account Deletion
    </div>
    <div class="form-container">
        <h2>Are you sure you want to delete your account?</h2>
        <form action="deleteAccount" method="post"> 
            <input type="hidden" name="email" value="<%= request.getParameter("email") %>"/> 
            <button type="submit" class="button delete-button">Delete Account</button>
        </form>
        <a href="home.jsp" class="button cancel-button">Cancel</a> 
    </div>
</body>
</html>
