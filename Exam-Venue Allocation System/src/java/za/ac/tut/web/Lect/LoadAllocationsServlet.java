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
import java.util.List;
import za.ac.tut.model.bl.StudentAllocationFacadeLocal;
import za.ac.tut.model.entity.StudentAllocation;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/LoadAllocationsServlet")
public class LoadAllocationsServlet extends HttpServlet {

 @EJB
    private StudentAllocationFacadeLocal allocationFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<StudentAllocation> allocations = allocationFacade.findAll();

        request.setAttribute("allocations", allocations);

        request.getRequestDispatcher("Lecture/viewAllocations.jsp")
               .forward(request, response);
    }
}
