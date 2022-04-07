package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.zerock.entity.Board;
import org.zerock.service.BoardService;

import java.util.List;

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

    @RequestMapping("/detail/{bno}")
    public String detail(Model model,  @PathVariable Long bno){

        Board board = boardservice.find(bno);

        model.addAttribute("board", board);

        return "/detail";
    }

    @RequestMapping("/list/{keyword}")
    public String listSearch(@PathVariable String keyword, Model model){

        List<Board> board = boardservice.search(keyword);

        model.addAttribute("board", board);

        return "";
    }
}
