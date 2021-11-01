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
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChefOrder;
import model.ChefOrderDetail;

/**
 *
 * @author xuanc
 */


public class ChefDAO {
    public List<ChefOrder> getAll() {
        
        DBConnect db = DBConnect.getInstance();
        
        List<ChefOrder> lu = new ArrayList<>();
        
        String sql = "select [order_id] , [name], [date]\n" +
            "from tbl_Order as o\n" +
            "	inner join tbl_Table as t on t.table_id = o.table_id\n" +
            "where o.status = 'PROCESSING'\n" +
            "order by date DESC";
        
        try {
            Connection con = db.openConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                int orderid = rs.getInt(1);
                String tablenbame = rs.getString(2);
                Date date = rs.getDate(3);
                
                ChefOrder tempM = new ChefOrder(orderid, tablenbame, date);
                lu.add(tempM);
            }
            rs.close();
            stmt.close();
            con.close();
                       
        } catch (Exception ex) {
            Logger.getLogger(ChefDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return lu;
    } // end 
    
    public List<ChefOrderDetail> getDetailByOrderID(int id) {  
        DBConnect db = DBConnect.getInstance();
        List<ChefOrderDetail> lcod = new ArrayList();
        
        String sql = "select [name], [quantity] \n" +
            "from order_detail as od\n" +
            "	inner join Product as p on p.Product_id = od.product_id\n" +
            "where od.order_id = ?";
        
        try {
            Connection con = db.openConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                String proName = rs.getString(1);
                int quantity = rs.getInt(2);
                
                ChefOrderDetail tempM = new ChefOrderDetail(proName, quantity);
                lcod.add(tempM);
            }
            rs.close();
            stmt.close();
            con.close();
                       
        } catch (Exception ex) {
            Logger.getLogger(ChefDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return lcod;
    }
    
    public List<ChefOrder> getDoneHistory() {
        
        DBConnect db = DBConnect.getInstance();
        
        List<ChefOrder> lu = new ArrayList<>();
        
        String sql = "select [order_id] , [name], [date], o.status\n" +
            "from tbl_Order as o\n" +
            "	inner join tbl_Table as t on t.table_id = o.table_id\n" +
            "where o.status = 'CANCELED' OR o.status = 'COMPLETE'\n" +
            "order by date DESC";
        
        try {
            Connection con = db.openConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                int orderid = rs.getInt(1);
                String tablenbame = rs.getString(2);
                Date date = rs.getDate(3);
                String status = rs.getString(4);
                ChefOrder tempM = new ChefOrder(orderid, tablenbame, date, status);
                lu.add(tempM);
            }
            rs.close();
            stmt.close();
            con.close();
                       
        } catch (Exception ex) {
            Logger.getLogger(ChefDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return lu;
    } // end 
}
