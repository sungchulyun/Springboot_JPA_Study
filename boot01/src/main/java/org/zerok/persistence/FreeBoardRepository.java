package org.zerok.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerok.domain.FreeBoard;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long> {
}
