<%-- 
    Document   : viewAllocations
    Created on : 28 Apr 2026, 22:34:08
    Author     : Chimane Kokela
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.StudentAllocation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<StudentAllocation> allocations =
        (List<StudentAllocation>) request.getAttribute("allocations");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Allocations</title>

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg,#0f2027,#203a43,#2c5364);
            color: white;
            text-align: center;
        }

        h2 {
            margin-top: 30px;
        }

        .card {
            width: 70%;
            margin: 15px auto;
            padding: 15px;
            background: rgba(0,0,0,0.6);
            border-radius: 10px;
            box-shadow: 0 0 10px #00c6ff;
            text-align: left;
        }

        .venue {
            color: #00c6ff;
            font-weight: bold;
        }

        .count {
            color: #00ff99;
        }

        .back {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 15px;
            border: 1px solid #00c6ff;
            color: #00c6ff;
            text-decoration: none;
            border-radius: 8px;
        }

        .back:hover {
            background: #00c6ff;
            color: black;
        }
    </style>
</head>

<body>

<h2>📊 Exam Allocations</h2>

<%
    if (allocations != null && !allocations.isEmpty()) {

        int currentExam = -1;

        for (StudentAllocation sa : allocations) {

            if (currentExam != sa.getExam().getExamId()) {
                currentExam = sa.getExam().getExamId();
%>

    <div class="card">
        <h3>📘 <%= sa.getExam().getModule().getModuleCode() %></h3>
        <p>Date: <%= sa.getExam().getDate() %></p>
        <p>Time: <%= sa.getExam().getTime() %></p>

        <hr>

<%
            }
%>

        <p>
            👨‍🎓 <%= sa.getStudent().getStudentNumber() %> -
            <%= sa.getStudent().getName() %>
            <br>
            🏛️ Venue: <span class="venue"><%= sa.getVenue().getVenueName() %></span>
        </p>

<%
        }
%>

    </div>

<%
    } else {
%>

    <h3>No allocations found</h3>

<%
    }
%>

<br>

<a class="back" href="Lecture/lecturerMenu.jsp">
    ⬅ Back to Menu
</a>

</body>
</html>
