package data;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserIO", urlPatterns = {"/UserIO"})
public class UserIO1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserIO1() {
        super();
    }

	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
		{
		
			response.setContentType("text/html");
			
			
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String password =request.getParameter("password");
			String phone_no = request.getParameter("phone_no");
			String category=request.getParameter("category");
                        String confirm_pass=request.getParameter("confirm");
                        
			
			try
			{
				PrintWriter out = response.getWriter();	
				Class.forName("Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dairydb","root","");
				
			if(password.equals(confirm_pass))	
			{
				
			String str="Insert into users values(?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(str);
			
			ps.setString(1, username);
			ps.setString(2, email);
			ps.setString(3,password);
			ps.setString(4, phone_no);
			ps.setString(5, category);
			ps.setString(6, confirm_pass);
			
			ps.executeUpdate();
			
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Sign Up Successful');");  
			out.println("</script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
			}
			
			else
			{	

				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Password dooesn't match');");  
				out.println("</script>");
				
				RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}
			
			
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		
			

		}
}