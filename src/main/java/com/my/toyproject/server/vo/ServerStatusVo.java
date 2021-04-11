package com.my.toyproject.server.vo;

import com.my.toyproject.server.type.ServerStatusType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class ServerStatusVo {

	private final String ip;
	private final int port;
	private final String name;
	private final ServerStatusType type;
	private final int openYn;
	private final String updateUser;
	private final LocalDateTime updateTime;
	private final String registerUser;
	private final LocalDateTime registerTime;

	public boolean isOpen(){
		return openYn == 1;
	}
}
