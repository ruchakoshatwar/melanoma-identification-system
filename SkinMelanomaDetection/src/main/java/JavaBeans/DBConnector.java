/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBeans;

 
 
import java.sql.*;
 
 
 
public class DBConnector {
    
 public Connection con;
    public DBConnector() 
    {
    }
    
    public Connection connect()
    {
    
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
         
           //con=DriverManager.getConnection("jdbc:mysql://localhost/skin_melanoma_db?user=root&&password=crosspolo");
           con=DriverManager.getConnection("jdbc:mysql://uctc281psvdxokog:LjuUlE4jGzfZkaTgfEUL@bm5jqgqw3udrinqjdm24-mysql.services.clever-cloud.com:3306/bm5jqgqw3udrinqjdm24");
            System.out.println("Connected..");
        }
        catch(Exception e)
        {
            System.out.println("Error in connection : "+e.getMessage());
        }
        
    return con;
    }
    
    
    
}

