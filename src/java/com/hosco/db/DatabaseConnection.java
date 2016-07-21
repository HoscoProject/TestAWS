/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosco.db;

import com.hosco.model.User;
import java.util.List;
import org.hibernate.*;

/**
 *
 * @author MtViet
 */
public class DatabaseConnection {
    
    private SessionFactory sessionFactory;
    
    public List<User> getAllUser()
    {
        Session session = sessionFactory.openSession();
        List<User> users = null;
        try{
            users = session.createQuery("select * from user").list();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        
        return users;
    }
    
}
