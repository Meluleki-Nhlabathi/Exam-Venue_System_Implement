<%-- 
    Document   : editLecturer
    Created on : 27 Apr 2026, 17:50:13
    Author     : Chimane Kokela
--%>

<%@page import="za.ac.tut.model.entity.Lecturer"%>

<%
    Lecturer l = (Lecturer) request.getAttribute("lecturer");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Lecturer</title>
</head>

<body style="text-align:center; background:#0f2027; color:white;">

<h2>Edit Lecturer</h2>

<form action="UpdateLecturerServlet.do" method="POST">

    <input type="hidden" name="id" value="<%= l.getLecturerId() %>"/>

    <input type="text" name="firstName" value="<%= l.getFirstName() %>" required/><br>
    <input type="text" name="lastName" value="<%= l.getLastName() %>" required/><br>
    <input type="email" name="email" value="<%= l.getEmail() %>" required/><br>
    <input type="text" name="employeeNumber" value="<%= l.getEmployeeNumber() %>" required/><br>
    <input type="text" name="phone" value="<%= l.getPhone() %>"/><br>
    <input type="text" name="department" value="<%= l.getDepartment() %>"/><br>
    <input type="text" name="officeRoom" value="<%= l.getOfficeRoom() %>"/><br>

    <input type="submit" value="Update Lecturer"/>
</form>

<br>
<a href="ViewLecturersServlet">Back</a>

</body>
</html>
