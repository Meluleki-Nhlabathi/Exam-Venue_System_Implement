<%-- 
    Document   : editExam
    Created on : 28 Apr 2026, 21:50:16
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="za.ac.tut.model.entity.Exam"%>


<%
    Exam exam = (Exam) request.getAttribute("exam");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Exam</title>
</head>

<body style="background:#203a43;color:white;text-align:center;font-family:Segoe UI;">

<h2>✏ Edit Exam</h2>

<form action="<%=request.getContextPath()%>/UpdateExamServlet.do" method="POST">

    <input type="hidden" name="examId" value="<%= exam.getExamId() %>">

    <label>Date:</label><br>
    <input type="date" name="date" value="<%= exam.getDate() %>" required><br><br>

    <label>Time:</label><br>
    <input type="time" name="time" value="<%= exam.getTime() %>" required><br><br>

    <button type="submit">Update Exam</button>

</form>

<br>

<a href="<%=request.getContextPath()%>/LoadViewExamsServlet.do" style="color:#00c6ff;">
    ⬅ Back
</a>

</body>
</html>
