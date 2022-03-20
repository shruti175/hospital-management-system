/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseOperation {

    private static Connection connection;

    public static Connection getConnection() {
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","shruti","shruti175");
        }
        catch(Exception ex){
            System.out.println("  "+ex);
        }
        return connection;
    }
    
    
}