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
import za.ac.tut.model.bl.LecturerFacadeLocal;
import za.ac.tut.model.entity.Lecturer;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/DeleteLecturerServlet")
public class DeleteLecturerServlet extends HttpServlet {

  
 @EJB
    private LecturerFacadeLocal lecturerFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Lecturer l = lecturerFacade.find(id);

        lecturerFacade.remove(l);

        response.sendRedirect("ViewLecturersServlet.do");
    }

}
