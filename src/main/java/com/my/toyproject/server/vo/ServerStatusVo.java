package com.my.toyproject.server.vo;

import com.my.toyproject.server.domain.ServerStatusType;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class ServerStatusVo {

	private final String ip;
	private final int port;
	private final String name;
	private final ServerStatusType type;
	private final boolean openYn;
	private final String updateUser;
	private final LocalDateTime updateTime;
	private final String registerUser;
	private final LocalDateTime registerTime;

	@Builder
	public ServerStatusVo(String ip, int port, String name,
						  ServerStatusType type, boolean openYn, String updateUser,
						  LocalDateTime updateTime, String registerUser,
						  LocalDateTime registerTime) {
		this.ip = ip;
		this.port = port;
		this.name = name;
		this.type = type;
		this.openYn = openYn;
		this.updateUser = updateUser;
		this.updateTime = updateTime;
		this.registerUser = registerUser;
		this.registerTime = registerTime;
	}
}
