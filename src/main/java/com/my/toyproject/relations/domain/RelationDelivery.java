package com.my.toyproject.relations.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "relation_delivery")
@Entity
public class RelationDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private DeliveryTypeCode typeCode;

    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    public RelationDelivery(DeliveryTypeCode typeCode, LocalDateTime registerTime) {
        this.typeCode = typeCode;
        this.registerTime = registerTime;
    }

    public static RelationDelivery initInstance() {
        return new RelationDelivery(DeliveryTypeCode.READY, LocalDateTime.now());
    }

    public void updateTypeCode(final DeliveryTypeCode deliveryTypeCode) {
        this.typeCode = deliveryTypeCode;
    }
}
