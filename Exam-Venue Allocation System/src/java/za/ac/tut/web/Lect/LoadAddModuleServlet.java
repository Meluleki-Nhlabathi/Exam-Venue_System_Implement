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
import za.ac.tut.model.bl.LecturerModuleAccessFacadeLocal;
import za.ac.tut.model.bl.ModuleFacadeLocal;
import za.ac.tut.model.entity.Lecturer;
import za.ac.tut.model.entity.Module;

@WebServlet("/LoadAddModuleServlet")
public class LoadAddModuleServlet extends HttpServlet {

    @EJB
    private ModuleFacadeLocal moduleFacade;
    @EJB
    private LecturerModuleAccessFacadeLocal accessFacade;
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Lecturer lecturer =
            (Lecturer) request.getSession().getAttribute("lecturer");

        if (lecturer == null) {
            response.sendRedirect("lecturerLogin.jsp");
            return;
        }

        List<Module> modules =
            accessFacade.findModulesNotLinkedToLecturer(lecturer.getLecturerId());

        request.setAttribute("modules", modules);

        request.getRequestDispatcher("Lecture/addModule.jsp")
               .forward(request, response);
    }

   
}
