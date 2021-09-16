package com.my.toyproject.relations.domain;

import java.time.LocalDateTime;
import java.util.StringJoiner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "relation_item")
@Entity
public class RelationItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;

    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    public RelationItem(String name, Long price, LocalDateTime registerTime) {
        this.name = name;
        this.price = price;
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RelationItem.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("name='" + name + "'")
            .add("price=" + price)
            .add("registerTime=" + registerTime)
            .add("updateTime=" + updateTime)
            .toString();
    }
}
