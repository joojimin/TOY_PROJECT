package com.my.toyproject.relations.infrastructure;

import com.my.toyproject.relations.domain.RelationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelationUserRepository extends JpaRepository<RelationUser, Long> {

}
