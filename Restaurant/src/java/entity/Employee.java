/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Admin
 */
public class Employee {
    /*
    [empId] [nchar](15) NOT NULL,
	[email] [nchar](30) NULL,
	[password] [nchar](10) NOT NULL,
	[fullName] [nvarchar](50) NOT NULL,
	[phoneNumber] [int] NULL,
	[roleId] [int](15) NOT NULL,
    */
    private int empId;
    private String email;
    private String password;
    private String fullName;
    private int phoneNumber;
    private int roleId;

    public Employee(int empId, String email, String password, String fullName, int phoneNumber, int roleId) {
        this.empId = empId;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.roleId = roleId;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", email=" + email + ", password=" + password + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber + ", roleId=" + roleId + '}';
    }
    
    
    
    
    
}
