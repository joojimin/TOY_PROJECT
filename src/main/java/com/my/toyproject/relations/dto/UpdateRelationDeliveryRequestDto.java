package com.my.toyproject.relations.dto;

import com.my.toyproject.relations.domain.DeliveryTypeCode;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateRelationDeliveryRequestDto {
    private List<Long> deliveryIds = new ArrayList<>();
    private DeliveryTypeCode deliveryTypeCode;

    public UpdateRelationDeliveryRequestDto(List<Long> deliveryIds,
                                            DeliveryTypeCode deliveryTypeCode) {
        this.deliveryIds = deliveryIds;
        this.deliveryTypeCode = deliveryTypeCode;
    }
}
