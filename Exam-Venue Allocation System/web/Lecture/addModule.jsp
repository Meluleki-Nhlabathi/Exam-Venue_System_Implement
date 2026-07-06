<%-- 
    Document   : addModule
    Created on : 28 Apr 2026, 18:18:03
    Author     : Chimane Kokela
--%>

<%-- 
    Document   : addModule
    Created on : 28 Apr 2026
    Author     : Chimane Kokela
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Module"%>
<%@page import="za.ac.tut.model.entity.Lecturer"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");

    if (lecturer == null) {
        response.sendRedirect("lecturerLogin.jsp");
        return;
    }

    // 👇 IMPORTANT: data comes from servlet, NOT EJB in JSP
    List<Module> availableModules =
        (List<Module>) request.getAttribute("modules");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Modules</title>

    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', Tahoma, sans-serif;
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: white;
            text-align: center;
        }

        h2 {
            margin-top: 30px;
        }

        form {
            margin-top: 30px;
            display: inline-block;
            text-align: left;
            background: rgba(0,0,0,0.6);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px #00c6ff;
        }

        input[type="checkbox"] {
            margin: 8px;
        }

        button {
            margin-top: 15px;
            padding: 10px 20px;
            background: #00c6ff;
            border: none;
            border-radius: 8px;
            font-weight: bold;
            cursor: pointer;
        }

        button:hover {
            background: #0099cc;
        }

        .back {
            display: inline-block;
            margin-top: 20px;
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

        .empty {
            color: #ccc;
        }
    </style>
</head>

<body>

<h2>📚 Select Modules</h2>

<form action="<%=request.getContextPath()%>/AddModuleServlet.do" method="POST">

<%
    if (availableModules != null && !availableModules.isEmpty()) {

        for (Module m : availableModules) {
%>

    <input type="checkbox" name="modules"
           value="<%= m.getModuleId() %>">

    <%= m.getModuleCode() %> - <%= m.getModuleName() %><br>

<%
        }

    } else {
%>

    <p class="empty">No available modules found</p>

<%
    }
%>

<br>
<button type="submit">Assign Modules</button>

</form>

<br>



</body>
</html>