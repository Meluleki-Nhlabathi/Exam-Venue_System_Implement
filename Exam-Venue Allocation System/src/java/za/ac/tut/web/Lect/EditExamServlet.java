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
import za.ac.tut.model.entity.Exam;

/**
 *
 * @author Chimane Kokela
 */

@WebServlet("/EditExamServlet")
public class EditExamServlet extends HttpServlet {

    @EJB
    private ExamFacadeLocal examFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");

        if (idStr == null) {
            response.sendRedirect(request.getContextPath() + "/LoadViewExamsServlet.do");
            return;
        }

        int examId = Integer.parseInt(idStr);

        Exam exam = examFacade.find(examId);

        request.setAttribute("exam", exam);

        request.getRequestDispatcher("Lecture/editExam.jsp")
               .forward(request, response);
    }

   

}
