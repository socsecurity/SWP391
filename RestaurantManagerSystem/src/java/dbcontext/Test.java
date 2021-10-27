/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbcontext;

import dao.ChefDAO;
import java.util.List;
import model.ChefOrder;


public class Test {
    
    public static void main(String[] args) {
        ChefDAO cdao = new ChefDAO();
        List<ChefOrder> lu = cdao.getAll();
        System.out.println(lu.toString());
    }
}
