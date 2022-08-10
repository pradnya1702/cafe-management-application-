/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe_management_system.dao;

import cafe_management_system.Bill;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Pradnya Jadhav
 */  

public class billDao
{
    public static String getId()
    {
        int id = 1;
        try
        {
            ResultSet rs = dbOperations.getData("select max(id) from bill");
            if(rs.next())
            {
                id = rs.getInt(1);
                id = id+1;
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }
    
    public static void save(Bill bill)
    {
        String query = "insert into bill values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobileNumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreateBy()+"')";         
        dbOperations.setDataOrDelete(query, "Bill details added successfully !");
    }
    
    public static ArrayList<Bill> getAllRecordsByInc(String date)
    {
        ArrayList<Bill>arrayList = new ArrayList<>();
        try
        {
            ResultSet rs = dbOperations.getData("select *from bill where date like '%"+date+"%'");
            while(rs.next())
            {
               Bill bill = new Bill();
               bill.setId(rs.getInt("id"));
               bill.setName(rs.getString("name"));
               bill.setMobileNumber(rs.getString("mobileNumber"));
               bill.setEmail(rs.getString("email"));
               bill.setDate(rs.getString("date"));
               bill.setTotal(rs.getString("total"));
               bill.setCreateBy(rs.getString("createdBy"));
               arrayList.add(bill);
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    
    public static ArrayList<Bill> getAllRecordsByDesc(String date)
    {
        ArrayList<Bill>arrayList = new ArrayList<>();
        try
        {
            ResultSet rs = dbOperations.getData("select *from bill where date like '%"+date+"%' order by id DESC");
            while(rs.next())
            {
               Bill bill = new Bill();
               bill.setId(rs.getInt("id"));
               bill.setName(rs.getString("name"));
               bill.setMobileNumber(rs.getString("mobileNumber"));
               bill.setEmail(rs.getString("email"));
               bill.setDate(rs.getString("date"));
               bill.setTotal(rs.getString("total"));
               bill.setCreateBy(rs.getString("createdBy"));
               arrayList.add(bill);
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
