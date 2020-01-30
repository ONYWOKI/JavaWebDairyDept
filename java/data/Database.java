package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
 
public class Database {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/dairydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
 
    private static Connection connection = null;
 
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Loading The Driver Class
                Class.forName(DRIVER);
 
                // Getting the connection Object
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
 
        return connection;
    }
    
     

    static ArrayList<ArrayList<String>> run(String query, Object[] object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
}