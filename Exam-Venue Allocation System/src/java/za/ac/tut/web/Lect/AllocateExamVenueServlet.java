/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web.Lect;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.StudentAllocationFacade;
import za.ac.tut.model.bl.StudentAllocationFacadeLocal;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/AllocateExamVenueServlet")
public class AllocateExamVenueServlet extends HttpServlet {

    
    @EJB
private StudentAllocationFacadeLocal allocationFacade; // ✅ CORRECT

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int examId = Integer.parseInt(request.getParameter("examId"));

        allocationFacade.allocateStudentsToExam(examId);

        response.sendRedirect(
            request.getContextPath() + "/LoadAllocationsServlet.do"
        );
    }

}
