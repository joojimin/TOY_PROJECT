package com.my.toyproject.server.application;

import com.my.toyproject.server.domain.ServerStatusRepository;
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

	private final ServerStatusRepository serverStatusRepository;
	private final ServerStatusFactory serverStatusFactory;

	@PostConstruct
	public void postConstruct() throws UnknownHostException {
		load();
	}

	@Override
	public void load() throws UnknownHostException {
		serverStatusFactory.load(serverStatusRepository.findAll());
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
