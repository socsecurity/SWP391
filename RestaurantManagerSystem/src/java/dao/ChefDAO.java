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
    }
}
