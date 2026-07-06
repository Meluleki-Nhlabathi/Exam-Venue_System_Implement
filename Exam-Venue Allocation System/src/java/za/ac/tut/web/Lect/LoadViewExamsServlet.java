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
import za.ac.tut.model.bl.ExamFacadeLocal;
import za.ac.tut.model.entity.Exam;
import za.ac.tut.model.entity.Lecturer;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/LoadViewExamsServlet")
public class LoadViewExamsServlet extends HttpServlet {

   
    @EJB
    private ExamFacadeLocal examFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Lecturer lecturer = (Lecturer) request.getSession().getAttribute("lecturer");
        
        // CHECK SESSION
        if (lecturer == null) {

            response.sendRedirect("index.jsp");
            return;
        }

        List<Exam> exams = examFacade.findByLecturer(lecturer.getLecturerId());

        request.setAttribute("exams", exams);

        request.getRequestDispatcher("Lecture/viewExams.jsp")
               .forward(request, response);
    }
  

}
