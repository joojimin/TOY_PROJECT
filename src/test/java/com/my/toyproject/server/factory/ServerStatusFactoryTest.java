package com.my.toyproject.server.factory;

import com.my.toyproject.server.type.ServerStatusType;
import com.my.toyproject.server.vo.ServerStatusVo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ServerStatusFactoryTest {

	@Autowired
	private Environment environment;

	private ServerStatusFactory serverStatusFactory;

	@BeforeEach
	public void setUp(){
		serverStatusFactory = new ServerStatusFactory(environment);
	}

	@Test
	void myHostAddressTest(){
		String hostAddress = assertDoesNotThrow(() -> InetAddress.getLocalHost().getHostAddress());
		String port = environment.getProperty("server.port");

		System.out.println(hostAddress + ":" + port);
	}

	@Test
	void loadTest() throws UnknownHostException {
		// given
		String myHostAddress = InetAddress.getLocalHost().getHostAddress();
		int port = Integer.parseInt(environment.getProperty("server.port"));

		List<ServerStatusVo> serverStatusVoList = List.of(makeTestObjectOfServerStatusVo("1.2.3.4", 8080),
														  makeTestObjectOfServerStatusVo(myHostAddress, port));

		// when
		assertDoesNotThrow(() -> serverStatusFactory.load(serverStatusVoList));


		// then
		assertThat(serverStatusFactory.getMyStatus()).isNotNull();
		assertThat(serverStatusFactory.getMyStatus().getIp()).isEqualTo(myHostAddress);
		assertThat(serverStatusFactory.getMyStatus().getPort()).isEqualTo(port);
		assertThat(serverStatusFactory.getConnectedApiServerStatus("1.2.3.4", 8080)).isPresent();
		assertThat(serverStatusFactory.getConnectedApiServerStatus("2.3.4.5", 8080)).isEmpty();
	}

	private ServerStatusVo makeTestObjectOfServerStatusVo(String ip, int port){
		return new ServerStatusVo(ip,
								  port,
								  "test",
								  ServerStatusType.PUBLIC,
								  1,
								  null, null,
								  "test", LocalDateTime.now());
	}

}
