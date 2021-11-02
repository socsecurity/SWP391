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
import model.Employee;

/**
 *
 * @author Quan Nguyen
 */
public class EmployeeDAO {
    static Connection con = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;

    public static List<Employee> getAllEmployees() {
        List<Employee> listE = new ArrayList<>();
        try {
            String sql = "Select * from tbl_Role";
            DBConnect db = DBConnect.getInstance();
            if(con != null){
                con = db.openConnection();
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getNString(2);
                    String number = rs.getNString(3);
                    String role = rs.getNString(4);
                    Employee ep = new Employee(id, name, number, role);
                    listE.add(ep);
                }
                return listE;
            }
        }catch (Exception e){
            
        }
        return null;
    }
    
    public static void main(String[]args){
        List<Employee> lt = getAllEmployees();
        for(Employee item : lt){
            System.out.print(item.toString());
        }
    }
}
