<%-- 
    Document   : registerLecturer
    Created on : 27 Apr 2026, 15:11:13
    Author     : Chimane Kokela
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register Lecturer</title>

    <style>
        body {
            text-align: center;
            background: #0f2027;
            color: white;
            font-family: 'Segoe UI';
        }

        form {
            margin-top: 40px;
        }

        input {
            padding: 10px;
            margin: 8px;
            width: 260px;
            border-radius: 5px;
            border: none;
        }

        .btn {
            background: #00c6ff;
            color: black;
            font-weight: bold;
            cursor: pointer;
        }

        .modules {
            margin-top: 20px;
            text-align: left;
            display: inline-block;
        }

        h3 {
            color: #00c6ff;
        }
    </style>
</head>

<body>

<h2>📝 Register Lecturer</h2>

<!-- REGISTER FORM -->
<form action="${pageContext.request.contextPath}/RegisterLecturerServlet" method="POST">

    <input type="text" name="firstName" placeholder="First Name" required/><br>
    <input type="text" name="lastName" placeholder="Last Name" required/><br>
    <input type="text" name="username" placeholder="Username" required/><br>
    <input type="email" name="email" placeholder="Email" required/><br>
    <input type="text" name="employeeNumber" placeholder="Employee Number" required/><br>
    <input type="password" name="password" placeholder="Password" required/><br>
    <input type="text" name="phone" placeholder="Phone"/><br>
    <input type="text" name="department" placeholder="Department"/><br>
    <input type="text" name="officeRoom" placeholder="Office Room"/><br>

    <!-- MODULE ASSIGNMENT (IMPORTANT REQUIREMENT) -->
    <div class="modules">
        <h3>📚 Select Modules You Teach</h3>

        <input type="checkbox" name="modules" value="PPAF05D"> PPAF05D - Principles of Programming A<br>
        <input type="checkbox" name="modules" value="PPB115D"> PPB115D - Principles of Programming B<br>
        <input type="checkbox" name="modules" value="WEBF15D"> WEBF15D - Web Computing<br>
        <input type="checkbox" name="modules" value="OOP216D"> OOP216D - Object-Oriented Programming<br>
        <input type="checkbox" name="modules" value="DTP216D"> DTP216D - Database Principles<br>
        <input type="checkbox" name="modules" value="AOP216D"> AOP216D - Advanced OOP<br>
        <input type="checkbox" name="modules" value="DBP316D"> DBP316D - Database Programming<br>
        <input type="checkbox" name="modules" value="INT316D"> INT316D - Internet Programming<br>
        <input type="checkbox" name="modules" value="MOB316D"> MOB316D - Mobile Computing<br>
    </div>

    <br><br>

    <input type="submit" value="Register Lecturer" class="btn"/>
</form>

<br><br>

<a href="${pageContext.request.contextPath}/index.html" 
   style="
        display:inline-block;
        padding:10px 20px;
        background:#ffffff;
        color:#0f2027;
        text-decoration:none;
        border-radius:5px;
        font-weight:bold;
   ">
    ⬅ Back
</a>

<!-- SUCCESS MESSAGE -->
<p style="color:lightgreen;">
    <%= request.getAttribute("success") != null ? request.getAttribute("success") : "" %>
</p>

<!-- ERROR MESSAGE -->
<p style="color:red;">
    <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
</p>

</body>
</html>
