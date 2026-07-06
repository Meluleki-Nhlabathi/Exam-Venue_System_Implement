<%-- 
    Document   : adminMenu
    Created on : 26 Apr 2026, 12:41:39
    Author     : Chimane Kokela
--%>

<%@page import="za.ac.tut.model.entity.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <%
    Admin admin = (Admin) session.getAttribute("admin");

    if (admin == null) {
        response.sendRedirect("adminLogin.jsp");
        return;
    }
%>

    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
        <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: white;
        }

        .header {
            background: #000;
            padding: 15px;
            text-align: center;
            font-size: 22px;
            letter-spacing: 2px;
        }

        .welcome {
            text-align: center;
            margin-top: 20px;
            font-size: 18px;
        }

        .container {
            display: grid;
            grid-template-columns: repeat(2, 300px);
            gap: 30px;
            justify-content: center;
            margin-top: 50px;
        }

        .card {
            background: rgba(0,0,0,0.6);
            padding: 30px;
            border-radius: 10px;
            text-align: center;
            box-shadow: 0 0 15px #00c6ff;
            transition: 0.3s;
        }

        .card:hover {
            transform: scale(1.05);
        }

        .card h3 {
            margin-bottom: 20px;
        }

        .btn {
            display: block;
            margin: 10px;
            padding: 10px;
            background: #00c6ff;
            color: black;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }

        .btn:hover {
            background: #0099cc;
        }

        .logout {
            margin-top: 40px;
            text-align: center;
        }

        .logout a {
            color: red;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
    </head>
    <body>
        <div class="header">
        💻 Admin Control Panel
    </div>
        
        <%
    String message = (String) session.getAttribute("message");
    if (message != null) {
%>
    <div style="text-align:center; color:#00ff99; margin-top:10px;">
        <%= message %>
    </div>
<%
        session.removeAttribute("message");
    }
%>

    <div class="welcome">
        Welcome, <b><%= admin.getUsername() %></b>
    </div>

    <div class="container">

        <!-- VENUE MANAGEMENT -->
        <div class="card">
            <h3>🏢 Manage Venues</h3>
            <a href="addVenue.jsp" class="btn">Add Venue</a>
            <a href="ViewVenuesServlet.do" class="btn">View / Update Venues</a>
        </div>

        <!-- COMPUTER MANAGEMENT -->
        <div class="card">
            <h3>💻 Manage Computers</h3>
            <a href="LoadAddComputerServlet.do" class="btn">Add Computers</a>
            <a href="LoadUpdateComputerServlet.do" class="btn">Update Computer</a>
        </div>

        <!-- LECTURER VIEW -->
        <div class="card">
            <h3>👨‍🏫 Lecturer Information</h3>
            <a href="ViewLecturersServlet.do" class="btn">View Lecturers</a>
        </div>

        <!-- SYSTEM INFO (OPTIONAL BUT NICE FOR MARKS) -->
        <div class="card">
            <h3>📊 System Overview</h3>
            <a href="SystemOverviewServlet.do" class="btn">System Overview</a>
        </div>
        
        <div class="card">
            <a href="InitStudentModulesServlet.do"
   style="
        display:inline-block;
        margin:15px;
        padding:12px 20px;
        background:#00c6ff;
        color:black;
        text-decoration:none;
        border-radius:8px;
        font-weight:bold;">
    🔄 Initialise Student Modules
     </a>
   </div>

    </div>
    

    
    

    <div class="logout">
        <a href="index.html">🚪 Logout</a>
    </div>
    

    </body>
</html>
