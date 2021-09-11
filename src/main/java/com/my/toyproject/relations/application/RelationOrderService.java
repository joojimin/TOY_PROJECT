package com.my.toyproject.relations.application;

import com.my.toyproject.relations.infrastructure.RelationDeliveryRepository;
import com.my.toyproject.relations.infrastructure.RelationItemRepository;
import com.my.toyproject.relations.infrastructure.RelationOrderItemRepository;
import com.my.toyproject.relations.infrastructure.RelationOrderRepository;
import com.my.toyproject.relations.infrastructure.RelationUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class RelationOrderService {

    private final RelationOrderRepository relationOrderRepository;
    private final RelationUserRepository relationUserRepository;
    private final RelationDeliveryRepository relationDeliveryRepository;
    private final RelationOrderItemRepository relationOrderItemRepository;
    private final RelationItemRepository relationItemRepository;


    public void create() {

    }

    @Transactional(readOnly = true)
    public void find() {

    }
}
