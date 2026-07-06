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
import za.ac.tut.model.bl.VenueFacadeLocal;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/SystemOverviewServlet")
public class SystemOverviewServlet extends HttpServlet {


     @EJB
    private VenueFacadeLocal vfl;

    @EJB
    private ComputerFacadeLocal cfl;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         // VENUES
        int totalVenues = vfl.countAllVenues();
        int activeVenues = vfl.countActiveVenues();

        // COMPUTERS
        int totalComputers = cfl.countAllComputers();
        int workingComputers = cfl.countWorkingComputers();

        // SEND TO JSP
        request.setAttribute("totalVenues", totalVenues);
        request.setAttribute("activeVenues", activeVenues);

        request.setAttribute("totalComputers", totalComputers);
        request.setAttribute("workingComputers", workingComputers);

        request.getRequestDispatcher("systemOverview.jsp").forward(request, response);
    }
        
        
        
    }

   

