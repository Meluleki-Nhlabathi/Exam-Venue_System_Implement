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
import jakarta.servlet.http.HttpSession;
import java.util.List;
import za.ac.tut.model.bl.StudentFacadeLocal;
import za.ac.tut.model.bl.StudentModuleFacadeLocal;
import za.ac.tut.model.entity.Student;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/InitStudentModulesServlet")
public class InitStudentModulesServlet extends HttpServlet {

 @EJB
    private StudentFacadeLocal studentFacade;

    @EJB
    private StudentModuleFacadeLocal studentModuleFacade;

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students = studentFacade.findAll();

        int count = 0;

        for (Student s : students) {
            studentModuleFacade.assignModulesByQualification(s);
            count++;
        }

        // 🔥 store message in session
        HttpSession session = request.getSession();
        session.setAttribute("message",
            "✔ Student Modules Initialised for " + count + " students");

        // 🔥 redirect back to admin page
        response.sendRedirect("adminMenu.jsp");
    }
    
}
