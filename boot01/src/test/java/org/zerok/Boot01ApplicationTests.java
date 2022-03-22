package org.zerok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerok.domain.Board;
import org.zerok.persistence.BoardRepository;

import java.util.Collection;

@SpringBootTest
class Boot01ApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	@Test
	void testInsert200() {
		for(int i = 0; i <=200; i++){

			Board board = new Board();
			board.setTitle("제목 : "+i);
			board.setContent("내용...." + i + "채우기 ");
			board.setWriter("user0" + (i % 10));
			boardRepository.save(board);
		}
	}

	@Test
	public void testByTitle() {

		boardRepository.findBoardByTitle("제목..177")
				.forEach(board -> System.out.println(board));
	}

	@Test
	public void testByWriter(){

		Collection<Board> results = boardRepository.findByWriter("user00");

		results.forEach(
				board -> System.out.println(board)
		);
	}

	@Test
	public void testByWriterContaining(){

		Collection<Board> results = boardRepository.findByWriterContaining("05");

		results.forEach(board -> System.out.println(board));
	}

	@Test
	public void testByTitleContainingOrContent(){

		Collection<Board> results = boardRepository.findByTitleContainingOrContentContaining("5", "5");

		results.forEach(board -> System.out.println(board));
	}

	@Test
	public void testByTitleAndBnoGreaterThan(){

		Collection<Board> results = boardRepository.findByTitleContainingAndBnoGreaterThan("5", 100L);
		results.forEach(board -> System.out.println(board));
	}

	@Test
	public void testByBnoGreaterThanOrderByBnoDesc(){

		Collection<Board> results = boardRepository.findByBnoGreaterThanOrderByBnoDesc(100L);
		results.forEach(board -> System.out.println(board));
	}
}
