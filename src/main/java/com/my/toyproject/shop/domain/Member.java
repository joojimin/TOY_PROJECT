package com.my.toyproject.shop.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member_table")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(name = "member_name", nullable = false)
    private String name;

    @Setter
    @Column(name = "member_address", nullable = false)
    private String address;

    private MemberBelongsType memberBelongs;

    @Column(nullable = false)
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    @Builder
    public Member(String name, String address,
                  MemberBelongsType memberBelongs, LocalDateTime registerTime,
                  LocalDateTime updateTime) {
        this.name = name;
        this.address = address;
        this.memberBelongs = memberBelongs;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
    }
}
