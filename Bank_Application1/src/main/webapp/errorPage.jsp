<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            color: #333;
            background-color: #f2f2f2;
            text-align: center;
            padding: 20px;
        }
        .message {
            border: 1px solid #d9534f;
            background-color: #f9d6d5;
            padding: 15px;
            display: inline-block;
            margin-top: 50px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="message">
        <h2>Error</h2>
        <p>${message}</p>
    </div>
</body>
</html>
