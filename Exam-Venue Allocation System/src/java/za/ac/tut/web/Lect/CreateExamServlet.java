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
import za.ac.tut.model.bl.ExamFacadeLocal;
import za.ac.tut.model.bl.ModuleFacadeLocal;
import za.ac.tut.model.entity.Exam;
import za.ac.tut.model.entity.Module;
/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/CreateExamServlet")
public class CreateExamServlet extends HttpServlet {

    @EJB
    private ExamFacadeLocal examFacade;

    @EJB
    private ModuleFacadeLocal moduleFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int moduleId = Integer.parseInt(request.getParameter("moduleId"));
        String dateStr = request.getParameter("date");
        String time = request.getParameter("time");

        Module module = moduleFacade.find(moduleId);

        Exam exam = new Exam();
        exam.setModule(module);
        exam.setTime(time);

        try {
            java.util.Date date = java.sql.Date.valueOf(dateStr);
            exam.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        examFacade.create(exam);
        
        request.getSession().setAttribute(
                "msg",
                "Exam created successfully"
        );

        response.sendRedirect("LoadCreateExamServlet.do");
    }

    

}
