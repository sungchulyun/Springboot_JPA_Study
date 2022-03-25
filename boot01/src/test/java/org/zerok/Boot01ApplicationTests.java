package org.zerok;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerok.domain.Board;
import org.zerok.persistence.BoardRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@SpringBootTest
class Boot01ApplicationTests {

	@Autowired
	private BoardRepository boardRepository;

	/*@Test
	void testInsert200() {
		for(int i = 0; i <=200; i++){

			Board board = new Board();
			board.setTitle("제목 : "+i);
			board.setContent("내용...." + i + "채우기 ");
			board.setWriter("user0" + (i % 10));
			boardRepository.save(board);
		}
	}
*/
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
	public void testBnoOrderByPaging(){

		Pageable paging = PageRequest.of(0,10, Sort.Direction.ASC, "bno");

		Page<Board> results = boardRepository.findByBnoGreaterThanOrderByBnoDesc(0L, paging);

		System.out.println("PAGE SIZE : " + results.getSize());
		System.out.println("TOTAL SIZE : " + results.getTotalPages());
		System.out.println("PAGE SIZE : " + results.getTotalElements());
		System.out.println("PAGE SIZE : " + results.nextPageable());

		List<Board> list = results.getContent();

		list.forEach(board -> System.out.println(board));
	}

	@Test
	public void testByTitle2(){

		boardRepository.findByTitle("17")
		.forEach(arr -> System.out.println(Arrays.toString(arr)));
	}

	@Test
	public void testByTitle3(){

		boardRepository.findByContent("17")
				.forEach(board -> System.out.println(board));
	}


	@Test
	public void TestByWriter(){

		boardRepository.findByWriter2("user01").forEach(board -> System.out.println(board));
	}
}