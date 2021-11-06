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
import model.Product;

/**
 *
 * @author xuanc
 */
public class ProductDAO {
    static Connection con = null;
    static PreparedStatement pst = null;
    static ResultSet rs = null;
    static DBConnect db = DBConnect.getInstance();

    public static List<Product> getAllProductAvailable() {
        List<Product> listP = new ArrayList<>();
        try {
            String sql = "SELECT [Product_id], p.[name], [Status], [Price], c.name as Category\n" +
                "FROM [Restaurant].[dbo].[Product] AS p\n" +
                "INNER JOIN Category as c ON c.Category_id = p.Category_id";
            //DBConnect db = DBConnect.getInstance();
            con = db.openConnection();
            if(con != null){ 
                pst = con.prepareStatement(sql);
                rs = pst.executeQuery();
                while(rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getNString(2);
                    String status = rs.getString(3);
                    int price = rs.getInt(4);
                    String category = rs.getNString(5);
                    Product ep = new Product(id, name, category, status, price);
                    listP.add(ep);
                }
                rs.close();
                pst.close();
                con.close();
                return listP;
            }
        }catch (Exception e){
            
        }
        return null;
    }
    
    public static boolean AddProduct(int id, String name, String category, int price, String status){
        try {
            String sql = "insert into [dbo].[Product] values(?, ?, ?, ?, ?)";
            con = db.openConnection();
            if(con!=null){
                pst = con.prepareStatement(sql);
                
                pst.setInt(1, id);
                pst.setString(2, name);
                pst.setString(3, status);
                pst.setInt(4, price);
                pst.setString(5, category);
                
                pst.executeUpdate();
                return true;
            }
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    public static boolean UpdateProduct(int id, String name, String category, int price, String status){
        try {
            String sql = "update [dbo].[Product] set [name]=?, [Status]=?, \n" +
                            "[Price]=?, [Category_id]=?\n" +
                            "where [Product_id]=?";
            con = db.openConnection();
            if(con!=null){
                pst = con.prepareStatement(sql);
                
                
                pst.setString(1, name);
                pst.setString(2, status);
                pst.setInt(3, price);
                pst.setString(4, category);
                pst.setInt(5, id);
                
                pst.executeUpdate();
                return true;
            }
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
    
    
}
