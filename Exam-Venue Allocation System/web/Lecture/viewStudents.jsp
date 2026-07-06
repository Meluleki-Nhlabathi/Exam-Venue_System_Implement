<%-- 
    Document   : viewStudents
    Created on : 28 Apr 2026, 20:24:43
    Author     : Chimane Kokela
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.model.entity.Module"%>
<%@page import="za.ac.tut.model.bl.ModuleFacadeLocal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    List<Module> modules =
        (List<Module>) request.getAttribute("modules");
%>

<!DOCTYPE html>
<html>
<head>
    <title>View Students per Module</title>
</head>
<body style="background:#0f2027;color:white;text-align:center;font-family:Segoe UI;">

<h2>👨‍🎓 Select Module</h2>

<form action="<%=request.getContextPath()%>/ViewStudentsPerModuleServlet.do" method="GET">

    <select name="moduleId" required>
        <option value="">-- Select Module --</option>

        <%
            for (Module m : modules) {
        %>

        <option value="<%=m.getModuleId()%>">
            <%=m.getModuleCode()%> - <%=m.getModuleName()%>
        </option>

        <%
            }
        %>

    </select>

    <br><br>

    <button type="submit"
            style="padding:10px 20px;background:#00c6ff;border:none;border-radius:8px;">
        View Students
    </button>

</form>

</body>
</html>
