<%-- 
    Document   : addVenue
    Created on : 26 Apr 2026, 12:48:32
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Venue</title>
        
         <style>
        body {
            font-family: 'Segoe UI';
            background: linear-gradient(135deg, #141e30, #243b55);
            color: white;
            text-align: center;
        }

        .form-box {
            background: rgba(0,0,0,0.7);
            padding: 30px;
            margin: 80px auto;
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
            padding: 10px 20px;
            background: #00c6ff;
            border: none;
            font-weight: bold;
            cursor: pointer;
        }

        button:hover {
            background: #0099cc;
        }

        .msg {
            color: lightgreen;
        }

        .error {
            color: red;
        }
    </style>
        
        
    </head>
    <body>
       <div class="form-box">
    <h2>🏢 Add Venue</h2>

    <!-- SUCCESS / ERROR -->
    <%
        String msg = (String) request.getAttribute("msg");
        String error = (String) request.getAttribute("error");

        if (msg != null) {
    %>
        <p class="msg"><%= msg %></p>
    <%
        }

        if (error != null) {
    %>
        <p class="error"><%= error %></p>
    <%
        }
    %>

    <form action="AddVenueServlet.do" method="post">
        <input type="text" name="venueName" placeholder="Venue Name" required />
        <input type="number" name="capacity" placeholder="Capacity" required />

        <select name="internetAccess">
            <option value="YES">Internet Access: YES</option>
            <option value="NO">Internet Access: NO</option>
        </select>

        <button type="submit">Add Venue</button>
    </form>

    <br>
    <a href="adminMenu.jsp" style="color:#ccc;">⬅ Back</a>
</div>
    </body>
</html>
