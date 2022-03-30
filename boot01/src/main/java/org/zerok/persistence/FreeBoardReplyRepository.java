package org.zerok.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerok.domain.FreeBoardReply;

public interface FreeBoardReplyRepository extends CrudRepository<FreeBoardReply, Long> {
}
