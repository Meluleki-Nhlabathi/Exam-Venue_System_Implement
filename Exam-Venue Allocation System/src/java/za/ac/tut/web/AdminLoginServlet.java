/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package za.ac.tut.web;

import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import za.ac.tut.model.bl.AdminFacadeLocal;
import za.ac.tut.model.entity.Admin;

/**
 *
 * @author Chimane Kokela
 */
public class AdminLoginServlet extends HttpServlet {

   
    @EJB private AdminFacadeLocal afl;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. Get values from form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2. Call EJB method
        Admin admin = afl.login(username, password);

        // 3. Check result
        if (admin != null) {
            
            // ✅ SUCCESS → store admin in session
            request.getSession().setAttribute("admin", admin);

            // Redirect to dashboard/menu
            response.sendRedirect("adminMenu.jsp");

        } else {
            
            // ❌ FAILED → send error back
            request.setAttribute("error", "Invalid username or password");

            // Forward back to login page
            request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
        }
        if (username.isEmpty() || password.isEmpty()) {
    request.setAttribute("error", "All fields are required");
    request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
    return;
}
    }

    

}
