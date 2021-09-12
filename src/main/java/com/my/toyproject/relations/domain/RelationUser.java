package com.my.toyproject.relations.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "relation_user")
@Entity
public class RelationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String hp;
    private String email;

    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    @Builder
    public RelationUser(String name, String hp, String email, LocalDateTime registerTime) {
        this.name = name;
        this.hp = hp;
        this.email = email;
        this.registerTime = registerTime;
    }

    public static RelationUser newInstance(String name, String hp, String email) {
        return new RelationUser(name, hp, email, LocalDateTime.now());
    }
}
