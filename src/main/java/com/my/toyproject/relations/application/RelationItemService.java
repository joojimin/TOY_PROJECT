package com.my.toyproject.relations.application;

import com.my.toyproject.relations.domain.RelationItem;
import com.my.toyproject.relations.infrastructure.RelationItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class RelationItemService {

    private final RelationItemRepository relationItemRepository;

    public List<RelationItem> distinct() {
        return relationItemRepository.findDistinctByName("테스트1 아이템");
    }
}
