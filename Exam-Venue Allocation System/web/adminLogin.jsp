<%-- 
    Document   : adminLogin
    Created on : 26 Apr 2026, 12:26:16
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Admin Login</title>

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background: linear-gradient(135deg, #141e30, #243b55);
            color: white;
        }

        .login-box {
            width: 350px;
            margin: 120px auto;
            padding: 30px;
            background: rgba(0,0,0,0.6);
            border-radius: 10px;
            box-shadow: 0 0 20px #00c6ff;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
        }

        input {
            width: 90%;
            padding: 12px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
            outline: none;
        }

        button {
            width: 95%;
            padding: 12px;
            background: #00c6ff;
            border: none;
            color: black;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background: #00a2cc;
        }

        .back {
            margin-top: 15px;
            display: block;
            color: #ccc;
            text-decoration: none;
        }
    </style>
    </head>
    <body>
         <div class="login-box">
        <h2>🔐 Admin Login</h2>
        
        <%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <p style="color:red;"><%= error %></p>
<%
    }
%>

        <form action="AdminLoginServlet.do" method="post">
            <input type="text" name="username" placeholder="Username" required />
            <input type="password" name="password" placeholder="Password" required />

            <button type="submit">Login</button>
        </form>

        <a href="index.html" class="back">⬅ Back to Home</a>
    </div>

    </body>
</html>
