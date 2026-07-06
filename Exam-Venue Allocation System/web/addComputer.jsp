<%-- 
    Document   : addComputer
    Created on : 27 Apr 2026, 13:30:34
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Venue"%>

<!DOCTYPE html>
<html>
<head>
    <title>Add Computer</title>

    <style>
        body {
            font-family: 'Segoe UI';
            background: linear-gradient(135deg, #0f2027, #203a43, #2c5364);
            color: white;
            text-align: center;
        }

        form {
            background: rgba(0,0,0,0.7);
            padding: 30px;
            margin: 50px auto;
            width: 350px;
            border-radius: 10px;
            box-shadow: 0 0 15px #00c6ff;
        }

        input, select {
            width: 90%;
            padding: 10px;
            margin: 10px;
            border-radius: 5px;
            border: none;
        }

        button {
            background: #00c6ff;
            padding: 10px;
            border: none;
            width: 95%;
            border-radius: 5px;
            font-weight: bold;
        }

        button:hover {
            background: #0099cc;
        }
    </style>
</head>

<body>

<h2>💻 Add Computer</h2>

<form action="AddComputerServlet.do" method="post">

    <!-- SELECT VENUE -->
    <select name="venueId" required>
        <option value="">-- Select Venue --</option>

        <%
            List<Venue> venues = (List<Venue>) request.getAttribute("venues");
            if (venues != null) {
                for (Venue v : venues) {
        %>
            <option value="<%= v.getVenueId() %>">
                <%= v.getVenueName() %> (ID: <%= v.getVenueId() %>)
            </option>
        <%
                }
            }
        %>
    </select>

    <!-- PC NUMBER -->
    <input type="text" name="pcNumber" placeholder="PC Number (e.g PC-01)" required />

    <!-- STATUS -->
    <select name="status">
        <option value="WORKING">WORKING</option>
        <option value="NOT-WORKING">NOT-WORKING</option>
        <option value="FAULTY">FAULTY</option>
    </select>

    <button type="submit">Add Computer</button>

</form>

<br>
<a href="adminMenu.jsp" style="color:white;">⬅ Back</a>

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

</body>
</html>