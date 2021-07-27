package com.my.toyproject.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class SimpleTestModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String msg;

    @Builder
    public SimpleTestModel(final Long id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public void updateMsg(final String msg) {
        this.msg = msg;
    }
}
