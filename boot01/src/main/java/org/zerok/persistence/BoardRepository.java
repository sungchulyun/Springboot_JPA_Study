package org.zerok.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.zerok.domain.Board;

import java.util.Collection;
import java.util.List;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    public List<Board> findBoardByTitle(String title);

    public Collection<Board> findByWriter(String writer);

    public Collection<Board> findByWriterContaining(String writer);

    public Collection<Board> findByTitleContainingOrContentContaining(String title, String content);

    public  Collection<Board> findByTitleContainingAndBnoGreaterThan(String keyword, Long num);

    public Page<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);

    @Query("SELECT b.bno, b.title, b.writer, b.regdate " + " FROM Board b WHERE b.title LIKE %?1% AND b.bno > 0 ORDER BY b.bno DESC")
    public List<Object[]> findByTitle(String title);

    @Query("SELECT b FROM Board b WHERE b.title LIKE %:content% AND b.bno > 0 ORDER BY b.bno DESC")
    public List<Board> findByContent(@Param("content")String content);

    @Query("SELECT b FROM #{#entityName} b WHERE b.writer LIKE %?1% AND b.bno > 0 ORDER BY b.bno DESC")
    public List<Board> findByWriter2(String writer);

}
