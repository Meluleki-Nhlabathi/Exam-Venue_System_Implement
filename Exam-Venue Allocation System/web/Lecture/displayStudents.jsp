<%-- 
    Document   : displayStudents
    Created on : 28 Apr 2026, 20:29:47
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.StudentModule"%>

<%
    List<StudentModule> students =
        (List<StudentModule>) request.getAttribute("students");

    int count = (students != null) ? students.size() : 0;
%>

<!DOCTYPE html>
<html>
<head>
    <title>Students</title>
</head>

<body style="background:#203a43;color:white;text-align:center;font-family:Segoe UI;">

<h2>📚 Students in Module</h2>

<!-- ⭐ STUDENT COUNT -->
<h3 style="color:#00c6ff;">
    Total Students: <%= count %>
</h3>

<%
    if (students != null && !students.isEmpty()) {

        for (StudentModule sm : students) {
%>

    <div style="background:rgba(0,0,0,0.5);margin:10px;padding:10px;border-radius:8px;">
        <b><%= sm.getStudent().getStudentNumber() %></b><br>
        <%= sm.getStudent().getName() %> <%= sm.getStudent().getSurname() %><br>
        <%= sm.getStudent().getQualification() %>
    </div>

<%
        }

    } else {
%>

    <h3>No students found for this module</h3>

<%
    }
%>

<br>

<a href="Lecture/lecturerMenu.jsp" style="color:#00c6ff;">⬅ Home</a>

</body>
</html>
