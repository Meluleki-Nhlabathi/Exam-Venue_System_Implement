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
import za.ac.tut.model.bl.ModuleFacadeLocal;
import za.ac.tut.model.entity.Lecturer;
import za.ac.tut.model.entity.Module;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/LoadModulesForStudentView")
public class LoadModulesForStudentView extends HttpServlet {

     @EJB
    private ModuleFacadeLocal moduleFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   Lecturer lecturer = (Lecturer) request.getSession().getAttribute("lecturer");

        List<Module> modules =
                moduleFacade.findByLecturer(lecturer.getLecturerId());

        request.setAttribute("modules", modules);



        request.getRequestDispatcher("Lecture/viewStudents.jsp")
               .forward(request, response);
    }


}
