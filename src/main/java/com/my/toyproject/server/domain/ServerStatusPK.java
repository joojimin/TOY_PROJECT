package com.my.toyproject.server.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Embeddable
public class ServerStatusPK implements Serializable {

    private String ip;
    private int port;

    public ServerStatusPK(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
