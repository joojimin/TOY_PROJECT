package com.my.toyproject.shop.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Member, Long> {

}
