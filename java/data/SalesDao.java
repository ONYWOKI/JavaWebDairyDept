
package data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author edwin
 */
@WebServlet(name = "SalesDao", urlPatterns = {"/SalesDao"})
public class SalesDao extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><body>");
        try{
             Class.forName("DRIVER");  
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dairydb");  
              
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from sales");  
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>EmpId</th><th>EmpName</th><th>Salary</th><tr>");  
             while (rs.next()){
                  String n = rs.getString("products");  
                 String nm = rs.getString("remaining_quantity");  
                 int s = rs.getInt("dates");   
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");  
             }
              out.println("</table>");  
             out.println("</html></body>");  
             con.close();
        }
        catch (Exception e) 
            {  
             out.println("error");  
         }  
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
