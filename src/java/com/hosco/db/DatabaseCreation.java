/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosco.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author MtViet
 */
public class DatabaseCreation {

    private  String jdbcDriver = "com.mysql.jdbc.Driver";

    public  void create(String dbName) {
        createDB("gandalf");
        CreateDBScript("gandalf");
    }

    public  void createDB(String dbName) {
        try {
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/?user=root&password=15021993");
            Statement s = conn.createStatement();
            int Result = s.executeUpdate("CREATE DATABASE " + dbName);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void CreateDBScript(String dbName){
        String scripts="CREATE TABLE customer (id varchar(50),name varchar(50),age int(11),PRIMARY KEY (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;" ;
        
        try {
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/"+dbName+"?user=root&password=15021993");
            Statement s = conn.createStatement();
            int Result = s.executeUpdate(scripts);
            System.out.println(Result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
