/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import DBHelper.ConnectionPool;
import DBHelper.Testjavaee;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SHERIFF
 */
@WebServlet(name = "FirstServlet",loadOnStartup=1, urlPatterns = {"/displayPlayers", "/addPlayers"})
public class FirstServlet extends HttpServlet {
    String userPath = null;
    
    Connection con = ConnectionPool.getInstance().getConnection();
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       userPath = request.getServletPath();
       if(userPath.equals("/displayPlayers")){
            String url = "/DisplayPlayers.jsp";
            try{
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM Testjavaee");
                ArrayList<Testjavaee> player = new ArrayList<Testjavaee>();
                while(rs.next()){
                    player.add(new Testjavaee(rs.getString("playerRank"),rs.getString("playerTeam"),rs.getString("playerName") ));
                }
                
                request.setAttribute("playerList", player);
                getServletContext().getRequestDispatcher(url).forward(request, response);
               // emf.close();
            }catch(Exception ex){
                ex.printStackTrace();
            }
           
        }
       
       userPath = request.getServletPath();
       if(userPath.equals("/addPlayers")){
            String url = "/addPlayers.jsp";
            try{
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        userPath = request.getServletPath();
        String err,url="/displayPlayers";
       if(userPath.equals("/addPlayers")){
            try {
                String SQL = "INSERT INTO Testjavaee "
                    + " (playerName,playerRank,playerTeam)"
                    + " VALUES (?,?,?)";
                PreparedStatement pst = con.prepareStatement(SQL);
                pst.setString(1,request.getParameter("playerName")); 
                pst.setString(2,request.getParameter("playerRank"));
                pst.setString(3,request.getParameter("playerTeam"));
                int re = pst.executeUpdate();
                if(re >=1){
//                    getServletContext().getRequestDispatcher(url).forward(request, response);
                    response.sendRedirect(request.getContextPath() + url);
                }
           } catch (Exception e) {
               
           }
       }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
