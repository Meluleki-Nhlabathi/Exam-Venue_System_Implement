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
import java.text.SimpleDateFormat;
import java.util.Date;
import za.ac.tut.model.bl.ExamFacadeLocal;
import za.ac.tut.model.entity.Exam;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/UpdateExamServlet")
public class UpdateExamServlet extends HttpServlet {
@EJB
    private ExamFacadeLocal examFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int examId = Integer.parseInt(request.getParameter("examId"));
            String dateStr = request.getParameter("date");
            String time = request.getParameter("time");

            // ✅ Convert String → Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateStr);

            Exam exam = examFacade.find(examId);

            if (exam != null) {
                exam.setDate(date);
                exam.setTime(time);

                examFacade.edit(exam);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect(request.getContextPath() + "/LoadViewExamsServlet.do");
    }
     

}
