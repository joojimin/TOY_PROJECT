package com.my.toyproject.shop.domain;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile("dev")
public interface ShopRepository extends JpaRepository<Member, Long> {

}
