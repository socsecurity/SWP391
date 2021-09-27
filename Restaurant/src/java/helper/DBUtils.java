/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Asus
 */
public class DBUtils {
    public static Connection makeConnection() throws Exception{
        String connectUrl = "jdbc:sqlserver://localhost:1433;"
                +"databaseName=Restaurant;User=sa;Password=123456";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(connectUrl);
        return con;
    }
    public static void main(String[] args) throws Exception {
        System.out.println(new DBUtils().makeConnection());
    }
}
