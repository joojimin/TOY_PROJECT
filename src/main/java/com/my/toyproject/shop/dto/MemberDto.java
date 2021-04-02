package com.my.toyproject.shop.dto;

import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@ToString(of = {"memberId", "memberName", "memberAddress"})
public class MemberDto {
    private int memberId;
    private String memberName;
    private String memberAddress;
}
