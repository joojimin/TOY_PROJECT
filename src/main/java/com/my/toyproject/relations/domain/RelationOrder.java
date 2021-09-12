package com.my.toyproject.relations.domain;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "relation_order")
@Entity
public class RelationOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private RelationUser user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private RelationDelivery delivery;

    @OneToMany(mappedBy = "order")
    private List<RelationOrderItem> orderItems;

    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    @Builder
    public RelationOrder(RelationUser user,
                         RelationDelivery delivery,
                         List<RelationOrderItem> orderItems,
                         LocalDateTime registerTime) {
        this.user = user;
        this.delivery = delivery;
        this.orderItems = orderItems;
        this.registerTime = registerTime;
    }

    public static RelationOrder newInstance(RelationUser user,
                                            RelationDelivery delivery,
                                            List<RelationOrderItem> orderItems) {
        return new RelationOrder(user, delivery, orderItems, LocalDateTime.now());
    }
}