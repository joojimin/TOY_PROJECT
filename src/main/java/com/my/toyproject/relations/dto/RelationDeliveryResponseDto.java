package com.my.toyproject.relations.dto;

import com.my.toyproject.relations.domain.DeliveryTypeCode;
import com.my.toyproject.relations.domain.RelationDelivery;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RelationDeliveryResponseDto {

    private Long id;
    private DeliveryTypeCode typeCode;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;


    private RelationDeliveryResponseDto(Long id,
                                        DeliveryTypeCode typeCode,
                                        LocalDateTime registerTime,
                                        LocalDateTime updateTime) {
        this.id = id;
        this.typeCode = typeCode;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
    }

    public static RelationDeliveryResponseDto convert(final RelationDelivery relationDelivery) {
        return new RelationDeliveryResponseDto(relationDelivery.getId(),
                                               relationDelivery.getTypeCode(),
                                               relationDelivery.getRegisterTime(),
                                               relationDelivery.getUpdateTime());
    }
}
