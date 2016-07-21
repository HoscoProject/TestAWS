/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MtViet
 */
@Controller
@RequestMapping(value="/manager")
public class Manager {
    
    @RequestMapping(value="/allUser",method= RequestMethod.GET)
    public String getAllUser(ModelMap m)
    {
        m.put("listUser", "");
        return "user_management";
    }
    
}
