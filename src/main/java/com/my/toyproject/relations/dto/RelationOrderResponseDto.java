package com.my.toyproject.relations.dto;

import com.my.toyproject.relations.domain.RelationOrder;
import com.my.toyproject.relations.domain.RelationOrderItem;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RelationOrderResponseDto {

    private Long id;
    private RelationUserResponseDto user;
    private RelationDeliveryResponseDto delivery;
    private List<RelationItemResponseDto> items;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    private RelationOrderResponseDto(Long id,
                                    RelationUserResponseDto user,
                                    RelationDeliveryResponseDto delivery,
                                    List<RelationItemResponseDto> items,
                                    LocalDateTime registerTime, LocalDateTime updateTime) {
        this.id = id;
        this.user = user;
        this.delivery = delivery;
        this.items = items;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
    }

    public static RelationOrderResponseDto convert(final RelationOrder relationOrder) {
        return new RelationOrderResponseDto(relationOrder.getId(),
                                            RelationUserResponseDto.convert(relationOrder.getUser()),
                                            RelationDeliveryResponseDto.convert(relationOrder.getDelivery()),
                                            convertToRelationItemResponse(relationOrder.getOrderItems()),
                                            relationOrder.getRegisterTime(),
                                            relationOrder.getUpdateTime());
    }

    private static List<RelationItemResponseDto> convertToRelationItemResponse(final List<RelationOrderItem> relationOrderItems) {
        return relationOrderItems.stream()
                                 .map(relationOrderItem -> relationOrderItem.getItem())
                                 .map(RelationItemResponseDto::create)
                                 .collect(Collectors.toList());
    }
}
