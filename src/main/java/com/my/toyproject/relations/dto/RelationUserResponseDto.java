package com.my.toyproject.relations.dto;

import com.my.toyproject.relations.domain.RelationUser;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RelationUserResponseDto {

    private Long id;
    private String name;
    private String hp;
    private String email;
    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    private RelationUserResponseDto(Long id, String name, String hp, String email,
                                   LocalDateTime registerTime, LocalDateTime updateTime) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.email = email;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
    }


    public static RelationUserResponseDto convert(final RelationUser relationUser) {
        return new RelationUserResponseDto(relationUser.getId(),
                                           relationUser.getName(),
                                           relationUser.getHp(),
                                           relationUser.getEmail(),
                                           relationUser.getRegisterTime(),
                                           relationUser.getUpdateTime());
    }
}
