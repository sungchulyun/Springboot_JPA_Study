package org.zerok.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerok.domain.FreeBoard;

import java.awt.print.Pageable;
import java.util.List;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long> {
}
