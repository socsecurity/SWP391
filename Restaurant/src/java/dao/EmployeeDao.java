/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Employee;
import helper.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class EmployeeDao {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement stm = null;
    public Employee Login(int user, String password){
        try{
            String sql = "Select * from Employee where [empId] = ? "
                    + "and [password] = ?";
            conn = DBUtils.makeConnection();
            if(conn!=null){
                stm = conn.prepareStatement(sql);
                stm.setInt(1, user);
                stm.setString(2, password);
                rs = stm.executeQuery();
                while(rs.next()){
                    int id = rs.getInt(1);
                    String email = rs.getNString(2);
                    String pass = rs.getNString(3);
                    String fullName = rs.getNString(4);
                    int phoneNumber = rs.getInt(5);
                    int roleId = rs.getInt(6);
                    Employee a = new Employee(id, email, pass, fullName, 
                            phoneNumber,roleId);
                    return a;
                }
            }
        }catch(Exception e){
        }
        return null;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeDao dao = new EmployeeDao();
        int user = 3;
        String password = "199";
        
        Employee a = dao.Login(user, password);
        System.out.println(a.toString());
        
    }
    
}
