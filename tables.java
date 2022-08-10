
package cafe_management_system.dao;

import javax.swing.JOptionPane;

public class tables
{
    public static void main(String[] args)
    {
        try
        {
            //CREATE TABLE `cms`.`` (  `ID` INT NOT NULL,  `Name` VARCHAR(200) NOT NULL,  PRIMARY KEY (`ID`));

            String useTable = "create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200), ans varchar(200),status varchar(20),UNIQUE(email))";
            dbOperations.setDataOrDelete(useTable, "User table created successfully!");
            String adminDetails = "insert into user(name,email,mobilenumber,address,password,securityQuestion,ans,status) values('Admin','admin@gmail.com','1234567890','India','admin','what primary school did you attend?','ABC','true')";
            String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar(200))";
            dbOperations.setDataOrDelete(adminDetails, "Admin detils added successfully!");
            String ProductTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(200),category varchar(200),price varchar(200))";
            String billTable = "create table bill(id int primary key,name varchar(200),mobileNumber varchar(200),email varchar(200) ,date varchar(50),total varchar(50),createdBy varchar(200))";
            dbOperations.setDataOrDelete(categoryTable, "category Table Created successfully!");
            dbOperations.setDataOrDelete(ProductTable, "Product Table Created successfully!");
            dbOperations.setDataOrDelete(billTable, "Bill Table Created successfully!");
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
