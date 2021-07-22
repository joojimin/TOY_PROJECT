package com.my.toyproject.shop.dto;

import com.my.toyproject.shop.domain.Member;
import com.my.toyproject.shop.domain.MemberBelongsType;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"memberId", "memberName", "memberAddress", "memberBelongsType"})
public class MemberDto {
    private Long memberId;
    private String memberName;
    private MemberBelongsType memberBelongsType;
    private String memberAddress;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    @Builder
    private MemberDto(Long memberId, String memberName,
                     MemberBelongsType memberBelongsType, String memberAddress,
                     LocalDateTime registerTime, LocalDateTime updateTime) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memberBelongsType = memberBelongsType;
        this.memberAddress = memberAddress;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
    }

    public static MemberDto createMemberDto(final Member member) {
        return MemberDto.builder()
                        .memberId(member.getMemberId())
                        .memberName(member.getName())
                        .memberBelongsType(member.getMemberBelongs())
                        .memberAddress(member.getAddress())
                        .registerTime(member.getRegisterTime())
                        .updateTime(member.getUpdateTime())
                        .build();
    }
}
