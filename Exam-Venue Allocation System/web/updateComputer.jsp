<%-- 
    Document   : updateComputer
    Created on : 27 Apr 2026, 13:39:13
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Venue"%>
<%@page import="za.ac.tut.model.entity.Computer"%>

<!DOCTYPE html>
<html>
<head>
    <title>Update Computers</title>
    <%
    String msg = (String) session.getAttribute("msg");

    if (msg != null) {
%>

<p style="
    color: lightgreen;
    font-weight: bold;
    background: rgba(0,0,0,0.6);
    display: inline-block;
    padding: 10px 20px;
    border-radius: 5px;
    border: 1px solid lightgreen;
">
    <%= msg %>
</p>

<%
        session.removeAttribute("msg");
    }
%>

    <style>
        body {
            font-family: 'Segoe UI';
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: white;
            text-align: center;
        }

        form {
            margin: 20px;
        }

        table {
            margin: 30px auto;
            border-collapse: collapse;
            width: 80%;
            background: rgba(0,0,0,0.7);
        }

        th, td {
            padding: 12px;
            border: 1px solid #00c6ff;
        }

        th {
            background: #00c6ff;
            color: black;
        }

        select, button {
            padding: 6px;
            border-radius: 5px;
        }

        .btn {
            background: #00c6ff;
            border: none;
            font-weight: bold;
        }
    </style>
</head>

<body>

<h2>💻 Manage Computers</h2>

<!-- SELECT VENUE -->
<form action="ViewComputersServlet.do" method="get">
    <select name="venueId" required>
        <option value="">-- Select Venue --</option>

        <%
            List<Venue> venues = (List<Venue>) request.getAttribute("venues");
            if (venues != null) {
                for (Venue v : venues) {
        %>
        <option value="<%= v.getVenueId() %>">
            <%= v.getVenueName() %>
        </option>
        <%
                }
            }
        %>
    </select>

    <button type="submit" class="btn">Load Computers</button>
</form>

<hr>

<!-- DISPLAY COMPUTERS -->
<%
    List<Computer> computers = (List<Computer>) request.getAttribute("computers");

    if (computers != null) {
%>

<table>
    <tr>
        <th>ID</th>
        <th>PC Number</th>
        <th>Status</th>
        <th>Update</th>
    </tr>

<%
        for (Computer c : computers) {
%>

<tr>
    <td><%= c.getComputerId() %></td>
    <td><%= c.getPcNumber() %></td>
    <td><%= c.getStatus() %></td>

    <td>
        <form action="UpdateComputerStatusServlet.do" method="post">
            <input type="hidden" name="computerId" value="<%= c.getComputerId() %>" />

            <select name="status">
                <option value="WORKING" <%= "WORKING".equals(c.getStatus()) ? "selected" : "" %>>WORKING</option>
                <option value="NOT-WORKING" <%= "NOT-WORKING".equals(c.getStatus()) ? "selected" : "" %>>NOT-WORKING</option>
                <option value="FAULTY" <%= "FAULTY".equals(c.getStatus()) ? "selected" : "" %>>FAULTY</option>
            </select>

            <button type="submit" class="btn">Update</button>
        </form>
    </td>
</tr>

<%
        }
%>

</table>

<%
    }
%>

<br>
<a href="adminMenu.jsp" style="color:white;">⬅ Back</a>

</body>
</html>
