/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosco.db;

import com.hosco.model.User;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.*;

/**
 *
 * @author MtViet
 */
public class DatabaseConnection {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://192.168.0.8:3306/hosco_crm";
    Connection conn = null;
    Statement stmt = null;

    public DatabaseConnection() {

    }

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, "root", "15021993");
        } catch (Exception ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public boolean insertUser(User user) {
        try {
            stmt = getConnection().createStatement();
            stmt.executeUpdate("insert into  user values ('" + user.getUsername() + "','" + user.getPassword() + "'," + user.getGroup() + ")");
        } catch (SQLException ex) {
            return false;
        } finally {
            close();
        }
        return true;
    }

    public boolean checkLogin(User user) {
        try {
            stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from user where username = '" + user.getUsername() + "' AND password='" + user.getPassword() + "'");
            int i = 0;
            while (rs.next()) {
                i++;
            }
            if(i > 0)
            {
                return true;
            }            
            
        } catch (SQLException ex) {
            return false;
        } finally {
            close();
        }
        return false;
    }

    public ArrayList<User> getAllUser() {
        String sql = "SELECT * FROM user";
        ArrayList<User> list = new ArrayList<>();
        try {
            stmt = getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            User user;
            while (rs.next()) {
                user = new User(rs.getString("username"), rs.getString("password"), rs.getInt("group"));
                list.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close();
        }
        return list;
    }

    private void close() {
        try {

            if (stmt != null) {
                stmt.close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {

        }
    }

//    public List<User> getAllUser()
//    {   
//        Session session = sessionFactory.openSession();
//        List<User> users = null;
//        try{
//            users = session.createQuery("select * from user").list();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }        
//        return users;
//    }
//    
//    public void insertUser(User user)
//    {
//        Session session = sessionFactory.openSession();
//        Transaction transaction;
//        transaction = session.beginTransaction();
//        boolean status = false;
//        try{
//            session.save(user);
//            session.getTransaction().commit();          
//            
//        }catch(Exception e){
//            transaction.rollback();
//            e.printStackTrace();
//        }
//        finally {
//            session.close();
//        }
//    }
}
