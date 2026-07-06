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
import jakarta.servlet.http.HttpSession;
import za.ac.tut.model.bl.LecturerFacadeLocal;
import za.ac.tut.model.entity.Lecturer;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/LecturerLoginServlet")
public class LecturerLoginServlet extends HttpServlet {

   
   @EJB
    private LecturerFacadeLocal lecturerFacade;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Lecturer lecturer = lecturerFacade.login(username, password);

        if (lecturer == null) {

            request.setAttribute("error", "Lecturer does not exist. Please register.");
            request.getRequestDispatcher("Lecture/lecturerLogin.jsp").forward(request, response);

        } else {

            HttpSession session = request.getSession();
            session.setAttribute("lecturer", lecturer);

            response.sendRedirect("Lecture/lecturerMenu.jsp");
        }
    }

    

}
