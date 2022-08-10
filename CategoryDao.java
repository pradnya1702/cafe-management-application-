/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe_management_system.dao;
import cafe_management_system.model.Category;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Pradnya Jadhav
 */
public class CategoryDao
{
    public static int i=1;
    public static void save (Category category)
    {
     /*insert into category (name) values ('id' , 'name')*/
      String query ="insert into category (id,name) values('"+i+ "','"+category.getName()+"')";   
     // String query ="insert into category (name) values('"+category.getName()+"')";   
      i++;
      dbOperations.setDataOrDelete(query, "category added successfully!");
    }
    public static ArrayList<Category> getAllRecords()
    {
        ArrayList<Category> arrayList = new ArrayList<>();
        try
        {
            ResultSet rs = dbOperations.getData("select *from category");
            while(rs.next())
            {
               Category category = new Category();
               category.setId(rs.getInt("id" ));
               category.setName(rs.getString("name"));
               arrayList.add(category);
            }
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "line 42 in category dao");
        }
        return arrayList;
    }
    public static void delete(String id)
    {
        String query = "delete from category where id ='"+id+"'";
        i--;
        dbOperations.setDataOrDelete(query, "Category Deleted Successfully!");
    }
}
