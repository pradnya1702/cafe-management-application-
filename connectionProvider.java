
package cafe_management_system.dao;
import java.sql.*;
public class connectionProvider
{
      public static Connection getCon() 
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false","root","Pass@123");
            return con;
        }
        catch(Exception e)
        {
            return null;
        } 
        
    }
}
