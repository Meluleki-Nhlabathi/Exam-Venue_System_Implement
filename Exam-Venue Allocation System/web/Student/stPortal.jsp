<%-- 
    Document   : stPortal
    Created on : 07 May 2026, 13:57:45
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    
    <meta charset="UTF-8">
    
    <title>Student Portal</title>

    <style>

        body{
            margin:0;
            font-family:'Segoe UI',Tahoma,sans-serif;
            background:linear-gradient(135deg,#0f2027,#203a43,#2c5364);
            color:white;
            text-align:center;
        }

        h1{
            margin-top:70px;
            font-size:36px;
            letter-spacing:2px;
        }

        .container{
            margin-top:50px;
            width:40%;
            margin-left:auto;
            margin-right:auto;
            background:rgba(0,0,0,0.5);
            padding:30px;
            border-radius:15px;
            box-shadow:0 0 15px #00c6ff;
        }

        input[type=text]{
            width:80%;
            padding:14px;
            border:none;
            border-radius:8px;
            font-size:16px;
            outline:none;
            margin-top:20px;
        }

        .btn{
            margin-top:25px;
            padding:12px 20px;
            border:none;
            border-radius:8px;
            background:#00c6ff;
            color:black;
            font-size:16px;
            font-weight:bold;
            cursor:pointer;
            transition:0.3s;
        }

        .btn:hover{
            background:#0099cc;
            transform:scale(1.05);
        }

        .back{
            display:inline-block;
            margin-top:30px;
            text-decoration:none;
            color:#00c6ff;
            border:1px solid #00c6ff;
            padding:10px 15px;
            border-radius:8px;
            transition:0.3s;
        }

        .back:hover{
            background:#00c6ff;
            color:black;
        }

        .info{
            margin-top:15px;
            color:#ccc;
            font-size:14px;
        }

    </style>

</head>
<%
    String message = (String) request.getAttribute("message");

    if (message != null) {
%>

<p style="
    color: #ffcccb;
    background: rgba(0,0,0,0.6);
    padding: 10px;
    border-radius: 6px;
    display: inline-block;
    border: 1px solid red;
">
    <%= message %>
</p>

<%
    }
%>

<body>

    <h1>🎓 Student Portal</h1>

    <div class="container">

        <h2>View Exam Allocation</h2>

        <p class="info">
            Enter your student number to view your exam venue,
            module, date and time.
        </p>

        <form action="<%=request.getContextPath()%>/SearchStudentExamServlet.do"
              method="POST">

            <input type="text"
                   name="studentNumber"
                   placeholder="Enter Student Number"
                   required>

            <br>

            <input type="submit"
                   value="View Exams"
                   class="btn">

        </form>

    </div>

    <a href="<%=request.getContextPath()%>/index.html"
       class="back">
        ⬅ Back to Home
    </a>

</body>
</html>
