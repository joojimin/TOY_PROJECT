package com.my.toyproject.server.factory;

import com.my.toyproject.server.vo.ServerStatusVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class ServerStatusFactory {

	private final Environment environment;

	private ServerStatusVo myStatus;
	private Map<String, ServerStatusVo> connectedApiServerMap;


	public void load(final List<ServerStatusVo> serverStatusVoList) throws UnknownHostException {
		Map<String, ServerStatusVo> tempConnectedApiServerMap =
			serverStatusVoList
			.stream()
			.filter(ServerStatusVo::isOpen)
			.collect(Collectors
						 .toUnmodifiableMap(
							 (serverStatusVo -> makeKey(serverStatusVo.getIp(), serverStatusVo.getPort())),
							 Function.identity())
					);

		myStatus = tempConnectedApiServerMap.get(myHostAddress());
		connectedApiServerMap = tempConnectedApiServerMap;
	}

	private String myHostAddress() throws UnknownHostException {
		return makeKey(InetAddress.getLocalHost().getHostAddress(),
					   Integer.parseInt(environment.getProperty("server.port")));
	}

	public ServerStatusVo getMyStatus(){
		return myStatus;
	}

	public Optional<ServerStatusVo> getConnectedApiServerStatus(final String ip, final int port){
		try {
			String key = makeKey(ip, port);
			return Optional.ofNullable(connectedApiServerMap.get(key));
		}catch(IllegalArgumentException ex){
			log.error(ex.getMessage());
			return Optional.empty();
		}
	}

	private String makeKey(final String ip, final int port){
		if(StringUtils.isEmpty(ip)){
			throw new IllegalArgumentException("PARAMETER[IP] IS EMPTY");
		}

		StringBuilder key = new StringBuilder(ip);
		if(false == StringUtils.isEmpty(port)
			&& 0 != port){
			key.append(":").append(port);
		}
		return key.toString();
	}
}
