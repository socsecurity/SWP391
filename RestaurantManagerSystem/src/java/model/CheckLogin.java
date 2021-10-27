/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author xuanc
 */
public class CheckLogin {
    public int checkRole(String user, String pass){
        try {
            if (user.equals("admin1996") && pass.equals("admin123")) {
                return 1;
            }
            if (user.equals("chef98731") && pass.equals("chef123")) {
                return 3;
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
