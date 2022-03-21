package com.example.springblogproj.service;

import com.example.springblogproj.entity.Blog;
import com.example.springblogproj.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    //게시판 글 작성
    public void write(Blog blog){

        blogRepository.save(blog);
    }

    //게시물 리스트 띄우기
    public Page<Blog> blogList(Pageable pageable){

        return blogRepository.findAll(pageable);
    }

    public Page<Blog> blogSearchList(String searchKeyword, Pageable pageable){

        return blogRepository.findByTitleContaining(searchKeyword,pageable);
    }


    //게시물 상세보기
    public Blog blogview(Integer id){

        return blogRepository.findById(id).get();
    }

    public void blogdelete(Integer id)  {

        blogRepository.deleteById(id);

    }


}
