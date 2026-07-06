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
import za.ac.tut.model.bl.StudentAllocationFacadeLocal;
import za.ac.tut.model.entity.Exam;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/DeleteExamServlet")
public class DeleteExamServlet extends HttpServlet {

    
    @EJB
    private ExamFacadeLocal examFacade;
    
    @EJB
private StudentAllocationFacadeLocal allocationFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        String idStr = request.getParameter("id");

        if (idStr == null || idStr.isEmpty()) {

            response.sendRedirect(
                request.getContextPath() + "/LoadViewExamsServlet"
            );

            return;
        }

        try {

            int examId = Integer.parseInt(idStr);

            Exam exam = examFacade.find(examId);

            if (exam != null) {

                // delete child records first
                allocationFacade.deleteByExam(examId);

                // delete parent
                examFacade.remove(exam);
            }

            request.getSession().setAttribute(
                "message",
                "Exam deleted successfully"
            );

        } catch (NumberFormatException e) {

            request.getSession().setAttribute(
                "message",
                "Invalid exam ID"
            );
        }

        response.sendRedirect(
            request.getContextPath() + "/LoadViewExamsServlet"
        );
    }
}
