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
import za.ac.tut.model.bl.VenueFacadeLocal;
import za.ac.tut.model.entity.Venue;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/AddVenueServlet")
public class AddVenueServlet extends HttpServlet {

@EJB  private VenueFacadeLocal vfl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         // 1. Get form data
        String venueName = request.getParameter("venueName");
        String capacityStr = request.getParameter("capacity");
        String internet = request.getParameter("internetAccess");

        // 2. Validation
        if (venueName == null || venueName.trim().isEmpty()) {
            request.setAttribute("error", "Venue name required");
            request.getRequestDispatcher("addVenue.jsp").forward(request, response);
            return;
        }

        int capacity = 0;
        try {
            capacity = Integer.parseInt(capacityStr);
        } catch (Exception e) {
            request.setAttribute("error", "Invalid capacity");
            request.getRequestDispatcher("addVenue.jsp").forward(request, response);
            return;
        }

        // 3. Create Venue object
        Venue venue = new Venue();
        venue.setVenueName(venueName.trim());
        venue.setCapacity(capacity);
        venue.setInternetAccess(internet);
        venue.setStatus("AVAILABLE"); // IMPORTANT

        try {
            // 4. Save using EJB
            vfl.create(venue);

            request.setAttribute("msg", "Venue added successfully!");
        } catch (Exception e) {
            request.setAttribute("error", "Venue may already exist!");
        }

        // 5. Return to page
        request.getRequestDispatcher("addVenue.jsp").forward(request, response);


    }

    
}
