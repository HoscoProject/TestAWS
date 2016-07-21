/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosco.controller;

import com.hosco.db.DatabaseConnection;
import com.hosco.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MtViet
 */
@Controller
@RequestMapping(value = "/register")
public class Register {
    
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register(ModelMap m)
    {
        DatabaseConnection db = new DatabaseConnection();
        db.getAllUser();
        m.addAttribute("user",new User());
        return "register";
    }
    
    @RequestMapping(value = "/registerUser",method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(value = "user") User user,ModelMap m)
    {
        m.put("user", user);
        return "success";
    }
    
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(ModelMap m)
    {
        m.addAttribute("userLogin",new User());
        return "login";
    }
    
}
