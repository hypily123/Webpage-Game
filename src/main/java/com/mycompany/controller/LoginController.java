/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.me.dao.UserDAO;
import com.mycompany.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Jian Xiao
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/Login.htm", method = RequestMethod.POST)
    public ModelAndView Login_Main(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO) {
        String un = (String) request.getParameter("username");
        String pw = (String) request.getParameter("password");
        User user;
        try {
            user = userDAO.searchUser(un);
        } catch (Exception e) {
            return new ModelAndView("Login", "msg", "No Such User");
        }
        if (user.getPassword().equals(pw)) {
            request.getSession().setAttribute("user", user);
            String role = user.getRole();
            switch (role) {
                case "player":
                    return new ModelAndView("Player_Welcome");
                case "GM":
                    return new ModelAndView("GM_Welcome");
            }
        } else {
            return new ModelAndView("Login", "msg", "Wrong Username or Password");
        }
        return new ModelAndView("Login", "msg", "Something Wrong");
    }

    @RequestMapping(value = "/Login.htm", method = RequestMethod.GET)
    public ModelAndView Login_Main_Get(HttpServletRequest request, HttpServletResponse response) {
        request.removeAttribute("user");
        return new ModelAndView("Login");
    }
}
