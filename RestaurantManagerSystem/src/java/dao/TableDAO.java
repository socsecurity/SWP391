/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbcontext.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Table;
/**
 *
 * @author Admin
 */
public class TableDAO {
    static Connection con = null;
    static PreparedStatement stm = null;
    static ResultSet rs = null;
     public static List<Table> getAllTables(){
        List<Table> listF = new ArrayList<>();
        try {
            String sql = "Select * from tbl_Table";
            DBConnect db = DBConnect.getInstance();
            if(con!=null){
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while(rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getNString(2);
                    String status = rs.getNString(3);
                    Table nf = new Table(id, name, status);
                    listF.add(nf);
                }
                return listF;
            }
        } catch (Exception e) {
        }
        return null;
    }
     
     
     public static void main(String[] args) {
        List<Table> lt = getAllTables();
        for(Table item : lt){
            System.out.println(item.toString());
        }
    
    }
}
