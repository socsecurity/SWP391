/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import dbcontext.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;

/**
 *
 * @author Quan Nguyen
 */
public class EmployeeDAO {
    static Connection con = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    static DBConnect db = DBConnect.getInstance();

    public static List<Employee> getAllEmployeesAvailable() {
        List<Employee> listE = new ArrayList<>();
        try {
            String sql = "SELECT [User_id],[password],[full_name] ,[Address],[phone_number], r.name \n" +
                "FROM [Restaurant].[dbo].[User] as u\n" +
                "INNER JOIN Role as r on r.role_Id = u.role_id\n" +
                "WHERE u.role_id != 0";
            //DBConnect db = DBConnect.getInstance();
            con = db.openConnection();
            if(con != null){ 
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getNString(3);
                    String address = rs.getNString(4);
                    String number = rs.getNString(5);
                    String role = rs.getNString(6);
                    Employee ep = new Employee(id, name, address, number, role);
                    listE.add(ep);
                }
                rs.close();
                pst.close();
                con.close();
                return listE;
            }
        }catch (Exception e){
            
        }
        return null;
    }

    
    public static boolean updateEmployee(int id, String name, String address, String number, String role){
        try{
            con = db.openConnection();
            String sql = "UPDATE [Restaurant].[dbo].[User]\n" +
                    "SET full_name = ?, Address= ?, phone_number= ?, role_id = ?\n" +
                    "WHERE [user_id] = ?";
            if(con != null){
                pst = con.prepareStatement(sql);
                pst.setString(1, name);
                pst.setString(2, address);
                pst.setString(3, number);
                pst.setInt(4, Integer.parseInt(role));
                pst.setInt(5, id);
                int a = pst.executeUpdate();
                rs.close();
                pst.close();
                con.close();
                return (a>0);
            }
        }catch(Exception e){
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
    public static boolean deleteEmployee(int id){
        try{
            con = db.openConnection();
            String sql = "UPDATE [Restaurant].[dbo].[User]\n" +
                "set role_Id = 0 \n" +
                "where [user_id] = ?";
            if(con != null){
                pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                int a = pst.executeUpdate();
                rs.close();
                pst.close();
                con.close();
                return (a>0);
            }
        }catch(Exception e){
            
        }
        return false;
    }
    
    public static int getMaxEmployees() {
        List<Employee> listE = new ArrayList<>();
        try {
            String sql = "SELECT TOP 1  [user_id]\n" +
                "FROM [Restaurant].[dbo].[User] as u\n" +
                "ORDER BY  [user_id] DESC";
            //DBConnect db = DBConnect.getInstance();
            con = db.openConnection();
            if(con != null){ 
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                rs.next();
                int num = rs.getInt(1);
                rs.close();
                pst.close();
                con.close();
                return num;
            }
        }catch (Exception e){
            
        }
        return 0;
    }
    
    public static boolean AddEmployee(String name, String address, String number, String role){
        try{
            int numid = getMaxEmployees()+1;
            con = db.openConnection();
            String sql = "INSERT INTO [dbo].[User]\n" +
                    "           ([User_id] ,[password] ,[full_name] ,[Address] ,[phone_number] ,[role_id])\n" +
                    "     VALUES (?,?,?,?,?,?)";
            if(con != null){
                pst = con.prepareStatement(sql);
                pst.setInt(1, numid);
                pst.setString(2, "abc123");
                pst.setString(3, name);
                pst.setString(4, address);
                pst.setString(5, number);
                pst.setInt(6, Integer.parseInt(role));            
                int a = pst.executeUpdate();
                rs.close();
                pst.close();
                con.close();
                return (a>0);
            }
        }catch(Exception e){
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
