package com.my.toyproject.relations.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RelationOrderRequestDto {

    private Long userId;
    private List<Long> itemIds;

    public RelationOrderRequestDto(Long userId, List<Long> itemIds) {
        this.userId = userId;
        this.itemIds = itemIds;
    }
}
