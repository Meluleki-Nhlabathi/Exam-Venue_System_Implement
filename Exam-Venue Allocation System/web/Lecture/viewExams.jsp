<%-- 
    Document   : viewExams
    Created on : 28 Apr 2026, 21:26:30
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Exam"%>

<%
    List<Exam> exams = (List<Exam>) request.getAttribute("exams");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Exams</title>

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: white;
            text-align: center;
        }

        h2 {
            margin-top: 40px;
            letter-spacing: 1px;
        }

        .card {
            background: rgba(0,0,0,0.6);
            margin: 15px auto;
            padding: 15px;
            width: 60%;
            border-radius: 10px;
            box-shadow: 0 0 10px #00c6ff;
            text-align: left;
        }

        .btn {
            display: inline-block;
            margin-top: 10px;
            padding: 6px 10px;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
        }

        .edit {
            background: #00c6ff;
            color: black;
        }

        .delete {
            background: red;
            color: white;
        }

        .edit:hover {
            background: #0099cc;
        }

        .delete:hover {
            background: darkred;
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

        .empty {
            margin-top: 30px;
            color: #ccc;
        }
    </style>
</head>

<body>

<h2>📋 My Exams</h2>

<%
    if (exams != null && !exams.isEmpty()) {

        for (Exam e : exams) {
%>

    <div class="card">
        <b>📘 <%= e.getModule().getModuleCode() %></b><br><br>

        📅 Date: <%= e.getDate() %><br>
        ⏰ Time: <%= e.getTime() %><br>

        <br>

        <a class="btn edit"
           href="<%=request.getContextPath()%>/EditExamServlet.do?id=<%= e.getExamId() %>">
            ✏ Edit
        </a>

        <a class="btn delete"
           href="<%=request.getContextPath()%>/DeleteExamServlet.do?id=<%= e.getExamId() %>"
           onclick="return confirm('Delete this exam?')">
            ❌ Delete
        </a>
    </div>

<%
        }

    } else {
%>

    <p class="empty">No exams found</p>

<%
    }
%>

<br>

<a class="back"
   href="Lecture/lecturerMenu.jsp">
    ⬅ Back to Menu
</a>

</body>
</html>