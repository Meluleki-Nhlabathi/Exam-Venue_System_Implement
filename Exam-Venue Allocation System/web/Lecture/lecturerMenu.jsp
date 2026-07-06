<%@page import="za.ac.tut.model.entity.Lecturer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Lecturer lecturer = (Lecturer) session.getAttribute("lecturer");

    if (lecturer == null) {
        response.sendRedirect("lecturerLogin.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lecturer Menu</title>

    <!-- Font Awesome Icons -->
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

    <style>
        body {
            text-align: center;
            background: #0f2027;
            color: white;
            font-family: 'Segoe UI';
        }

        .menu {
            margin-top: 60px;
        }

        a {
            display: block;
            margin: 15px auto;
            width: 300px;
            padding: 12px;
            background: rgba(0,198,255,0.2);
            border: 1px solid #00c6ff;
            color: #00c6ff;
            text-decoration: none;
            border-radius: 8px;
            transition: 0.3s;
            font-size: 16px;
        }

        a i {
            margin-right: 10px;
        }

        a:hover {
            background: #00c6ff;
            color: black;
        }

        h2 {
            margin-top: 40px;
        }

        .logout {
            margin-top: 40px;
            color: red;
            border: 1px solid red;
        }

        .logout:hover {
            background: red;
            color: white;
        }
    </style>
</head>

<body>

<h2>👨‍🏫 Welcome, <%= lecturer.getFirstName() %></h2>

<div class="menu">

    <!-- 📚 VIEW MODULES -->
    <a href="<%=request.getContextPath()%>/LoadViewModulesServlet.do">
        <i class="fa-solid fa-book"></i> View My Modules
    </a>

    <!-- 👨‍🎓 STUDENTS -->
   <a href="<%=request.getContextPath()%>/LoadModulesForStudentView.do">
        <i class="fa-solid fa-user-graduate"></i> View Students per Module
    </a>

    <!-- 📝 EXAM -->
    <a href="<%=request.getContextPath()%>/LoadCreateExamServlet.do">
    <i class="fa-solid fa-file-pen"></i> Create Exam
    </a>

    <!-- 🏛️ VENUE -->
    <a href="<%=request.getContextPath()%>/LoadExamsForAllocationServlet.do">
    <i class="fa-solid fa-building-columns"></i> Allocate Venue
   </a>

    <!-- 📊 ALLOCATIONS -->
    <a href="<%=request.getContextPath()%>/LoadAllocationsServlet.do">
    <i class="fa-solid fa-calendar-check"></i> View Allocations
   </a>

    <!-- 🚪 LOGOUT -->
    <a class="logout" href="${pageContext.request.contextPath}/index.html">
        <i class="fa-solid fa-right-from-bracket"></i> Logout
    </a>

</div>

</body>
</html>