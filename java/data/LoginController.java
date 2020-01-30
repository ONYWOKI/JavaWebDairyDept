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
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {
        private static final long serialVersionUID = 1L;
	private static final String CLERKPG= "/clerk.jsp";
        private static final String INDEXPG= "/index.jsp";
	private static final String ADMINPG= "/adminindex.jsp";
	private static final String SALESPG= "/sales.jsp";
        private static final String ADDMILKPG= "/addmilk.jsp";
	private static final String ADDPRODUCTPRODUCEDPG= "/addProductProduced.jsp";
	private static final String ADDUSERSPG= "/addUsers.jsp";
	private static final String ASSIGNPRODUCTPG= "/assignProduct.jsp";
        
        private final UserIO data;
        
        public LoginController(){
            super();
             data = new UserIO(); //create new data object to interact with database
        }
        
        protected void doGet(HttpServletRequest request, HttpServletResponse response, String EDITPG) throws ServletException,IOException
	{
		String redirectPage="/index.jsp"; //default page
		String action = request.getParameter("action");
		
		//Removes user account from table and reloads table
		if(action.equalsIgnoreCase("remove"))
		{
			int userid = Integer.parseInt(request.getParameter("userid"));
			data.deleteAccount(userid);
			redirectPage= ADMINPG;
			request.setAttribute("users", data.listUsers());
		}
                //Loads Admin page with database data in table
		else if(action.equalsIgnoreCase("listUsers"))
		{
			redirectPage= ADMINPG;
			request.setAttribute("users", data.listUsers());
		}
                //Finds user by ID and updates database and table with new data.
		else if(action.equalsIgnoreCase("edit"))
		{
			redirectPage= EDITPG;
			int userid = Integer.parseInt(request.getParameter("userid")); //get this objects id
			Users user = data.getUserByID(userid); //user object
			request.setAttribute("user", user); //sends user data to jsp
		}
                //Loads Admin page with database data in table
		else if(action.equalsIgnoreCase("listUsers"))
		{
			redirectPage= ADMINPG;
			request.setAttribute("users", data.listUsers());
		}
		
		//Finds user by ID and updates database and table with new data.
		else if(action.equalsIgnoreCase("edit"))
		{
			redirectPage= EDITPG;
			int userid = Integer.parseInt(request.getParameter("userid")); //get this objects id
			var user = data.getUserByID(userid); //user object
			request.setAttribute("user", user); //sends user data to jsp
		}
		
		RequestDispatcher view = request.getRequestDispatcher(redirectPage);
		view.forward(request, response); //forward response to request
	}

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
        protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
            //get input from jsp
            try (PrintWriter pwOut = response.getWriter()) {
                //get input from jsp
                String em=request.getParameter("email");
                String pw =request.getParameter("psword");
                
                
                //Validate Login with input
                if(data.validateLogin(em, pw))
                {
                    //create session and store variables
                    Users user= data.userSession(em);
                    HttpSession session = request.getSession();
                    session.setAttribute("username", user.getUsername());
                    session.setAttribute("email", em);
                    //load welcome page with session data
                    RequestDispatcher view = request.getRequestDispatcher(INDEXPG);
                    view.forward(request, response);
                    
                }
                //if input is not stored in database print error message and reload page
                else
                {
                    pwOut.print("<p style=\"color:red\">Incorrect Username or Password!</p>");
                    RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                    view.include(request, response);
                    
                }
            }
		
	}
}
		

   
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try ( PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet LoginController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
