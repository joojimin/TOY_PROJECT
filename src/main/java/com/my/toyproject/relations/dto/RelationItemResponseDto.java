package com.my.toyproject.relations.dto;

import com.my.toyproject.relations.domain.RelationItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RelationItemResponseDto {

    private Long id;
    private String name;
    private Long price;

    private RelationItemResponseDto(Long id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public static RelationItemResponseDto create(final RelationItem relationItem) {
        return new RelationItemResponseDto(relationItem.getId(),
                                           relationItem.getName(),
                                           relationItem.getPrice());
    }

}
