package com.my.toyproject.shop.dto;

import com.my.toyproject.shop.domain.MemberBelongsType;
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
    private MemberBelongsType memberBelongsType;
    private String memberAddress;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;
}
