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
    public void testRead(){

        boardRepo.findById(2L).ifPresent((board) ->{
            System.out.println(board);
        });
    }

    @Test
    public void testUpdate(){

        System.out.println(("Read First .........................."));
        Board board = boardRepo.findById(1L).get();

        System.out.println("Update Title...........................");
        board.setTitle("수정된 제목입니다.");

        System.out.println("Call save( )............................");
        boardRepo.save(board);

    }

    @Test
    public void testDelete(){

        System.out.println("Delete( )...............................");
        boardRepo.deleteById(1L);
    }


    }
