/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class DBManagement {
    private static final String DBDriver="com.mysql.jdbc.Driver";
    private static final String DBUrl="jdbc:mysql://localhost:3306/education_hub";
    private static final String DBUsername="root";
    private static final String DBPassword="";
    private static Connection con=null;
    private static Statement stm=null;
            
    private static void openConnection() throws Exception {      
        Class.forName(DBDriver);
    con=DriverManager.getConnection(DBUrl, DBUsername, DBPassword);
    stm=con.createStatement();
    }
    public static int executeUpdate(String sql) throws Exception{
        openConnection();
        return stm.executeUpdate(sql);
    }
    
    public static ResultSet executeQuery(String sql) throws Exception{
     openConnection();
    
    return stm.executeQuery(sql);
            }
}

