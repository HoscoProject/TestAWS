/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hosco.controller;

import com.hosco.model.Customer;
import com.hosco.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author MtViet
 */
@Controller
@RequestMapping(value = "/manager")
public class Manager {

    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public String getAllUser(ModelMap m) {
        List<Customer> list = new ArrayList<Customer>();
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        list.add(new Customer("123", "345", 789));
        m.put("listUser", list);
        m.put("customer", new Customer());
        return "user_management";
    }
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/edit/{id}",method=RequestMethod.GET)
    public String removePerson(@PathVariable("id") String id) {
        return "login";
    }
}
