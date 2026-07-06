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
import za.ac.tut.model.bl.LecturerModuleAccessFacadeLocal;
import za.ac.tut.model.bl.ModuleFacadeLocal;
import za.ac.tut.model.entity.Lecturer;
import za.ac.tut.model.entity.LecturerModuleAccess;
import za.ac.tut.model.entity.Module;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/AddModuleServlet")
public class AddModuleServlet extends HttpServlet {
 
    @EJB private ModuleFacadeLocal moduleFacade;
 
  @EJB private LecturerModuleAccessFacadeLocal accessFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Lecturer lecturer =
            (Lecturer) request.getSession().getAttribute("lecturer");

        if (lecturer == null) {
            response.sendRedirect("lecturerLogin.jsp");
            return;
        }

        String[] selectedModules = request.getParameterValues("modules");

        if (selectedModules != null) {
            for (String idStr : selectedModules) {
                int moduleId = Integer.parseInt(idStr);
                Module module = moduleFacade.find(moduleId);

                if (module != null) {
                    // ✅ Only create the link if it doesn't exist yet
                    if (!accessFacade.linkExists(lecturer.getLecturerId(), moduleId)) {
                        LecturerModuleAccess link =
                            new LecturerModuleAccess(lecturer, module);
                        accessFacade.create(link);
                    }
                    // If it already exists, silently skip — no duplicate, no override
                }
            }
        }

        response.sendRedirect(request.getContextPath()
                + "/LoadViewModulesServlet.do");
    }
    

}
