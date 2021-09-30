package com.my.toyproject.multitransaction;

import com.my.toyproject.multitransaction.first.domain.FirstMember;
import com.my.toyproject.multitransaction.first.repository.FirstMemberRepository;
import com.my.toyproject.multitransaction.second.domain.SecondMember;
import com.my.toyproject.multitransaction.second.repository.SecondMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MultiTransactionService {

    private final FirstMemberRepository firstMemberRepository;
    private final SecondMemberRepository secondMemberRepository;

    @Transactional
    public void save() {
//        firstMemberRepository.save(FirstMember.builder()
//                                              .name("주지민")
//                                              .phoneNumber("010-0000-0000")
//                                              .build());
//
//        firstMemberRepository.save(FirstMember.builder()
//                                              .name("주지민12344")
//                                              .phoneNumber("010-0000-0000")
//                                              .build());

        secondMemberRepository.save(SecondMember.builder()
                                                .name("조경현")
                                                .address("서울")
                                                .description("개발자")
                                                .build());

        throw new RuntimeException("오류오류");
    }
}
