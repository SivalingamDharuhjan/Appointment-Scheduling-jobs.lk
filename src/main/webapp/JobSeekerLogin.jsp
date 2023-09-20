<%-- 
    Document   : MultiUserLogin.jsp
    Created on : 10-Aug-2023, 18:28:53
    Author     :  DELL
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Jobs.lk | MultiUserLogin</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f7f9fb;
            }
            header {
                background-color: #007bff;
                color: white;
                padding: 10px;
                text-align: center;
            }
            .container {
                max-width: 1200px;
                margin: 0 auto;
                padding: 20px;
            }
            .navbar {
                background-color: white;
                overflow: hidden;
            }
            .navbar a {
                float: right;
                display: block;
                color: black;
                text-align: center;
                padding: 25px 13px;
                text-decoration: none
            }
            .navbar a:hover {
                background-color: #ddd;
                color: black;
            }
            .section {
                padding: 20px;
                border: 1px solid #ddd;
                margin: 20px 0;
                background-color: white;
            }
            .section h2 {
                margin-top: 0;
            }
            footer {
                text-align: center;
                padding: 10px;
                background-color: #333;
                color: white;
            }
            .login-button:hover {
                background-color: #b62d23;
            }

            * Full-width input fields *
            input[type=text], input[type=password] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                box-sizing: border-box;
            }

            /* Set a style for all buttons */
            button {
                float: right;
                background-color: #b62d23;
                color: white;
                border: none;
                border-radius:12px;
                padding: 10px 20px;
                margin: 14px 16px;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                cursor: pointer;
            }

            button:hover {
                opacity: 0.8;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
                width: auto;
                padding: 10px 18px;
                background-color: #f44336;
            }




            .container {
                padding: 66px;
            }

            span.psw {
                float: right;
                padding-top: 16px;
            }

            /* The Modal (background) */
            .modal {
                display: none; /* Hidden by default */
                position: fixed; /* Stay in place */
                z-index: 1; /* Sit on top */
                left: 0;
                top: 0;
                width: 100%; /* Full width */
                height: 100%; /* Full height */
                overflow: auto; /* Enable scroll if needed */
                background-color: rgb(0,0,0); /* Fallback color */
                background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                padding-top: 60px;
            }

            /* Modal Content/Box */
            .modal-content {
                background-color: #fefefe;
                margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                border: 1px solid #888;
                width: 80%; /* Could be more or less, depending on screen size */
            }

            /* The Close Button (x) */
            .close {
                position: absolute;
                right: 25px;
                top: 0;
                color: #000;
                font-size: 35px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: red;
                cursor: pointer;
            }

            /* Add Zoom Animation */
            .animate {
                -webkit-animation: animatezoom 0.6s;
                animation: animatezoom 0.6s
            }

            @-webkit-keyframes animatezoom {
                from {
                    -webkit-transform: scale(0)
                }
                to {
                    -webkit-transform: scale(1)
                }
            }

            @keyframes animatezoom {
                from {
                    transform: scale(0)
                }
                to {
                    transform: scale(1)
                }
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
                span.psw {
                    display: block;
                    float: none;
                }
                .cancelbtn {
                    width: 100%;
                }
            }
            button {

                color: white;
                border: none;
                padding: 10px 20px;
                border-radius: 5px;
                cursor: pointer;
            }
            .signin {
                background-color: #28a745;
            }
            label {
                display: block;
                margin-bottom: 5px;
            }
            /*Style for - Please Login First. Body/.custom-container*/
            input[type="email"],
            input[type="password"] {
                width: 100%;
                padding: 12px 20px;
                margin: 8px 0;
                display: inline-block;
                border: 1px solid #ccc;
                border-radius: 10px;
                box-sizing: border-box;
            }
            .create-account-button
            {

                padding: 10px 20px;
                margin: 10px 0;
                text-align: center;
                text-decoration: none;
                display: inline-block;
                font-size: 14px;
                cursor: pointer;
                width: 100%;
            }

            .create-account-button {
                color: #28a745;
                border: 2px solid #28a745;
                border-radius: 5px;
                cursor: pointer;
                color: darkcyan;
                margin-top: 10px;
                background-color: white;

            }
            /*Style for - Please Login First. Body/.custom-container*/
            .custom-container {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 5vh;
                background-color: #3a34eb;
            }

            .login-box {
                height: 60px;
                width: 1465px;
                display: flex;
                justify-content: center;
                align-items: center;
                font-size: 18px;
                color: white;
                font-family: 'Roboto';
            }
            /*Style for - MultiUser-Login. Body/.MultiUser-Login*/
            .MultiUser-Login {
                font-family: 'Roboto', sans-serif;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;

            }

            .form-container {
                margin-bottom:10%;
                background-color: white;
                width: 30%;
                padding: 20px;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            .form-group {
                margin-bottom: 15px;
            }

            .form-label {
                display: block;
                font-weight: bold;
                margin-bottom: 5px;
            }

            .form-input {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            .form-button {
                background-color: lightseagreen;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 3px;
                cursor: pointer;
                text-align: center;
                width: 90%;

            }

            .form-link {
                text-decoration: none;
                color: blue;
            }

            /*Style for - FogotPassword-button. Body/..form-link-button*/
            .form-link-button {
                text-decoration: none;
                background-color: transparent;
                color: blue;
                padding: 10px 145px;
                border: none;
                border-radius: 3px;
                cursor: pointer;
                text-align: center;
                width: 90%;
                font-family:"poppins";
            }
        </style>
    </head>

</head>
<body>

    <div class="navbar">
        <button onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Register/SignIn</button>
        <a href="Home.jsp">About Us</a>
        <a href="Home.jsp">Home</a>  
    </div>
</script>

<div class="custom-container">
    <div class="login-box">
        Job Seeker Login
    </div>
</div>

<div class="MultiUser-Login">
    <div class="form-container">
        <form action="Jobseekerservlet" method="post">
            <div class="form-group">
                <label class="form-label" for="email">E-mail:</label>
                <input class="form-input" type="email" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label class="form-label" for="password">Password:</label>
                <input class="form-input" type="password" id="password" name="password" required>
            </div>

            <button class="form-button" type="submit">Login</button><br>
            <a class="form-link-button" href="JobseekerSignup.jsp">go to SignUp</a><br>
            <br>

            
        </form>
    </div>
</div>




</body>
</html>
