package org.zerok.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.zerok.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
}
