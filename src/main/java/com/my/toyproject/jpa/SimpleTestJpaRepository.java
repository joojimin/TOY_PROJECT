package com.my.toyproject.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SimpleTestJpaRepository extends JpaRepository<SimpleTestModel, Long> {

}
