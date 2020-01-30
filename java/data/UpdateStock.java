/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author edwin
 */
@WebServlet(name = "UpdateStock", urlPatterns = {"/UpdateStock"})
public class UpdateStock extends HttpServlet {
    private static final long serialVersionUID = 1L; 
  
    protected void doPost(HttpServletRequest request,  
HttpServletResponse response) 
        throws ServletException, IOException 
    { 
        try { 
  
            // Initializing the database 
            Connection con = Database.getConnection(); 
  
             
            PreparedStatement st = con 
                   .prepareStatement("insert into milk_received values(?, ?, ?)"); 
  
            //data for id parameter
            st.setInt(1, Integer.valueOf(request.getParameter("id"))); 
  
            //data for name parameter
            st.setString(2, request.getParameter("name")); 
            //data for quantity parameter 
            st.setInt(3, Integer.valueOf(request.getParameter("quantity"))); 
  
            
            // to make changes in database 
            st.executeUpdate(); 
  
            // Close all the connections 
            st.close(); 
            con.close(); 
  
            // Get a writer pointer  
            // to display the succesful result 
            PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>"); 
        } 
        catch (Exception e) { 
            e.printStackTrace(); 
        } 
    } 
} 
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   /** protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           /* out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateStock</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateStock at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
*/
 


