/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelper;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author SHERIFF
 */
public class ConnectionPool {
    private static ConnectionPool pool= null;    
    private static DataSource dataSource= null;

    private ConnectionPool(){
        try {
            InitialContext ic = new InitialContext();
            dataSource = (DataSource) ic.lookup("java:comp/env/jdbc/testreport");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static synchronized ConnectionPool getInstance(){
        if(pool==null){
            pool = new ConnectionPool();
        }
        return pool;
    }
    
    public Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (Exception e) {
            return null;
        }
    }
    
    public void freeConnection(Connection c){
        try {
            c.close();
        } catch (Exception e) {
        }
    }
    
}
