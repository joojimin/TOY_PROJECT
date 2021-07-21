package com.my.toyproject.shop.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member_table")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "member_name", nullable = false)
    private String name;

    @Column(name = "member_address", nullable = false)
    private String address;

    private MemberBelongsType memberBelongs;

    @Column(nullable = false)
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;
}
