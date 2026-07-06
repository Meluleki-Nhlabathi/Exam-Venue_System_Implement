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
import za.ac.tut.model.bl.LecturerFacadeLocal;
import za.ac.tut.model.entity.Lecturer;

/**
 *
 * @author Chimane Kokela
 */
@WebServlet("/UpdateLecturerServlet")
public class UpdateLecturerServlet extends HttpServlet {


    @EJB
    private LecturerFacadeLocal lecturerFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Lecturer l = lecturerFacade.find(id);

        l.setFirstName(request.getParameter("firstName"));
        l.setLastName(request.getParameter("lastName"));
        l.setEmail(request.getParameter("email"));
        l.setEmployeeNumber(request.getParameter("employeeNumber"));
        l.setPhone(request.getParameter("phone"));
        l.setDepartment(request.getParameter("department"));
        l.setOfficeRoom(request.getParameter("officeRoom"));

        lecturerFacade.edit(l);

        response.sendRedirect("ViewLecturersServlet.do");
    }
    

}
