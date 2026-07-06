<%-- 
    Document   : createExam
    Created on : 28 Apr 2026, 21:14:59
    Author     : Chimane Kokela
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Module"%>
<%@page import="za.ac.tut.model.entity.Lecturer"%>

<%
    Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");

    if (lecturer == null) {
        response.sendRedirect("../lecturerLogin.jsp");
        return;
    }

    List<Module> modules = (List<Module>) request.getAttribute("modules");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Create Exam</title>

    <style>
        body {
            font-family: Segoe UI;
            background: #0f2027;
            color: white;
            text-align: center;
        }

        form {
            margin-top: 40px;
            display: inline-block;
            background: rgba(0,0,0,0.6);
            padding: 20px;
            border-radius: 10px;
        }

        select, input {
            padding: 8px;
            margin: 10px;
        }

        button {
            padding: 10px 15px;
            background: #00c6ff;
            border: none;
            border-radius: 5px;
            font-weight: bold;
        }

        button:hover {
            background: #0099cc;
        }

        a {
            color: #00c6ff;
            display: block;
            margin-top: 20px;
        }
    </style>
</head>

<body>

<h2>📝 Create Exam</h2>

<%
    String msg = (String) session.getAttribute("msg");

    if (msg != null) {
%>

<p style="
    color: lightgreen;
    background: rgba(0,0,0,0.6);
    padding: 10px 20px;
    display: inline-block;
    border-radius: 6px;
    border: 1px solid lightgreen;
    font-weight: bold;
">
    <%= msg %>
</p>

<%
        session.removeAttribute("msg");
    }
%>

<%
    if (modules == null || modules.isEmpty()) {
%>
    <h3>No modules assigned to you</h3>
<%
    } else {
%>

<form action="<%=request.getContextPath()%>/CreateExamServlet.do" method="POST">

    <label>Module:</label><br>

    <select name="moduleId" required>
        <%
            for (Module m : modules) {
        %>
            <option value="<%= m.getModuleId() %>">
                <%= m.getModuleCode() %> - <%= m.getModuleName() %>
            </option>
        <%
            }
        %>
    </select>

    <br>

    Date: <input type="date" name="date" required><br>
    Time: <input type="time" name="time" required><br>

    <button type="submit">Create Exam</button>

</form>

<%
    }
%>

<br>
<a href="<%=request.getContextPath()%>/LoadViewExamsServlet.do">
    📋 View Exams (Edit / Delete)
</a>
    
    <a href="Lecture/lecturerMenu.jsp" style="color:#00c6ff;">⬅ Home</a>
    
    

</body>
</html>