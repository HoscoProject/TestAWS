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
        String mysql = "C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysql";
        String dbUser = "root";
        String dbPass = "15021993";

        File file = new File("myfile.sql");
        String dirPath = file.getAbsoluteFile().getParentFile().getAbsolutePath() + "/SqlFile/myfile.sql";
        System.out.println(dirPath);

        createDB(dbName);
        String[] executeCmd = new String[]{mysql, "--user=" + dbUser, "--password=" + dbPass, dbName, "-e", "source " + dirPath};
        //String[] executeCmd = new String[]{mysql, "--user=" + dbUser, "--password=" + dbPass, dbName,"-e", " source "+restorePath};  
        Process runtimeProcess;
        try {
            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {
                System.out.println("Backup restored successfully");
            } else {
                System.out.println("Loi cmnr");
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public  void createDB(String dbName) {
        try {
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.8:3306/?user=root&password=15021993");
            Statement s = conn.createStatement();
            int Result = s.executeUpdate("CREATE DATABASE " + dbName);
            System.out.println(Result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
