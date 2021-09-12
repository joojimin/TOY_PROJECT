package com.my.toyproject.relations.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RelationUserRequestDto {

    private String name;
    private String hp;
    private String email;

    public RelationUserRequestDto(String name, String hp, String email) {
        this.name = name;
        this.hp = hp;
        this.email = email;
    }
}
