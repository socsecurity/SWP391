/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Quan Nguyen
 */
public class Employee {
    int empID;
    String name;
    String role;
    String number;
    
    public Employee(int empID, String name, String role, String number){
        this.empID = empID;
        this.name = name;
        this.role = role;
        this.number = number;
    }
    
    public int getEmpID(){
        return empID;
    }
    
    public void setEmpID(int empID){
        this.empID = empID;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getNumber(){
        return number;
    }
    
    public void setNumber(String number){
        this.number = number;
    }
    
    public String getRole(){
        return role;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    @Override
    public String toString(){
        return "Employee{" + "empID = " + empID + ", name = " + name + ", number = " + number + ", role = " + role;
    }
    
}
