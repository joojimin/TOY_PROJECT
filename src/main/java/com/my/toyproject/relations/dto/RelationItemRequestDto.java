package com.my.toyproject.relations.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RelationItemRequestDto {

    private String name;
    private Long price;

    public RelationItemRequestDto(String name, Long price) {
        this.name = name;
        this.price = price;
    }
}
