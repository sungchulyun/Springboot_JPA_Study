package org.zerok.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerok.domain.SampleVO;

@RestController
public class SampleController {

    @GetMapping("/sample1")
    public void sample1(Model model){

        model.addAttribute("greeting", "Hello World");

    }
}
