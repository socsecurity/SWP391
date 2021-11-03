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
import model.OrderDetail;
import model.Table;
/**
 *
 * @author Admin
 */
public class TableDAO {
    static DBConnect db = DBConnect.getInstance();
    static Connection con = null;
    static PreparedStatement stm = null;
    static ResultSet rs = null;
    public static List<Table> getAllTables(){
        List<Table> listF = new ArrayList<>();
        try {
            String sql = "Select * from tbl_Table";
            con = db.openConnection();
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
    
    public static List<OrderDetail> listOrderDetail(int tid){
        List<OrderDetail> listO = new ArrayList<>();
        String sql = "select * from [dbo].[Order_detail]\n" +
                        "where order_id = (select order_id from [dbo].[tbl_Order]\n" +
                        "where status='PROCESSING' and table_id = ?)";
        try {
            
            con = db.openConnection();
            if(con!=null){
                stm = con.prepareStatement(sql);
                stm.setInt(1, tid);
                rs = stm.executeQuery();
                while(rs.next()){
                    int oid = rs.getInt(1);
                    int pid = rs.getInt(2);
                    int quantity = rs.getInt(3);
                    int price = getProductPrice(pid);
                    String name = getProductName(pid);
                    OrderDetail newOrderDetail = new OrderDetail(oid, pid, name,quantity,price);
                    listO.add(newOrderDetail);
                }
                return listO;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static List<OrderDetail> listOrderDetailCreate(int tid){
        List<OrderDetail> listO = new ArrayList<>();
        String sql = "select * from [dbo].[Order_detail]\n" +
                        "where order_id = (select order_id from [dbo].[tbl_Order]\n" +
                        "where status='CREATED' and table_id = ?)";
        try {
            
            con = db.openConnection();
            if(con!=null){
                stm = con.prepareStatement(sql);
                stm.setInt(1, tid);
                rs = stm.executeQuery();
                while(rs.next()){
                    int oid = rs.getInt(1);
                    int pid = rs.getInt(2);
                    int quantity = rs.getInt(3);
                    int price = getProductPrice(pid);
                    String name = getProductName(pid);
                    OrderDetail newOrderDetail = new OrderDetail(oid, pid, name,quantity,price);
                    listO.add(newOrderDetail);
                }
                return listO;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static int getOrderID(int table_id){
        Connection con2 = null;
        PreparedStatement stm2 = null;
        ResultSet rs2 = null;
        try {
            String sql = "select order_id from [dbo].[tbl_Order]\n" +
                            "where status='CREATED' and table_id = " + table_id;
            con2 = db.openConnection();
            if(con2!=null){
                int order_id = 0;
                stm2 = con2.prepareStatement(sql);
                rs2 = stm2.executeQuery();
                while(rs2.next()){
                    order_id = rs2.getInt(1);
                }
                if(order_id == 0){
                    insertOrderCreate(table_id);
                    return NganHa(table_id);
                }
                return order_id;
            }
        } catch (Exception e) {
        }
        return -1;
    }
    
    public static void insertOrderCreate(int table_id){
        try {
            DBConnect db4 = DBConnect.getInstance();
            Connection con4 = null;
            PreparedStatement stm4 = null;
            con4 = db4.openConnection();
            String sql = "INSERT [dbo].[tbl_Order] ([date], [status], [table_id], [user_id]) \n" +
                            "VALUES (GETDATE(), N'CREATED', ?, 2)";
            if(con4!=null){
                stm4 = con4.prepareStatement(sql);
                stm4.setInt(1, table_id);
                stm4.executeUpdate();
            }
        } catch (Exception e) {
        }
    }
    public static int NganHa(int table_id){
        try {
            DBConnect db4 = DBConnect.getInstance();
            Connection con4 = null;
            PreparedStatement stm4 = null;
            ResultSet rs4 = null;
            con4 = db4.openConnection();
            String sql = "select order_id from [dbo].[tbl_Order] where status='CREATED' and table_id = ?";
            if(con4!=null){
                int order_id = -10;
                stm4 = con4.prepareStatement(sql);
                stm4.setInt(1, table_id);
                rs4 = stm4.executeQuery();
                while(rs4.next()){
                    order_id = rs4.getInt(1);
                }
                return order_id;
            }
            
        } catch (Exception e) {
        }
        return -3;
    }
    
    
    public static int getOrderIDProcess(int table_id){
        Connection con2 = null;
        PreparedStatement stm2 = null;
        ResultSet rs2 = null;
        try {
            String sql = "select order_id from [dbo].[tbl_Order]\n" +
                            "where status='PROCESSING' and table_id = " + table_id;
            con2 = db.openConnection();
            if(con2!=null){
                int order_id = 0;
                stm2 = con2.prepareStatement(sql);
                rs2 = stm2.executeQuery();
                while(rs2.next()){
                    order_id = rs2.getInt(1);
                }
                if(order_id == 0){
                    insertOrderCreate(table_id);
                    return NganHa(table_id);
                }
                return order_id;
            }
        } catch (Exception e) {
        }
        return -1;
    }
    
    public static int getProductPrice(int id){
        Connection con2 = null;
        PreparedStatement stm2 = null;
        ResultSet rs2 = null;
        try {
            String sql = "select [Price] from [dbo].[Product] where [Product_id] = " + id;
            con2 = db.openConnection();
            if(con2!=null){
                int price = 0;
                stm2 = con2.prepareStatement(sql);
                rs2 = stm2.executeQuery();
                while(rs2.next()){
                    price = rs2.getInt(1);
                }
                return price;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public static String getProductName(int id){
        Connection con1 = null;
        PreparedStatement stm1 = null;
        ResultSet rs1 = null;
        try {
            String sql = "select [name] from [dbo].[Product] where [Product_id] = " + id;
            con1 = db.openConnection();
            if(con1!=null){
                String name = "";
                stm1 = con1.prepareStatement(sql);
                rs1 = stm1.executeQuery();
                while(rs1.next()){
                    name = rs1.getNString(1);
                }
                return name;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    public static int NumberOfProduct(int order_id){
        DBConnect db1 = DBConnect.getInstance();
        Connection con1 = null;
        PreparedStatement stm1 = null;
        ResultSet rs1 = null;
        try {
            String sql = "select count (*) from [dbo].[Order_detail] where order_id = " + order_id;
            con1 = db1.openConnection();
            if(con1!=null){
                int number = 0;
                stm1 = con1.prepareStatement(sql);
                rs1 = stm1.executeQuery();
                while(rs1.next()){
                    number = rs1.getInt(1);
                }
                return number;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public static int getTotal(int order_id){
        Connection con1 = null;
        PreparedStatement stm1 = null;
        ResultSet rs1 = null;
        try {
            String sql = "select sum(total)from(\n" +
"	select quantity * Price as total \n" +
"	from [dbo].[Order_detail] a inner join [dbo].[Product] b on a.product_id = b.Product_id\n" +
"	where order_id = ?)total";
            con1 = db.openConnection();
            if(con1!=null){
                int number = 0;
                stm1 = con1.prepareStatement(sql);
                stm1.setInt(1, order_id);
                rs1 = stm1.executeQuery();
                while(rs1.next()){
                    number = rs1.getInt(1);
                }
                return number;
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public static boolean AddOrder(int order_id, int pid, int quantity){
        try {
            con = db.openConnection();
            String sql = "insert into [dbo].[Order_detail] values (?,?,?)";
            if(con!=null){
                stm = con.prepareStatement(sql);
                stm.setInt(1, order_id);
                stm.setInt(2, pid);
                stm.setInt(3, quantity);
                stm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    public static void resetTable(int tid){
        String sql = "update [dbo].[tbl_Table] set [status] = 'AVAILABLE' where [table_id] = ?\n" +
                    "update [dbo].[tbl_Order] set [status] = 'COMPLETE' where order_id = ?";
        try {
            con = db.openConnection();
            if(con!=null){
                int order_id = getOrderIDProcess(tid);
                stm = con.prepareStatement(sql);
                stm.setInt(1, tid);
                stm.setInt(2, order_id);
                stm.executeUpdate();
            }
        } catch (Exception e) {
        }
    }
    
    public static boolean deleteOrderDetail(int oid, int pid){
        String sql = "delete from [dbo].[Order_detail] where [order_id] = ? and [product_id] = ?";
        try {
            con = db.openConnection();
            if(con!=null){
                stm = con.prepareStatement(sql);
                stm.setInt(1, oid);
                stm.setInt(2, pid);
                stm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public static void confirmOrder(int oid){
        String sql = "update [dbo].[tbl_Order] set [status] = N'PROCESSING' where [order_id] = " + oid;
        try {
            con = db.openConnection();
            if(con!=null){
                stm = con.prepareStatement(sql);
                stm.executeUpdate();
            }
        } catch (Exception e) {
        }
    }
    
    public static void changeStatusTable(int tid){
        String sql = "update [dbo].[tbl_Table] set [status] = N'NOT AVAILABLE' where [table_id] = " +tid;
        try {
            con = db.openConnection();
            if(con!=null){
                stm = con.prepareStatement(sql);
                stm.executeUpdate();
            }
        } catch (Exception e) {
        }
    }
    
    public static String checkStatus(int order_id){
        try {
            DBConnect db1 = DBConnect.getInstance();
            Connection con1 = null;
            PreparedStatement stm1 = null;
            ResultSet rs1 = null;
            con1 = db1.openConnection();
            String sql = "select [status] from [dbo].[tbl_Order] where [order_id] = " + order_id;
            if(con1!=null){
                stm1 = con1.prepareStatement(sql);
                rs1 = stm1.executeQuery();
                String status = "";
                while(rs1.next()){
                    status = rs1.getNString(1);
                }
                return status;
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    
     
     public static void main(String[] args) {
//        List<OrderDetail> lt = listOrderDetail(3);
//        for(OrderDetail item : lt){
//            System.out.println(item.toString());
//        }
        
//         System.out.println(getOrderID(8));
            //insertOrderCreate(8);
            //System.out.println(NganHa(12));
//            System.out.println(deleteOrderDetail(18,5));
//System.out.println(getOrderIDProcess(7));
            System.out.println(checkStatus(21));
    }
}
