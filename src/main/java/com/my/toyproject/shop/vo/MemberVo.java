package com.my.toyproject.shop.vo;

import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@ToString(of = {"memberId", "memberName", "memberAddress"})
public class MemberVo {
    private int memberId;
    private String memberName;
    private String memberAddress;
}
