package cafe_management_system.dao;
import cafe_management_system.model.user;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class dbOperations
{
    public static void setDataOrDelete(String Query ,String msg)
    {
        try
        {
            Connection con = connectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(Query);
            if(!msg.equals(""))
            {
                JOptionPane.showMessageDialog(null, msg);
            }
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    public static ResultSet getData(String query)
    {
        try
        {
            Connection  con = connectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            return rs;
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"Message",JOptionPane.ERROR_MESSAGE);
            return null;
        }
        
    }
    
    public static user getSecurityQuestion(String email)
    {
        user user = null;
          try
        {
          ResultSet rs = dbOperations.getData("select *from user email = '" +email+"'");
           while(rs.next()) 
           {
               user = new user();
               user.setSecurity(rs.getString("securityQuestion"));
               user.setAns(rs.getString("ans"));
           }
        } 
          catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }
}
