/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbcontext.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChefOrder;

/**
 *
 * @author xuanc
 */
public class DashboardDAO {
    public int getNewClients() {
        int newClients = 0;

        DBConnect db = DBConnect.getInstance();
        String sql = "SELECT COUNT(*) FROM [User]";
        
        try {
            Connection con = db.openConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            newClients  = rs.getInt(1);
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newClients;
    }
    
    public int getEmptyTable() {
        int emptyTable = 0;
        DBConnect db = DBConnect.getInstance();
        
        String sql = "SELECT COUNT(*) FROM [tbl_Table] WHERE status = 'NOT AVAILABLE'";
        try {
            Connection con = db.openConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            emptyTable  = rs.getInt(1);
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return emptyTable;
    }
    
    public int getInvoices() {
        int invoices = 0;
        DBConnect db = DBConnect.getInstance();
        
        String sql = "SELECT COUNT(DISTINCT order_id) FROM [Order_detail]";
        
        try {
            Connection con = db.openConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            invoices  = rs.getInt(1);
            rs.close();
            stmt.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(DashboardDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return invoices;
    }
    
    public List<ChefOrder> getListOrderWithPrice(){
        DBConnect db = DBConnect.getInstance();
        
        List<ChefOrder> lu = new ArrayList<>();
        
        String sql = "SELECT TOP 8 o.order_id, name, date, o.status, total\n" +
            "FROM tbl_Order as o\n" +
            "	INNER JOIN tbl_Table as t on o.table_id = t.table_id\n" +
            "	INNER JOIN (SELECT Order_detail.order_id, SUM(Order_detail.quantity * Product.Price) AS 'total' \n" +
            "					FROM Order_detail JOIN Product ON Order_detail.product_id = Product.Product_id\n" +
            "					GROUP BY Order_detail.order_id) as ts on o.order_id = ts.order_id\n" +
            "ORDER BY date DESC";
        
        try {
            Connection con = db.openConnection();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                int orderid = rs.getInt(1);
                String tablenbame = rs.getString(2);
                Date date = rs.getDate(3);
                String status = rs.getString(4);
                int total = rs.getInt(5);
                ChefOrder tempM = new ChefOrder(orderid, tablenbame, date, status, total);
                lu.add(tempM);
            }
            rs.close();
            stmt.close();
            con.close();
                       
        } catch (Exception ex) {
            Logger.getLogger(ChefDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lu;
    }
}
