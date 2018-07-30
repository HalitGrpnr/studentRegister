package com.ukid.studentRegister.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

public class LoginController {
    @PreAuthorize("isAnonymous()")
    @GetMapping(value = "/login")
    public ModelAndView getLoginPage(@RequestParam Optional<String> error,
                                     @RequestParam Optional<String> logout) {
        ModelAndView model = new ModelAndView();

        if(error != null)
            model.addObject("error", "Invalid UserCredential");

        if(logout != null)
            model.addObject("logout", "Logout successfully");

        model.setViewName("login");
        //return new ModelAndView("login", "error", error);
        return model;
    }

    @PostMapping("/login")
    public String afterLogin(){
        return "home";
    }
}
