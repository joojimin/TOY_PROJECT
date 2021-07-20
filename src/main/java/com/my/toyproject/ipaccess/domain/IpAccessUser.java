package com.my.toyproject.ipaccess.domain;

import com.my.toyproject.ipaccess.infrastructure.BooleanToIntegerConverter;
import com.my.toyproject.ipaccess.infrastructure.IpAccessTypeToIntegerConverter;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "ip_access_table")
@Entity
public class IpAccessUser {

    @EmbeddedId
    private IpAccessUserPK ipAccessUserPK;

    @Column(name = "hp")
    private String phoneNumber;

    @Convert(converter = BooleanToIntegerConverter.class)
    @Column(nullable = false)
    private Boolean openYN;

    @Convert(converter = IpAccessTypeToIntegerConverter.class)
    @Column(nullable = false)
    private IpAccessType type;

    private LocalDateTime registerTime;
    private LocalDateTime updateTime;

    @Builder
    public IpAccessUser(String ip, String name, String phoneNumber, Boolean openYN,
                        IpAccessType type, LocalDateTime registerTime,
                        LocalDateTime updateTime) {
        this.ipAccessUserPK = ipAccessUserPK;
        this.phoneNumber = phoneNumber;
        this.openYN = openYN;
        this.type = type;
        this.registerTime = registerTime;
        this.updateTime = updateTime;
    }

    public boolean isOpen(){
        return this.openYN;
    }
}
