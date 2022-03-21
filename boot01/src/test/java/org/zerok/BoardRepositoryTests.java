package org.zerok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerok.domain.Board;
import org.zerok.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepo;

    @Test
    public void testInsert(){

        Board board = new Board();
        board.setTitle("게시물의 제목");
        board.setContent("게시물의 내용 넣기 .....");
        board.setWriter("user00");

        boardRepo.save(board);

    }

    }
