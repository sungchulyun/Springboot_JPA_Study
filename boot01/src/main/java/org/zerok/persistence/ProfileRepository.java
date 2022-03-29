package org.zerok.persistence;

import org.springframework.data.repository.CrudRepository;
import org.zerok.domain.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
