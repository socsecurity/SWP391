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
    String status = "PROCESSING";

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ChefOrder(int OrderID, String TableName, Date date, String status) {
        this.OrderID = OrderID;
        this.TableName = TableName;
        this.date = date;
        this.status = status;
    }

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
