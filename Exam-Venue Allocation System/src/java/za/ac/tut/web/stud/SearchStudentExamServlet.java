/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web.stud;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import za.ac.tut.model.bl.StudentAllocationFacadeLocal;
import za.ac.tut.model.bl.StudentAllocationFacade;
import za.ac.tut.model.entity.StudentAllocation;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/SearchStudentExamServlet")
public class SearchStudentExamServlet extends HttpServlet {

    @EJB
    private StudentAllocationFacadeLocal allocationFacade;

    @Override
protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    String studentNumber = request.getParameter("studentNumber");

    if (studentNumber == null || studentNumber.isEmpty()) {

        request.setAttribute("message",
                "Please enter a student number");

        request.getRequestDispatcher("Student/stPortal.jsp")
                .forward(request, response);

        return;
    }

    List<StudentAllocation> allocations =
            allocationFacade.findByStudentNumber(studentNumber);

    // ✅ IMPORTANT CHECK
    if (allocations == null || allocations.isEmpty()) {

        request.setAttribute("message",
                "Student number does not exist or no exams found");

        request.getRequestDispatcher("Student/stPortal.jsp")
                .forward(request, response);

        return;
    }

    request.setAttribute("allocations", allocations);

    request.getRequestDispatcher("Student/studentExamResults.jsp")
            .forward(request, response);
}
   
}
