package com.my.toyproject.multitransaction.first.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "name", "phoneNumber", "registerTime", "updateTime"})
@Getter
@Entity
public class FirstMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    @Builder
    private FirstMember(String name, String phoneNumber, LocalDateTime registerTime,
                       LocalDateTime updateTime) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
    }
}
