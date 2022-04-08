package org.zerock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.entity.Board;
import org.zerock.repository.BoardRepository;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardrepository;

    public void boardwrite(Board board){

        boardrepository.save(board);
    }


    public Page<Board> list(Pageable pageable){

        return boardrepository.findAll(pageable);
    }


    public Board find(Long bno){

        return boardrepository.findById(bno).get();
    }

    public Page<Board> search(String keyword, Pageable pageable){

        return boardrepository.findByTitleContaining(keyword,pageable);
    }

    public void delete(Long bno){

        boardrepository.deleteById(bno);
    }

    }