/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.ComputerFacadeLocal;
import za.ac.tut.model.bl.VenueFacadeLocal;
import za.ac.tut.model.entity.Computer;
import za.ac.tut.model.entity.Venue;

/**
 *
 * @author Chimane Kokela
 */
public class AddComputerServlet extends HttpServlet {

    @EJB private ComputerFacadeLocal cfl;

    @EJB private VenueFacadeLocal vfl;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int venueId = Integer.parseInt(request.getParameter("venueId"));
        String pcNumber = request.getParameter("pcNumber");
        String status = request.getParameter("status");

        Venue venue = vfl.find(venueId);

        Computer computer = new Computer();
        computer.setVenue(venue);
        computer.setPcNumber(pcNumber);
        computer.setStatus(status);

        cfl.create(computer);

        // feedback message
        request.getSession().setAttribute("msg", "Computer added successfully");

        response.sendRedirect("LoadAddComputerServlet.do");
    }

}
