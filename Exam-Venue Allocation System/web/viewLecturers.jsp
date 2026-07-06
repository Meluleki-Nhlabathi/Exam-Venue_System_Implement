<%-- 
    Document   : viewLecturers
    Created on : 27 Apr 2026, 17:25:21
    Author     : Chimane Kokela
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Lecturer"%>
<%@page import="za.ac.tut.model.entity.Module"%>
<%@page import="za.ac.tut.model.entity.LecturerModuleAccess"%>

<%
    List<Lecturer> lecturers = (List<Lecturer>) request.getAttribute("lecturers");

    if (lecturers == null) {
    out.println("No data loaded. Go to servlet first.");
    return;
}
%>
<%
List<LecturerModuleAccess> accesses =
(List<LecturerModuleAccess>)
request.getAttribute("accesses");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Lecturers</title>

    <style>
        body {
            font-family: 'Segoe UI';
            background: #0f2027;
            color: white;
            text-align: center;
        }

        table {
            width: 95%;
            margin: 30px auto;
            border-collapse: collapse;
            background: rgba(0,0,0,0.5);
        }

        th, td {
            border: 1px solid #00c6ff;
            padding: 10px;
        }

        th {
            background: #00c6ff;
            color: black;
        }

        .btn {
            padding: 6px 10px;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }

        .edit {
            background: orange;
            color: black;
        }

        .delete {
            background: red;
            color: white;
        }
    </style>
</head>

<body>

<h2>??? Lecturer Management</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Employee No</th>
        <th>Phone</th>
        <th>Department</th>
        <th>Office</th>
        <th>Modules They Teach</th>
        <th>Actions</th>
    </tr>

    <%
        for (Lecturer l : lecturers) {
    %>

    <tr>
        <td><%= l.getLecturerId() %></td>
        <td><%= l.getFirstName() %></td>
        <td><%= l.getLastName() %></td>
        <td><%= l.getEmail() %></td>
        <td><%= l.getEmployeeNumber() %></td>
        <td><%= l.getPhone() %></td>
        <td><%= l.getDepartment() %></td>
        <td><%= l.getOfficeRoom() %></td>

        <!-- MODULES (JPA RELATIONSHIP) -->
      <td>

<%
    boolean found = false;

    for (LecturerModuleAccess access : accesses) {

        if (access.getLecturer().getLecturerId()
                == l.getLecturerId()) {

            Module m = access.getModule();

            found = true;
%>

            <%= m.getModuleCode() %> -
            <%= m.getModuleName() %><br>

<%
        }
    }

    if (!found) {
        out.print("No modules assigned");
    }
%>

</td>

        <!-- ACTIONS -->
        <td>
            <a class="btn edit"
               href="LoadEditLecturerServlet.do?id=<%= l.getLecturerId() %>">
               Edit
            </a>

            <a class="btn delete"
               href="DeleteLecturerServlet.do?id=<%= l.getLecturerId() %>"
               onclick="return confirm('Delete this lecturer?');">
               Delete
            </a>
        </td>
    </tr>

    <% } %>

</table>
    
    <a href="adminMenu.jsp" style="
    display:inline-block;
    margin:15px;
    padding:10px 15px;
    background:#00c6ff;
    color:black;
    text-decoration:none;
    font-weight:bold;
    border-radius:5px;">
    ? Back to Admin Menu
</a>

</body>
</html>
