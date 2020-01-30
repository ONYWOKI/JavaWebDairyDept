
package data;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "LoginAuth", urlPatterns = {"/LoginAuth"})
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;	
    private static final String ADMINPG= "/adminindex.jsp";
    
    private final UserIO data;
    public RegisterController(){
        super();
        //create new data object
        data = new UserIO();
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //create new user object
        Users users = new Users();
        PrintWriter pwOut= response.getWriter();
        
        //get input from jsp and store in user object
                String username = request.getParameter("username");		
		String password =request.getParameter("password");
		String email=request.getParameter("email");
		String phoneno = request.getParameter("phone_no");	
                String category = request.getParameter("category");	
                String userID = request.getParameter("userid");		
		users.setUsername(username);			
		users.setPassword(password);
                users.setEmail(email);
                users.setPhone_no(phoneno);
                users.setCategory(category);
                users.setUserID(userID);
                
                //if there is no ID field a new user is being created and added to database
                if(userID==null||userID.isEmpty()){
                        data.createUser(users);				
			pwOut.print("Registration Successful! Please Login.");
			response.setContentType("text/html");
			RequestDispatcher view = request.getRequestDispatcher("/index.jsp");		
			view.include(request, response); //index page is reloaded with text for new user to login
                }//if there is an ID field a user is being edited
		else
		{
//			users.setUserID(Integer.parseInt(userID));				
			data.editAccount(users);
			request.setAttribute("users",data.listUsers());
			RequestDispatcher view = request.getRequestDispatcher(ADMINPG);		
			view.forward(request, response); //reload admin page with updated table
		}		


    }




}
