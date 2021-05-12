package com.my.toyproject.shop.dto;

import com.my.toyproject.shop.type.MemberBelongs;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@ToString(of = {"memberId", "memberName", "memberAddress", "memberBelongs"})
public class MemberDto {
    private int memberId;
    private String memberName;
    private MemberBelongs memberBelongs;
    private String memberAddress;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;
}
