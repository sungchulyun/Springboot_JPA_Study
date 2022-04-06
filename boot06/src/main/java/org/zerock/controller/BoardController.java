package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String list(Model model, @RequestParam(required = false, defaultValue = "0", value = "page") int page){

        Page<Board> listPage = boardservice.list(page);

        int totalPage = listPage.getTotalPages();

        model.addAttribute("board", listPage.getContent());
        model.addAttribute("totalPage", totalPage);

        return "list";
    }

    @PostMapping ("/detail/{bno}")
    public String detail(Model model, Board board, @PathVariable Long bno){

        Board board1 = boardservice.find(bno);

        model.addAttribute("board", board1);

        return "/detail";
    }
}
