/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.ComputerFacadeLocal;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/UpdateComputerStatusServlet")
public class UpdateComputerStatusServlet extends HttpServlet {

    
 @EJB
    private ComputerFacadeLocal cfl;

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int computerId = Integer.parseInt(request.getParameter("computerId"));
        String status = request.getParameter("status");

        if ("WORKING".equals(status)) {
            cfl.markWorking(computerId);
        } else if ("NOT-WORKING".equals(status)) {
            cfl.markBroken(computerId);
        } else if ("FAULTY".equals(status)) {
            cfl.markFaulty(computerId);
        }

          request.getSession().setAttribute("msg", "Computer modified successfully");
        response.sendRedirect("LoadUpdateComputerServlet");
    }

    

}
