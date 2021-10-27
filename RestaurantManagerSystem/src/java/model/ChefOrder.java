/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author xuanc
 */
public class ChefOrder {
    int OrderID;
    String TableName;
    Date date; 

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public String getTableName() {
        return TableName;
    }

    public void setTableName(String TableName) {
        this.TableName = TableName;
    }

    public Date getDate() {
        return date;
    }
    
    public String getDateFormat() {
        String oldstring = date.toString();
        LocalDateTime datetime = LocalDateTime.parse(oldstring, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S"));
        String newstring = datetime.format(DateTimeFormatter.ofPattern("HH:mm - dd-MM-yyyy"));
        return newstring;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ChefOrder() {
    }

    public ChefOrder(int OrderID, String TableName, Date date) {
        this.OrderID = OrderID;
        this.TableName = TableName;
        this.date = date;
    }
    
}
