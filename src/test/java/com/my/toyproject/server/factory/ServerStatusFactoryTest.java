package com.my.toyproject.server.factory;

import com.my.toyproject.server.application.ServerStatusFactory;
import com.my.toyproject.server.domain.ServerStatus;
import com.my.toyproject.server.domain.ServerStatusPK;
import com.my.toyproject.server.domain.ServerStatusType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

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
    public void setUp() {
        serverStatusFactory = new ServerStatusFactory(environment);
    }

    @Test
    void myHostAddressTest() {
        String hostAddress = assertDoesNotThrow(() -> InetAddress.getLocalHost().getHostAddress());
        String port = environment.getProperty("server.port");

        System.out.println(hostAddress + ":" + port);
    }

    @Test
    void loadTest() throws UnknownHostException {
        // given
        String myHostAddress = InetAddress.getLocalHost().getHostAddress();
        int port = Integer.parseInt(environment.getProperty("server.port"));

        List<ServerStatus> serverStatusList = List.of(makeTestObjectOfServerStatus("1.2.3.4", 8080),
													  makeTestObjectOfServerStatus(myHostAddress, port));

        // when
        assertDoesNotThrow(() -> serverStatusFactory.load(serverStatusList));

        // then
        assertThat(serverStatusFactory.getMyStatus()).isNotNull();
        assertThat(serverStatusFactory.getMyStatus().getIp()).isEqualTo(myHostAddress);
        assertThat(serverStatusFactory.getMyStatus().getPort()).isEqualTo(port);
        assertThat(serverStatusFactory.getConnectedApiServerStatus("1.2.3.4", 8080)).isPresent();
        assertThat(serverStatusFactory.getConnectedApiServerStatus("2.3.4.5", 8080)).isEmpty();
    }

    private ServerStatus makeTestObjectOfServerStatus(String ip, int port) {
        return ServerStatus.builder()
                           .serverStatusPK(new ServerStatusPK(ip, port))
                           .name("test")
                           .type(ServerStatusType.PUBLIC)
                           .openYN(true)
                           .registerUser("test")
                           .registerTime(LocalDateTime.now())
                           .build();
    }

}
