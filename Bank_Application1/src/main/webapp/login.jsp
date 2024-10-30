<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
     <style>
       * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            background-color: #f4f4f4;
        }

       
        header {
            background-color: #0047ab;
            color: white;
            padding: 15px 50px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .logo {
            font-size: 28px;
            font-weight: bold;
            text-decoration: none;
            color: white;
        }

        nav ul {
            list-style: none;
            display: flex;
            gap: 20px;
        }

        nav a {
            color: white;
            text-decoration: none;
            font-size: 16px;
        }

        nav a:hover {
            text-decoration: underline;
        }
    .form {
        display: flex;
        flex-direction: column;
        gap: 10px;
        max-width: 350px;
        background-color: #bce6fad5;
        margin-top: 120px;
        margin-left: 550px;
        padding: 20px;
        border-radius: 20px;
        position: relative;
      }
      
      .title {
        font-size: 28px;
        color: royalblue;
        font-weight: 600;
        letter-spacing: -1px;
        position: relative;
        display: flex;
        align-items: center;
        padding-left: 30px;
      }
      
      .message, .signin {
        color: rgba(88, 87, 87, 0.822);
        font-size: 14px;
      }
      
      .signin {
        text-align: center;
      }
      
      .signin a {
        color: royalblue;
      }
      
      .signin a:hover {
        text-decoration: underline royalblue;
      }
      .forgot a
      {
        color: royalblue;
        text-decoration: underline;
      }
      
      .flex {
        display: flex;
        width: 100%;
        gap: 6px;
      }
      
      .form label {
        position: relative;
      }
      
      .form label .input {
        width: 95%;
        padding: 10px 10px 20px 10px;
        outline: 0;
        border: 1px solid rgba(105, 105, 105, 0.397);
        border-radius: 10px;
      }
      
      .form label .input + span {
        position: absolute;
        left: 10px;
        top: 15px;
        color: grey;
        font-size: 0.9em;
        cursor: text;
        transition: 0.3s ease;
      }
      
      .form label .input:placeholder-shown + span {
        top: 15px;
        font-size: 0.9em;
      }
      
      .form label .input:focus + span,.form label .input:valid + span {
        top: 0px;
        font-size: 0.7em;
        font-weight: 600;
      }
      
      .form label .input:valid + span {
        color: green;
      }
      
      .submit {
        border: none;
        outline: none;
        background-color: royalblue;
        padding: 10px;
        border-radius: 10px;
        color: #fff;
        font-size: 16px;
        transform: .3s ease;
      }
      
      .submit:hover {
        background-color: rgb(56, 90, 194);
        cursor: pointer;
      }
     
      </style>
</head>
<body>
<header>
    <a href="Home.jsp" class="logo">Bank Of Friends</a>
    <nav>
        <ul>
            <li>About Us</li>
        </ul>
    </nav>
</header>
    <form class="form" action="login" method="post">
        <p class="title">Login In</p>

        <label>
            <input class="input" type="email" placeholder="" required name="email">
            <span>Email</span>
        </label> 
            
        <label>
            <input class="input" type="password" placeholder="" required name="password">
            <span>Password</span>
        </label>
        <a href="forgotPwd.jsp">forgot password</a>
        <button class="submit">Submit</button>
        <p class="signin">Create New Account ? <a href="register.jsp">SignUp</a> </p>
    </form>
</body>
</html>