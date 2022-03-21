package com.example.springblogproj.controller;

import com.example.springblogproj.entity.Blog;
import com.example.springblogproj.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Controller
public class Blogcontroller {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog/write")
    public String blogwriteform(){

        return "/blogwrite";
    }

    @PostMapping("/blog/writepro")
    public String blogwritepro(Blog blog, Model model){

        blogService.write(blog);

        model.addAttribute("message", "글 작성이 완료되었습니다.");
        model.addAttribute("searchUrl", "/blog/list");

        return "/message";
    }

    @GetMapping("/blog/list")
    public String blogList(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable, String searchKeyword){

        Page<Blog> list = null;

        if(searchKeyword == null){
            list = blogService.blogList(pageable);
        }

        else
            list = blogService.blogSearchList(searchKeyword, pageable);

        int nowPage = list.getPageable().getPageNumber();
        int startPage = Math.max(nowPage - 4, 1);
        int endPage = Math.min(nowPage + 5, list.getTotalPages());

        model.addAttribute("list", list);
        model.addAttribute("nowPage", nowPage);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return "/bloglist";
    }

    @GetMapping("/blog/view")   //localhost:8080/blog/view?id=1
    public String blogview(Model model, Integer id)    {

        model.addAttribute("blog", blogService.blogview(id));

        return "blogview";
    }


    @GetMapping("/blog/delete")
    public String blogDelete(Integer id, Model model){

        blogService.blogdelete(id);
        model.addAttribute("message", "글 삭제가 완료되었습니다.");
        model.addAttribute("searchUrl", "/blog/list");

        return "/message";
    }

    @GetMapping("/blog/modify/{id}")
    public String blogModify(@PathVariable("id") Integer id,
                              Model model) {

        model.addAttribute("blog", blogService.blogview(id));

        return "blogmodify";
    }

    @PostMapping("/blog/update/{id}")
    public String blogUpdate(@PathVariable("id") Integer id, Blog blog) {

        Blog blogTemp = blogService.blogview(id);
        blogTemp.setTitle(blog.getTitle());
        blogTemp.setContent(blog.getContent());

        blogService.write(blogTemp);

        return "redirect:/blog/list";

    }



}

