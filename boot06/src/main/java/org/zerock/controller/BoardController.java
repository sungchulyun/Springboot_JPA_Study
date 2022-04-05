package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.zerock.entity.Board;
import org.zerock.service.BoardService;

@Controller
public class BoardController {

    @Autowired
    BoardService boardservice;

    @GetMapping("/index")
    public String welcome(){

        return "/index";
    }

    @GetMapping("/write")
    public String write(){

        return "/write";
    }

    @PostMapping("/writepro")
    public String writePro(Board board){

        boardservice.boardwrite(board);

        return "redirect:/write";
    }

    @GetMapping("/list")
    public String list(Model model, Board board){


        return "list";
    }
}
