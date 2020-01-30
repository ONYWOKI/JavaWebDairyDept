/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author edwin
 */
@WebServlet(name = "LogoutController", urlPatterns = {"/LogoutController"})
public class LogoutController extends HttpServlet {
     private static final long serialVersionUID = 1L;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //remove session
        try (PrintWriter pwOut = response.getWriter()) {
            //remove session
            HttpSession session = request.getSession(false);
            session.invalidate();
            
            //print confirmation message and redirect to home page
            pwOut.print("You have successfully logged out");
            response.setContentType("text/html");
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.include(request, response);
        }
        }
    }

    


