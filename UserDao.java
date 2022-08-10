
package cafe_management_system.dao;

import cafe_management_system.model.user; 
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UserDao
{
    public static void save(user user)
    {
        String query = "insert into user(name,email,mobileNumber,address,password,securityQuestion,ans,status) values('"+user.getName()+"','"+user.getMail()+"','"+user.getMobilenumber()+"','"+user.getAddress()+"','"+user.getPassword()+"','"+user.getSecurity()+"','"+user.getAns()+"','false')";                 
         dbOperations.setDataOrDelete(query,"Registered Successfully! Wait for Admin Approval!");
    }
    public static user login(String email , String password)
    {
        user user = null;
        try
        {
            ResultSet rs = dbOperations.getData("select *from user where email='"+email+"' and password='"+password+"'" );
           while(rs.next())
           {
               user = new user();
               user.setStatus(rs.getString("status"));
               
           }
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e );
        }
        return user;
    } 
    public static user getSecurityQuestion (String email)
    {
        user user = null;
        try
        {
            ResultSet rs = dbOperations.getData("select *from user where email = '" + email+"'");
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
    public static void update(String email, String newPassword)
    {
        String query ="update user set password = '" + newPassword+"' where email='"+email+"'";
        dbOperations.setDataOrDelete(query,"Password Changed successfully");
    }
     public static void changeStatus(String email, String status)
    {
        String query ="update user set status= '" + status+"' where email='"+email+"'";
        dbOperations.setDataOrDelete(query,"Status Changed successfully");
    }
    public static void changePassword(String email, String oldPassword ,String newPassword )
    {
        try
        {
            ResultSet rs = dbOperations.getData("select *from user where email='"+email+"' and password='"+oldPassword+"'");
            while(rs.next())
            {
                update(email, newPassword);
                dbOperations.setDataOrDelete(null,"Password Changed successfully");
            }
        }
        catch(Exception e)
        {    
            JOptionPane.showMessageDialog(null, email);
        }   
        }
}
