package com.my.toyproject.multitransaction.first.repository;

import com.my.toyproject.multitransaction.first.domain.FirstMember;
import org.springframework.data.repository.CrudRepository;

public interface FirstMemberRepository extends CrudRepository<FirstMember, Long> {

}
