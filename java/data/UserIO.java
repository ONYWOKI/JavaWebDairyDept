package data;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.catalina.User;


@WebServlet(name = "UserIO", urlPatterns = {"/UserIO"})
public class UserIO {
    protected String userId;
    
    public void logIn(HttpServletRequest request){
        String query = "select rank, pass from users where id = ? ";
        Database db = new Database();
        ArrayList<ArrayList<String>> l = Database.run(query, new Object[]{request.getParameter("id")});
        if(l.size() < 2) {
            request.setAttribute("error", "No such user");
            return;
        }
        ArrayList<String> row = l.get(1);
        if(validate(request.getParameter("password"), row.get(1))){
            request.getSession().setAttribute("category", row.get(0));
            request.getSession().setAttribute("success", "Log in successful");
        }else{
            request.setAttribute("error", "Wrong password");
        }
    }
    
    public void register(HttpServletRequest request){
        String query = "insert into users (first_name, last_name, username, category, email, pass) values (?,?,?,?,?,?)";
        ArrayList resp = Database.run(query, new Object[]{((String)request.getParameter("id")),
            ((String)request.getParameter("first_name")),
            ((String)request.getParameter("last_name")),
            ((String)request.getParameter("email")),
            ((String)request.getParameter("category")),
            ((String)request.getParameter("username")),
            ((String)request.getParameter("pass"))});
        if(resp != null){
            request.setAttribute("success", ((String)request.getParameter("fname"))+" successfully registered");
        }else{
            request.setAttribute("error", "Failed to register the new user");
        }
    }
    
    public String hash(String data, String algorithm){
        String hash = "";
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
            messageDigest.update(data.getBytes());
            byte[] digested = messageDigest.digest();
            for(byte b: digested){
                hash+=b;
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(hash.length()+"\n"+hash);
        return hash;
    }
    
    public boolean validate(String p1, String p2){
        return p1.equalsIgnoreCase(p2);
    }

    void createUser(Users users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void editAccount(Users users) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object listUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void deleteAccount(int userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Users getUserByID(int userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean validateLogin(String em, String pw) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Users userSession(String em) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
