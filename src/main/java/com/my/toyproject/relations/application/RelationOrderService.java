package com.my.toyproject.relations.application;

import com.my.toyproject.relations.domain.RelationItem;
import com.my.toyproject.relations.domain.RelationUser;
import com.my.toyproject.relations.dto.RelationItemRequestDto;
import com.my.toyproject.relations.dto.RelationItemResponseDto;
import com.my.toyproject.relations.dto.RelationOrderRequestDto;
import com.my.toyproject.relations.dto.RelationUserRequestDto;
import com.my.toyproject.relations.dto.RelationUserResponseDto;
import com.my.toyproject.relations.infrastructure.RelationDeliveryRepository;
import com.my.toyproject.relations.infrastructure.RelationItemRepository;
import com.my.toyproject.relations.infrastructure.RelationOrderItemRepository;
import com.my.toyproject.relations.infrastructure.RelationOrderRepository;
import com.my.toyproject.relations.infrastructure.RelationUserRepository;
import java.util.List;
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
                                   relationItemRequestDto.getPrice()));
        return RelationItemResponseDto.create(relationItem);
    }

    public RelationUserResponseDto createUser(final RelationUserRequestDto relationUserRequestDto) {
        RelationUser relationUser = relationUserRepository.save(RelationUser.newInstance(relationUserRequestDto.getName(),
                                                                                         relationUserRequestDto.getHp(),
                                                                                         relationUserRequestDto.getEmail()));
        return RelationUserResponseDto.create(relationUser);
    }

    public void createOrder(final RelationOrderRequestDto relationOrderRequestDto) {
        RelationUser relationUser = findRelationUser(relationOrderRequestDto);
        List<RelationItem> relationItems = findRelationItems(relationOrderRequestDto);
    }

    private List<RelationItem> findRelationItems(RelationOrderRequestDto relationOrderRequestDto) {
        return relationItemRepository.findByIds(relationOrderRequestDto.getItemIds());
    }

    private RelationUser findRelationUser(RelationOrderRequestDto relationOrderRequestDto) {
        return relationUserRepository.findById(relationOrderRequestDto.getUserId())
                                     .orElseThrow(() -> new IllegalArgumentException());
    }

    @Transactional(readOnly = true)
    public void find() {

    }
}
