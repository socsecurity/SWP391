/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDetailList {
    static List<OrderDetail> listO = new ArrayList<OrderDetail>();

    public static List<OrderDetail> getListO() {
        return listO;
    }

    public static void setListO(List<OrderDetail> listO) {
        OrderDetailList.listO = listO;
    }
    
    
    
    public static void addOrder(OrderDetail or){
        listO.add(or);
    }
    
    public static void deleteOrder(OrderDetail or){
        listO.remove(or);
    }
    
    public static void print(){
        for(OrderDetail o:listO){
            System.out.println(o.toString());
        }
    }
}
