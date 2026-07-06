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
import za.ac.tut.model.bl.StudentModuleFacadeLocal;
import za.ac.tut.model.entity.StudentModule;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/ViewStudentsPerModuleServlet")
public class ViewStudentsPerModuleServlet extends HttpServlet {

    
 @EJB
    private StudentModuleFacadeLocal sMF;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int moduleId = Integer.parseInt(request.getParameter("moduleId"));

        List<StudentModule> students =  sMF.findByModule(moduleId);

        request.setAttribute("students", students);

        request.getRequestDispatcher("Lecture/displayStudents.jsp").forward(request, response);
    }

}
