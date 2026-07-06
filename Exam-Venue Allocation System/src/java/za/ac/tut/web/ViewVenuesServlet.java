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
import java.util.List;
import za.ac.tut.model.bl.VenueFacadeLocal;
import za.ac.tut.model.entity.Venue;

/**
 *
 * @author Chimane Kokela
 */

public class ViewVenuesServlet extends HttpServlet {

   @EJB   private VenueFacadeLocal vfl; 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Get venues
        List<Venue> activeVenues = vfl.findActiveVenues();
        List<Venue> inactiveVenues = vfl.findInactiveVenues();

        // Send to JSP
        request.setAttribute("activeVenues", activeVenues);
        request.setAttribute("inactiveVenues", inactiveVenues);

        request.getRequestDispatcher("viewVenues.jsp").forward(request, response);
    }

    

}
