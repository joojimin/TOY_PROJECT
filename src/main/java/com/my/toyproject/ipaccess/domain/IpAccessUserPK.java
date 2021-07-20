package com.my.toyproject.ipaccess.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class IpAccessUserPK implements Serializable {

    private String ip;
    private String name;

    public IpAccessUserPK(String ip, String name) {
        this.ip = ip;
        this.name = name;
    }
}
