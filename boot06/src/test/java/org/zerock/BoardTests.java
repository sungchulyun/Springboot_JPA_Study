package org.zerock;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.entity.Board;
import org.zerock.repository.BoardRepository;

import javax.persistence.Table;

@SpringBootTest
public class BoardTests {

    @Autowired
    private BoardRepository boardrepository;

    @Test                                       //Dummy 값 삽입
    public void testInsert(){

        Board board = new Board();

        for(int i =1; i<101; i++){

            board.setBno((long) i);
            board.setTitle("제목 " + i);
            board.setContent("내용" + i);
            boardrepository.save(board);
        }
    }
}
