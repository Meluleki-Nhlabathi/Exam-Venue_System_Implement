<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Venue"%>

<!DOCTYPE html>
<html>
<head>
    <title>View Venues</title>

    <style>
        body {
            font-family: 'Segoe UI';
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: white;
            text-align: center;
        }

        table {
            margin: 30px auto;
            border-collapse: collapse;
            width: 85%;
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

        .btn {
            padding: 6px 10px;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            border: none;
            cursor: pointer;
        }

        .disable {
            background: red;
        }

        .enable {
            background: green;
        }

        .update {
            background: #00c6ff;
            color: black;
        }

        select {
            padding: 5px;
        }

        .inactive {
            color: #aaa;
        }

        .msg {
            color: lightgreen;
        }
    </style>
</head>

<body>

<h2>🏢 Active Venues</h2>

<!-- MESSAGE -->
<%
    String msg = (String) session.getAttribute("msg");
    if (msg != null) {
%>
    <p class="msg"><%= msg %></p>
<%
        session.removeAttribute("msg");
    }
%>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Capacity</th>
        <th>Working Computers</th>
        <th>Internet</th>
        <th>Update Internet</th>
        <th>Action</th>
    </tr>

<%
    List<Venue> activeVenues = (List<Venue>) request.getAttribute("activeVenues");

    if (activeVenues != null) {
        for (Venue v : activeVenues) {
%>

<tr>
    <td><%= v.getVenueId() %></td>
    <td><%= v.getVenueName() %></td>
    <td><%= v.getCapacity() %></td>
    <td><%= v.getWorkingComputersCount() %></td>
    <td><%= v.getInternetAccess() %></td>

    <!-- UPDATE INTERNET -->
    <td>
        <form action="UpdateInternetServlet.do" method="post">
            <input type="hidden" name="venueId" value="<%= v.getVenueId() %>" />

            <select name="internetAccess">
                <option value="YES" <%= "YES".equals(v.getInternetAccess()) ? "selected" : "" %>>YES</option>
                <option value="NO" <%= "NO".equals(v.getInternetAccess()) ? "selected" : "" %>>NO</option>
            </select>

            <button type="submit" class="btn update">Update</button>
        </form>
    </td>

    <!-- DISABLE -->
    <td>
        <a class="btn disable"
           href="DisableVenueServlet.do?id=<%= v.getVenueId() %>">
            Disable
        </a>
    </td>
</tr>

<%
        }
    }
%>

</table>

<h2>🚫 Inactive Venues</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Capacity</th>
        <th>Internet</th>
        <th>Action</th>
    </tr>

<%
    List<Venue> inactiveVenues = (List<Venue>) request.getAttribute("inactiveVenues");

    if (inactiveVenues != null) {
        for (Venue v : inactiveVenues) {
%>

<tr class="inactive">
    <td><%= v.getVenueId() %></td>
    <td><%= v.getVenueName() %></td>
    <td><%= v.getCapacity() %></td>
    <td><%= v.getInternetAccess() %></td>

    <!-- ENABLE -->
    <td>
        <a class="btn enable"
           href="EnableVenueServlet.do?id=<%= v.getVenueId() %>">
            Enable
        </a>
    </td>
</tr>

<%
        }
    }
%>

</table>

<br>
<a href="adminMenu.jsp" style="color:white;">⬅ Back</a>

</body>
</html>