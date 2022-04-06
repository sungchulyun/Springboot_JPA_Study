package org.zerock.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.zerock.entity.Board;

import java.util.Collection;
import java.util.List;

@Repository
public interface BoardRepository extends CrudRepository<Board, Long> {

    Page<Board> findAll(Pageable page);

}
