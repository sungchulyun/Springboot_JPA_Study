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

    public Page<Board> list(int page){

        return boardrepository.findAll((PageRequest.of(page,10, Sort.Direction.DESC, "bno")));
    }

    public Board find(Long bno){

        return boardrepository.findById(bno).get();
    }

    }