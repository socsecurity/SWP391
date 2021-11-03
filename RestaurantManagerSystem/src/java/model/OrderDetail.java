/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class OrderDetail {
    private int order_id;
    private int product_id;
    private String productName;
    private int quantity;
    private int price;

    public OrderDetail(int order_id, int product_id, String productName, int quantity) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.productName = productName;
        this.quantity = quantity;
    }

    public OrderDetail(int order_id, int product_id, String productName, int quantity, int price) {
        this.order_id = order_id;
        this.product_id = product_id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "order_id=" + order_id + ", product_id=" + product_id + ", productName=" + productName + ", quantity=" + quantity +  ", price=" + price + '}';
    }
    
    
   

    
}
