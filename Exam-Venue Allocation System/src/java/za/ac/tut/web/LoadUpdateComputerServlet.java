/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
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
@WebServlet("/LoadUpdateComputerServlet")
public class LoadUpdateComputerServlet extends HttpServlet {

      @EJB
    private VenueFacadeLocal vfl;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       List<Venue> venues = vfl.findActiveVenues();

        request.setAttribute("venues", venues);

        RequestDispatcher rd = request.getRequestDispatcher("updateComputer.jsp");
        rd.forward(request, response);
    }


}
