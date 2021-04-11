package com.my.toyproject.server.service;

import com.my.toyproject.server.factory.ServerStatusFactory;
import com.my.toyproject.server.mapper.ServerStatusMapper;
import com.my.toyproject.server.vo.ServerStatusVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.UnknownHostException;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class FindServerStatusServiceImpl implements FindServerStatusService{

	private final ServerStatusMapper serverStatusMapper;
	private final ServerStatusFactory serverStatusFactory;

	@PostConstruct
	public void postConstruct() throws UnknownHostException {
		load();
	}

	@Override
	public void load() throws UnknownHostException {
		serverStatusFactory.load(serverStatusMapper.selectAll());
	}

	@Override
	public ServerStatusVo getMyServerStatusVo() {
		return serverStatusFactory.getMyStatus();
	}

	@Override
	public Optional<ServerStatusVo> getServerStatusVo(String ip, int port) {
		return serverStatusFactory.getConnectedApiServerStatus(ip, port);
	}
}
