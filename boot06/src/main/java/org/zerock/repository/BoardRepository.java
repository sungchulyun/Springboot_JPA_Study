package org.zerock.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zerock.entity.Board;

import java.util.Collection;

@Repository
public interface BoardRepository extends CrudRepository<Board,Long> {

}
