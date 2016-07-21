/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosco.controller;

import com.hosco.db.DatabaseConnection;
import com.hosco.db.DatabaseCreation;
import com.hosco.model.Customer;
import com.hosco.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MtViet
 */
@Controller
@RequestMapping(value = "/register")
public class Register {
    
    private final DatabaseConnection db = new DatabaseConnection();
    
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(ModelMap m)
    {              
        DatabaseCreation db1 = new DatabaseCreation();
        db1.create("mtviet");
        m.addAttribute("user",new User());
        return "register";
    }
    
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(value = "user") User user,ModelMap m)
    {
        boolean b = db.insertUser(user);
        if(!b)
        {
            m.put("result", "Đăng ký thất bại");
            return "register";
        }
        else
        {
            return "success";
        }
        
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(ModelMap m)
    {
        m.addAttribute("userLogin",new User());
        return "login";
    }
    
    @RequestMapping(value = "/checkLogin",method = RequestMethod.POST)
    public String checkLogin(@ModelAttribute(value = "userLogin") User user,ModelMap m)
    {
        boolean b = db.checkLogin(user);
        if(!b)
        {
            m.put("result", "Đăng nhập thất bại");
            return "login";
        }
        m.put("customer", new Customer());
        List<Customer> list = new ArrayList<Customer>();
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        m.put("listUser", list);
        return "user_management";
    }
    
    @RequestMapping("/edit/{id}")
    public String removePerson(@PathVariable("id") String id) {
        return "";
    }
    
    
}
