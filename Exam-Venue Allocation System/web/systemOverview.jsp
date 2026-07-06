<%-- 
    Document   : systemOverview
    Created on : 26 Apr 2026, 13:43:41
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>System Overview</title>

    <style>
        body {
            font-family: 'Segoe UI';
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: white;
            text-align: center;
        }

        .container {
            margin-top: 80px;
            display: grid;
            grid-template-columns: repeat(2, 250px);
            gap: 30px;
            justify-content: center;
        }

        .card {
            background: rgba(0,0,0,0.6);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px #00c6ff;
        }

        .number {
            font-size: 40px;
            color: #00c6ff;
            font-weight: bold;
        }

        .back {
            margin-top: 40px;
            display: block;
            color: white;
            text-decoration: none;
        }
    </style>
</head>

<body>

<h2>📊 System Overview Dashboard</h2>

<div class="container">

    <div class="card">
        <h3>Total Venues</h3>
        <div class="number">${totalVenues}</div>
    </div>

    <div class="card">
        <h3>Active Venues</h3>
        <div class="number">${activeVenues}</div>
    </div>

    <div class="card">
        <h3>Total Computers</h3>
        <div class="number">${totalComputers}</div>
    </div>

    <div class="card">
        <h3>Working Computers</h3>
        <div class="number">${workingComputers}</div>
    </div>

</div>

<a class="back" href="adminMenu.jsp">⬅ Back to Dashboard</a>

</body>
</html>
