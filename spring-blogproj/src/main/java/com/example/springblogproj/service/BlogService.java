package com.example.springblogproj.service;

import com.example.springblogproj.entity.Blog;
import com.example.springblogproj.entity.Member;
import com.example.springblogproj.repository.BlogRepository;
import com.example.springblogproj.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;
    private MemberRepository memberRepository;

    //게시판 글 작성
    public void write(Blog blog, MultipartFile file)throws Exception{

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        File saveFile = new File(projectPath, fileName);

        file.transferTo(saveFile);

        blog.setFilename(fileName);

        blog.setFilepath("/files/" + fileName);

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

    public void memberSignup(Member member){

        memberRepository.save(member);
    }


}
