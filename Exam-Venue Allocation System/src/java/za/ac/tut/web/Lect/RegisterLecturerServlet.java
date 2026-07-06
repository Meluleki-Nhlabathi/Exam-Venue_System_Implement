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
import za.ac.tut.model.bl.LecturerFacadeLocal;
import za.ac.tut.model.bl.LecturerModuleAccessFacadeLocal;
import za.ac.tut.model.bl.ModuleFacadeLocal;
import za.ac.tut.model.entity.Lecturer;
import za.ac.tut.model.entity.LecturerModuleAccess;
import za.ac.tut.model.entity.Module;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/RegisterLecturerServlet")
public class RegisterLecturerServlet extends HttpServlet {

    @EJB
    private LecturerFacadeLocal lecturerFacade;

    @EJB
    private ModuleFacadeLocal moduleFacade;
    
    @EJB
    private LecturerModuleAccessFacadeLocal accessFacade; 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            // =========================
            // 1. GET FORM DATA
            // =========================
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String employeeNumber = request.getParameter("employeeNumber");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            String department = request.getParameter("department");
            String officeRoom = request.getParameter("officeRoom");

            // =========================
            // 2. CREATE LECTURER OBJECT
            // =========================
            Lecturer lecturer = new Lecturer(
                    firstName,
                    lastName,
                    username,
                    email,
                    password,
                    employeeNumber,
                    phone,
                    department,
                    officeRoom
            );

            // =========================
            // 3. SAVE LECTURER
            // =========================
            lecturerFacade.create(lecturer);

            // IMPORTANT: after persist, ID is generated
            // =========================
            String[] modules = request.getParameterValues("modules");

            if (modules != null) {
                for (String moduleCode : modules) {
                    Module module = moduleFacade.findByCode(moduleCode);
                    if (module != null) {
                        // ✅ Create a link instead of overwriting the module's lecturer
                        if (!accessFacade.linkExists(lecturer.getLecturerId(), module.getModuleId())) {
                            accessFacade.create(new LecturerModuleAccess(lecturer, module));
                        }
                    }
                }
            }

            // =========================
            // 4. SUCCESS RESPONSE
            // =========================
            request.setAttribute("success", "Lecturer registered successfully!");
            request.getRequestDispatcher("Lecture/registerLecturer.jsp")
                    .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();

            request.setAttribute("error", "Registration failed: " + e.getMessage());
            request.getRequestDispatcher("Lecture/registerLecturer.jsp")
                    .forward(request, response);
        }
    }
}
