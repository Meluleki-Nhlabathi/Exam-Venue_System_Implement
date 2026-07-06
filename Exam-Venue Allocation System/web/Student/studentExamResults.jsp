<%-- 
    Document   : studentExamResults
    Created on : 07 May 2026, 16:10:56
    Author     : Chimane Kokela
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.StudentAllocation"%>

<%
    List<StudentAllocation> allocations =
            (List<StudentAllocation>) request.getAttribute("allocations");
%>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>Exam Results</title>

    <style>

        body{
            margin:0;
            font-family:'Segoe UI',Tahoma,sans-serif;
            background:linear-gradient(135deg,#0f2027,#203a43,#2c5364);
            color:white;
            text-align:center;
        }

        h1{
            margin-top:40px;
            letter-spacing:2px;
        }

        .student-card{
            width:60%;
            margin:30px auto;
            background:rgba(0,0,0,0.6);
            padding:20px;
            border-radius:12px;
            box-shadow:0 0 10px #00c6ff;
            text-align:left;
        }

        .exam-card{
            width:60%;
            margin:20px auto;
            background:rgba(255,255,255,0.08);
            padding:20px;
            border-radius:10px;
            text-align:left;
            border-left:5px solid #00c6ff;
        }

        .back{
            display:inline-block;
            margin-top:30px;
            padding:10px 15px;
            border:1px solid #00c6ff;
            color:#00c6ff;
            text-decoration:none;
            border-radius:8px;
            transition:0.3s;
        }

        .back:hover{
            background:#00c6ff;
            color:black;
        }

        .empty{
            margin-top:40px;
            color:#ccc;
        }

    </style>

</head>

<body>

<h1>📋 Student Exam Details</h1>

<%
    if (allocations != null && !allocations.isEmpty()) {

        StudentAllocation first = allocations.get(0);
%>

    <!-- STUDENT DETAILS -->

    <div class="student-card">

        <h2>🎓 Student Information</h2>

        <p>
            <b>Student Number:</b>
            <%= first.getStudent().getStudentNumber() %>
        </p>

        <p>
            <b>Name:</b>
            <%= first.getStudent().getName() %>
            <%= first.getStudent().getSurname() %>
        </p>

        <p>
            <b>Qualification:</b>
            <%= first.getStudent().getQualification() %>
        </p>

    </div>

<%
        for(StudentAllocation allocation : allocations){
%>

    <!-- EXAM DETAILS -->

    <div class="exam-card">

        <h3>
            📘
            <%= allocation.getExam()
                    .getModule()
                    .getModuleCode() %>
        </h3>

        <p>
            <b>Module:</b>
            <%= allocation.getExam()
                    .getModule()
                    .getModuleName() %>
        </p>

        <p>
            <b>Date:</b>
            <%= allocation.getExam().getDate() %>
        </p>

        <p>
            <b>Time:</b>
            <%= allocation.getExam().getTime() %>
        </p>

        <p>
            <b>Venue:</b>
            <%= allocation.getVenue().getVenueName() %>
        </p>

    </div>

<%
        }

    } else {
%>

    <p class="empty">
        No exam allocations found for this student.
    </p>

<%
    }
%>

<br>

<a href="<%=request.getContextPath()%>/Student/stPortal.jsp"
   class="back">
    ⬅ Back
</a>

</body>
</html>
