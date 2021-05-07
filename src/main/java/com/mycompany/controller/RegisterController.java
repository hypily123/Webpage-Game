/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.me.dao.UserDAO;
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
public class RegisterController {

    @RequestMapping(value = "/Register.htm", method = RequestMethod.POST)
    public ModelAndView GM_Main(HttpServletRequest request, HttpServletResponse response, UserDAO userDAO) {
        String un = (String) request.getParameter("username");
        String pw = (String) request.getParameter("password");
        String pw2 = (String) request.getParameter("password2");
        if (!pw.equals(pw2)) {
            return new ModelAndView("Register", "msg", "passwords did not match");
        } else try {
            userDAO.searchUser(un);
            return new ModelAndView("Register", "msg", "username has been taken");
        } catch (Exception e) {
            userDAO.addUser(un, pw);
            request.getSession().setAttribute("user", userDAO.searchUser(un));
            return new ModelAndView("Player_Welcome");
        }
    }

    @RequestMapping(value = "/Register.htm", method = RequestMethod.GET)
    public ModelAndView GM_Main_Get(HttpServletRequest request, HttpServletResponse response) {
        request.removeAttribute("user");
        return new ModelAndView("Register");
    }
}
