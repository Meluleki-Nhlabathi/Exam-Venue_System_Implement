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
import za.ac.tut.model.bl.LecturerFacadeLocal;
import za.ac.tut.model.bl.LecturerModuleAccessFacadeLocal;
import za.ac.tut.model.entity.Lecturer;
import za.ac.tut.model.entity.LecturerModuleAccess;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/ViewLecturersServlet")
public class ViewLecturersServlet extends HttpServlet {

   

    @EJB
    private LecturerFacadeLocal lecturerFacade;
    
    @EJB
private LecturerModuleAccessFacadeLocal accessFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Lecturer> lecturers = lecturerFacade.findAll();
        List<LecturerModuleAccess> accesses = accessFacade.findAll();

        request.setAttribute("accesses", accesses);
        request.setAttribute("lecturers", lecturers);

        request.getRequestDispatcher("viewLecturers.jsp")
               .forward(request, response);

    

}
}
