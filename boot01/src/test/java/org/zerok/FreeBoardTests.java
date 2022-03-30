package org.zerok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerok.domain.FreeBoard;
import org.zerok.domain.FreeBoardReply;
import org.zerok.persistence.FreeBoardReplyRepository;
import org.zerok.persistence.FreeBoardRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Commit
public class FreeBoardTests {

    @Autowired
    FreeBoardRepository boardRepo;

    @Autowired
    FreeBoardReplyRepository replyRepo;

    @Test
    public void insertDummy(){

        IntStream.range(1,200).forEach(i ->{

            FreeBoard board = new FreeBoard();
            board.setTitle("Free Board ...." + i);
            board.setContent("Free Content....." + i);
            board.setWriter("user" + i%10);

            boardRepo.save((board));
        });
    }

    @Transactional
    @Test
    public void insertReply2way(){

        Optional<FreeBoard> result = boardRepo.findById(199L);

        result.ifPresent(board -> {
            List<FreeBoardReply> replies = board.getReplies();
            FreeBoardReply reply  = new FreeBoardReply();
            reply.setReply("REPLY.....................");
            reply.setReplyer("reployer00");
            reply.setBoard(board);

            replies.add(reply);

            board.setReplies(replies);

            boardRepo.save(board);
        });
    }
}
