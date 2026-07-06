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
@WebServlet("/UpdateInternetServlet")
public class UpdateInternetServlet extends HttpServlet {

    
  @EJB private VenueFacadeLocal vfl;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String idStr = request.getParameter("venueId");
        String internet = request.getParameter("internetAccess");

        try {
            int id = Integer.parseInt(idStr);

            Venue venue = vfl.find(id);

            if (venue != null) {
                venue.setInternetAccess(internet);
                vfl.edit(venue);
            }

        } catch (Exception e) {
            e.printStackTrace(); // optional logging
        }

        // Reload page
        response.sendRedirect("ViewVenuesServlet.do");
    }

    
}
