package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public String list(Model model, @PageableDefault(page = 0, size = 10, sort = "bno", direction = Sort.Direction.DESC)
                       Pageable pageable, String keyword){

        Page<Board> lists = null;

        if(keyword == null)
            lists = boardservice.list(pageable);

        else
            lists = boardservice.search(keyword, pageable);

       int nowPage = lists.getPageable().getPageNumber();
       int StartPage = Math.max(nowPage -4, 1);
       int EndPage = Math.min(nowPage+5,lists.getTotalPages());

       model.addAttribute("lists", lists);
       model.addAttribute("nowPage", nowPage);
       model.addAttribute("StartPage", StartPage);
       model.addAttribute("EndPage", EndPage);


        return "list";
    }

   @GetMapping("/detail")
    public String detail(Model model, Long bno){

        model.addAttribute("board", boardservice.find(bno));

        return "/detail";
    }

    @PostMapping("/update")
    public String update(Board board){

        boardservice.boardwrite(board);

        return "/update";
    }

    @GetMapping("/delete/{bno}")
    public String Delete(@PathVariable("bno") Long bno){

        boardservice.delete(bno);

        return "redirect:/list";
    }

}
