package org.zerock.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebBoardController {

    @GetMapping("/index")
    public String welcome(){

        return "/index";
    }

    @GetMapping("/write")
    public String write(){

        return "/write";
    }

    @PostMapping("/writepro")
    public String writePro(){


        return "redirect:/write";
    }
}
