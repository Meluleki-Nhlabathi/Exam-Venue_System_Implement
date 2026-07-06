<%-- 
    Document   : lecturerLogin
    Created on : 27 Apr 2026, 14:45:31
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lecturer Login</title>
    <style>
        body {
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: white;
            text-align: center;
            font-family: 'Segoe UI';
        }

        form {
            margin-top: 100px;
        }

        input {
            padding: 10px;
            margin: 10px;
            width: 250px;
        }

        .btn {
            padding: 10px 20px;
            background: #00c6ff;
            border: none;
            color: black;
            font-weight: bold;
        }

        a {
            color: #00c6ff;
        }
    </style>
</head>
<body>

<h2>👨‍🏫 Lecturer Login</h2>

<form action="${pageContext.request.contextPath}/LecturerLoginServlet" method="POST">
    <input type="text" name="username" placeholder="Username" required/><br>
    <input type="password" name="password" placeholder="Password" required/><br>
    <input type="submit" value="Login" class="btn"/>
</form>

<p style="color:red;">
    <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
</p>

<p>New Lecturer? <a href="registerLecturer.jsp">Register here</a></p>

</body>
</html>
