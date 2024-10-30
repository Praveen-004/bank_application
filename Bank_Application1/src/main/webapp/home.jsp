<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
    <style>
        * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body {
    background-color: #f4f4f4;
    overflow: hidden;
}

/* Header Navigation Bar */
header {
    background-color: royalblue;
    color: white;
    /* padding: 15px 20px; */
    display: flex;
    justify-content: space-between;
    align-items: center;
}
navbar
{
    background-color: #5096f8;
    color: white;
    padding: 15px 50px;
    display: flex;
    justify-content: space-between;
    align-items: center; 
}

.logo {
    font-size: 30px;
    font-weight: bold;
    text-decoration: none;
    color: white;
    margin-left: 40px;
}

nav ul {
    list-style: none;
    display: flex;
    gap: 100px;
}

nav a {
    color: white;
    text-decoration: none;
    font-size: 16px;
}

nav a:hover {
    text-decoration: underline;
}
.navbar {
    overflow: hidden;
    background-color: rgb(108, 137, 226);
    width: 100%;
    height: 60px;
  }
  
  .navbar a {
    float: left;
    font-size: 20px;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
  }
  
  .dropdown {
    float: left;
    overflow: hidden;
  }
  
  .dropdown .dropbtn {
    font-size: 20px;  
    border: none;
    outline: none;
    color: white;
    padding: 14px 16px;
    background-color: inherit;
    font-family: inherit;
    margin-left: 20px;
  }
  
  .navbar a:hover, .dropdown:hover .dropbtn {
    background-color: royalblue;
  }
  
  .dropdown-content {
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(155, 223, 250, 0.973);
    z-index: 1;
    opacity: 0.8;
    margin-left: 20px;
  }
  
  .dropdown-content a {
    float: none;
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
  }
  
  .dropdown-content a:hover {
    background-color:#bce6fad5;
  }
  
  .dropdown:hover .dropdown-content {
    display: block;
  }
  .submit {
        border: none;
        outline: none;
        background-color: royalblue;
        padding: 10px;
        border-radius: 10px;
        margin-left: 40%;
        margin-top: 10px;
        color: #fff;
        font-size: 16px;
        transform: .3s ease;
      }
      
      .submit:hover {
        background-color: rgb(56, 90, 194);
        cursor: pointer;
      }
      .image img
      {
        width: 100%;
        height: 700px;
        opacity: 0.8;

      }
      .dropbtn img
      {
        width: 50px;
        height: 50px;
        margin-right: 80px;
      }
            /* Hero Section */
      .hero {
            height: 80vh;
            background-image: url(./loan.jpg); /* Replace with your image */
            background-size: cover;
            background-position: center;
            display: flex;
            justify-content: center;
            align-items: center;
            color: white;
            text-align: center;
            opacity: 1;

        }

        .hero h1 {
            font-size: 48px;
            margin-bottom: 10px;
        }

        .hero p {
            font-size: 20px;
            margin-bottom: 120px;
        }
        /* Footer Section */
        footer {
            background-color: #0047ab;
            color: white;
            text-align: center;
            padding: 10px;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        .footer-link {
            color: #ffcc00;
            text-decoration: none;
        }

        .footer-link:hover {
            text-decoration: underline;
        }
    </style>
<body>
<header>
        <a href="Home.jsp" class="logo">Bank of Friends</a>
        <div class="dropdown">
          <button class="dropbtn"><img src="./profile.png" alt=""> 
            <i class="fa-solid fa-user"></i>
          </button>
          <div class="dropdown-content">
            <a href="profile1">Profile</a>
            <a href="delete.jsp">Delete Account</a>
          </div>
        </div> 
        
        

    </header>
    <div class="navbar">
        <div class="dropdown">
          <button class="dropbtn">Accounts 
            <i class="fa fa-caret-down"></i>
          </button>
          <div class="dropdown-content">
            <a href="balance.jsp">Balance</a>
          </div>
        </div> 
        <div class="dropdown">
            <button class="dropbtn">Transactions 
              <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
              <a href="deposit.jsp">Deposit</a>
              <a href="transferform.jsp">Transfer Funds</a>
              <a href="transactionHis">Transaction History</a>
            </div>
          </div> 
          <div class="dropdown">
            <button class="dropbtn">Password Management
              <i class="fa fa-caret-down"></i>
            </button>
            <div class="dropdown-content">
              <a href="forgotPwd.jsp">Change Password</a>
            </div>
          </div> 
          <form action="logout" method="post">
          <input type="submit" value="Logout" class="submit">
          </form>
      </div>
    <!--    <div class="image">
        <img src="./loan.jpg" alt="">
      </div> 
       <!-- Hero Section -->
    <section class="hero">
      <div>
          <h1>Welcome to Bank of Friends</h1>
          <p>Your Trusted Partner in Banking and Finance</p>
      </div>
    </section>
    <footer>
      <p>&copy; 2024 Bank of Friends. All rights reserved. | <a href="#" class="footer-link">Privacy Policy</a></p>
  </footer>
</body>
</html>