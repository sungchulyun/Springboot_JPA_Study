package com.example.boot8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public void login(){

    }

    @GetMapping("/accessDenied")
    public void accessDenied(){

    }

    @GetMapping("/logout")
    public void logout(){

    }
}
