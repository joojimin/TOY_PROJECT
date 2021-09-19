package com.my.toyproject.relations.application;

import com.my.toyproject.relations.domain.RelationDelivery;
import com.my.toyproject.relations.domain.RelationItem;
import com.my.toyproject.relations.domain.RelationOrder;
import com.my.toyproject.relations.domain.RelationOrderItem;
import com.my.toyproject.relations.domain.RelationUser;
import com.my.toyproject.relations.dto.RelationItemRequestDto;
import com.my.toyproject.relations.dto.RelationItemResponseDto;
import com.my.toyproject.relations.dto.RelationOrderRequestDto;
import com.my.toyproject.relations.dto.RelationOrderResponseDto;
import com.my.toyproject.relations.dto.RelationUserRequestDto;
import com.my.toyproject.relations.dto.RelationUserResponseDto;
import com.my.toyproject.relations.infrastructure.RelationDeliveryRepository;
import com.my.toyproject.relations.infrastructure.RelationItemRepository;
import com.my.toyproject.relations.infrastructure.RelationOrderItemRepository;
import com.my.toyproject.relations.infrastructure.RelationOrderRepository;
import com.my.toyproject.relations.infrastructure.RelationUserRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
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

    public RelationItemResponseDto createItem(final RelationItemRequestDto relationItemRequestDto) {
        RelationItem relationItem = relationItemRepository
            .save(new RelationItem(relationItemRequestDto.getName(),
                                   relationItemRequestDto.getPrice(),
                                   LocalDateTime.now()));
        return RelationItemResponseDto.create(relationItem);
    }

    public RelationUserResponseDto createUser(final RelationUserRequestDto relationUserRequestDto) {
        RelationUser relationUser = relationUserRepository
            .save(RelationUser.newInstance(relationUserRequestDto.getName(),
                                           relationUserRequestDto.getHp(),
                                           relationUserRequestDto.getEmail()));
        return RelationUserResponseDto.convert(relationUser);
    }

    public RelationOrderResponseDto createOrder(final RelationOrderRequestDto relationOrderRequestDto) {
        RelationUser relationUser = findRelationUser(relationOrderRequestDto);
        List<RelationItem> relationItems = findRelationItems(relationOrderRequestDto);

        // 딜리버리 생성
        RelationDelivery relationDelivery = relationDeliveryRepository
            .save(RelationDelivery.initInstance());

        // Order 생성
        RelationOrder relationOrder = relationOrderRepository
            .save(RelationOrder.newInstance(relationUser, relationDelivery));

        // OrderItem 생성
        List<RelationOrderItem> relationOrderItems = relationOrderItemRepository.saveAll(createRelationOrderItem(relationItems, relationOrder));

        // Order에 Setting후 반환
        relationOrder.setOrderItems(relationOrderItems);
        return RelationOrderResponseDto.convert(relationOrder);
    }

    private List<RelationOrderItem> createRelationOrderItem(List<RelationItem> relationItems,
                                                            RelationOrder relationOrder) {
        return relationItems.stream()
                            .map(relationItem -> new RelationOrderItem(relationOrder, relationItem))
                            .collect(Collectors.toList());
    }

    private List<RelationItem> findRelationItems(RelationOrderRequestDto relationOrderRequestDto) {
        List<RelationItem> relationItems = relationItemRepository
            .findByIdIn(relationOrderRequestDto.getItemIds());
        if (relationItems.size() != relationOrderRequestDto.getItemIds().size()) {
            throw new IllegalArgumentException("오류");
        }
        return relationItems;
    }

    private RelationUser findRelationUser(RelationOrderRequestDto relationOrderRequestDto) {
        return relationUserRepository.findById(relationOrderRequestDto.getUserId())
                                     .orElseThrow(() -> new IllegalArgumentException());
    }

    @Transactional(readOnly = true)
    public void find() {

    }
}
