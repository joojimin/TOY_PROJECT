package com.my.toyproject.dblog.domain;

import com.my.toyproject.dblog.application.DataBaseLogType;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;

@Table(name = "database_log_table")
@Entity
public class DataBaseLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DataBaseLogType type;

    @Column(length = 100, nullable = false)
    private String url;

    @Column(length = 200)
    private String request;

    @Column(length = 200)
    private String response;

    @Column(length = 200)
    private String etc;

    @Column(length = 20, nullable = false)
    private String serverIp;

    @Column(nullable = false)
    private int serverPort;

    private LocalDateTime registerTime;


    protected DataBaseLog() {
        // empty
    }

    @Builder
    public DataBaseLog(DataBaseLogType type, String url, String request, String response,
                       String etc, String serverIp, int serverPort,
                       LocalDateTime registerTime) {
        this.type = type;
        this.url = url;
        this.request = request;
        this.response = response;
        this.etc = etc;
        this.serverIp = serverIp;
        this.serverPort = serverPort;
        this.registerTime = registerTime;
    }
}
