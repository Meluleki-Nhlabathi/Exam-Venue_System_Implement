<%-- 
    Document   : allocateVenue
    Created on : 28 Apr 2026, 22:19:28
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Exam"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    // Safety check
    Object obj = request.getAttribute("exams");
    List<Exam> exams = (List<Exam>) obj;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Allocate Venues</title>

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
        }

        .box {
            margin: 40px auto;
            width: 400px;
            background: rgba(0,0,0,0.6);
            padding: 25px;
            border-radius: 10px;
            box-shadow: 0 0 12px #00c6ff;
        }

        select {
            width: 100%;
            padding: 10px;
            border-radius: 6px;
            border: none;
            margin-top: 15px;
        }

        button {
            margin-top: 20px;
            padding: 10px 18px;
            background: #00c6ff;
            border: none;
            border-radius: 8px;
            font-weight: bold;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            background: #0099cc;
        }

        .back {
            display: inline-block;
            margin-top: 25px;
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
            color: #ccc;
            margin-top: 20px;
        }
    </style>
</head>

<body>

<h2>🏛️ Allocate Venues for Exam</h2>

<div class="box">

    <%
        if (exams != null && !exams.isEmpty()) {
    %>

        <form action="<%=request.getContextPath()%>/AllocateExamVenueServlet.do" method="GET">

            <label>Select Exam:</label>

            <select name="examId" required>

                <c:forEach var="e" items="${exams}">
                    <option value="${e.examId}">
                        ${e.module.moduleCode} - ${e.date} ${e.time}
                    </option>
                </c:forEach>

            </select>

            <button type="submit">Allocate Venues</button>

        </form>

    <%
        } else {
    %>

        <p class="empty">No exams available for allocation</p>

    <%
        }
    %>

</div>

<a class="back"
   href="Lecture/lecturerMenu.jsp">
    ⬅ Back to Menu
</a>

</body>
</html>
