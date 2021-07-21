package com.my.toyproject.server.domain;

import com.my.toyproject.common.BooleanToIntegerConverter;
import com.my.toyproject.server.infrastructure.ServerStatusTypeToIntegerConverter;
import com.my.toyproject.server.vo.ServerStatusVo;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "server_status_table")
@Entity
public class ServerStatus {

    @EmbeddedId
    private ServerStatusPK serverStatusPK;

    @Column(nullable = false)
    private String name;

    @Convert(converter = ServerStatusTypeToIntegerConverter.class)
    @Column(nullable = false)
    private ServerStatusType type;

    @Convert(converter = BooleanToIntegerConverter.class)
    @Column(nullable = false)
    private Boolean openYN;

    @Column(nullable = false)
    private String registerUser;

    @Column(nullable = false)
    private LocalDateTime registerTime;

    private String updateUser;
    private LocalDateTime updateTime;

    @Builder
    public ServerStatus(ServerStatusPK serverStatusPK, String name,
                        ServerStatusType type, Boolean openYN, String registerUser,
                        LocalDateTime registerTime, String updateUser,
                        LocalDateTime updateTime) {
        this.serverStatusPK = serverStatusPK;
        this.name = name;
        this.type = type;
        this.openYN = openYN;
        this.registerUser = registerUser;
        this.registerTime = registerTime;
        this.updateUser = updateUser;
        this.updateTime = updateTime;
    }

    public boolean isOpen(){
        return openYN;
    }

    public ServerStatusVo toServerStatusVO() {
        return ServerStatusVo.builder()
                             .ip(this.serverStatusPK.getIp())
                             .port(this.serverStatusPK.getPort())
                             .name(this.name)
                             .type(this.type)
                             .openYn(this.openYN)
                             .registerUser(this.registerUser)
                             .registerTime(this.registerTime)
                             .updateUser(this.updateUser)
                             .updateTime(this.updateTime)
                             .build();
    }
}
