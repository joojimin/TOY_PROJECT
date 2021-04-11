package com.my.toyproject.server.service;

import com.my.toyproject.server.vo.ServerStatusVo;

import java.util.Optional;

public interface FindServerStatusService {
	void load() throws Exception;
	ServerStatusVo getMyServerStatusVo();
	Optional<ServerStatusVo> getServerStatusVo(final String ip, final int port);
}
