<%-- 
    Document   : viewModules
    Created on : 28 Apr 2026, 17:54:39
    Author     : Chimane Kokela
--%>

<%-- 
    Document   : viewModules
    Created on : 28 Apr 2026
    Author     : Chimane Kokela
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Module"%>
<%@page import="za.ac.tut.model.entity.Lecturer"%>
<%@page import="za.ac.tut.model.bl.ModuleFacadeLocal"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");

    if (lecturer == null) {
        response.sendRedirect("lecturerLogin.jsp");
        return;
    }

    List<Module> modules =
        (List<Module>) request.getAttribute("modules");
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>My Modules</title>

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

        .container {
            margin-top: 40px;
        }

        .card {
            background: rgba(0,0,0,0.6);
            width: 60%;
            margin: 15px auto;
            padding: 15px;
            border-radius: 10px;
            box-shadow: 0 0 10px #00c6ff;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .module-info {
            font-size: 16px;
        }

        .module-code {
            color: #00c6ff;
            font-weight: bold;
        }

        .btn {
            padding: 8px 12px;
            border-radius: 5px;
            text-decoration: none;
            font-weight: bold;
            margin-left: 10px;
        }

        .remove {
            background: red;
            color: white;
        }

        .remove:hover {
            background: darkred;
        }

        .add-btn {
            display: inline-block;
            margin-top: 30px;
            padding: 12px 20px;
            background: #00c6ff;
            color: black;
            text-decoration: none;
            border-radius: 8px;
            font-weight: bold;
        }

        .add-btn:hover {
            background: #0099cc;
        }

        .empty {
            margin-top: 30px;
            color: #ccc;
        }

        .back {
            display: inline-block;
            margin-top: 30px;
            color: white;
            text-decoration: none;
            border: 1px solid white;
            padding: 8px 15px;
            border-radius: 6px;
        }

        .back:hover {
            background: white;
            color: black;
        }
    </style>
</head>

<body>

<h2>📚 My Modules</h2>

<div class="container">

<%
    if (modules != null && !modules.isEmpty()) {

        for (Module m : modules) {
%>

    <div class="card">
        <div class="module-info">
            <span class="module-code"><%= m.getModuleCode() %></span>
            - <%= m.getModuleName() %>
        </div>

        <div>
            <a class="btn remove"
   href="<%=request.getContextPath()%>/RemoveModuleServlet.do?id=<%= m.getModuleId() %>">
   ❌ Remove
    </a>
        </div>
    </div>

<%
        }

    } else {
%>

    <p class="empty">No modules assigned</p>

<%
    }
%>

</div>

<a href="<%= request.getContextPath() %>/LoadAddModuleServlet.do"
   class="add-btn">
   ➕ Add Module
</a>

<br>

<a href="Lecture/lecturerMenu.jsp" class="back">⬅ Back to Menu</a>

</body>
</html>