
package dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    protected Connection c;
    
    public DBContext(){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;"
                        +"databaseName=bookstore;"
                        +"encrypt=true;"
                        +"trustServerCertificate=true;";
            String username = "sa";
            String pass = "12345";
            
            
            c = (Connection) DriverManager.getConnection(url,username,pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void closeConnection(){
        try {
            if(c!=null && !c.isClosed()){
                c.close();
                System.out.println("Connection closed successfully.");
            }
        } catch (Exception e) {
            System.out.println("Error closing connection: "+e.getMessage());
        }
    }
    public static void main(String[] args) {
        DBContext d  = new DBContext();
        d.closeConnection();
    }
}
