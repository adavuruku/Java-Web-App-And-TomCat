/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SHERIFF
 */
public class DBOperation {
    public static Connection getConnection(){
        Connection conn = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testreport?zeroDateTimeBehavior=convertToNull", "root","");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    public static boolean createTeam(String name, String rank,
            String team){
        boolean status = false;
        try {
            Connection conn =null;
            conn = getConnection();
            String SQL = "INSERT INTO testjavaee "
                    + " (playerName,playerTeam,playerRole)"
                    + " VALUES (?,?,?)";
            PreparedStatement pst = conn.prepareStatement(SQL);
            pst.setString(1,name); 
            pst.setString(2,rank);
            pst.setString(3,team);
            int re = pst.executeUpdate();
            if(re >=1){
                status = true;
            }
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;
    }

    public ArrayList loadAllPlayers(String userId) {
       ArrayList<Testjavaee> ourflight = new ArrayList<Testjavaee>();
       try {
            Connection conn =null;
            conn = getConnection();
            PreparedStatement pst = conn.prepareStatement("Select * from  qualprof where docid=? order by id desc");
            pst.setString(1, userId);
            ResultSet rs = pst.executeQuery();
            Testjavaee ft = null;
            while(rs.next()){
                ft = new Testjavaee(rs.getString("playerRank"),rs.getString("playerName"),rs.getString("playerTeam"));
                ourflight.add(ft);
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ourflight;
    }
}
