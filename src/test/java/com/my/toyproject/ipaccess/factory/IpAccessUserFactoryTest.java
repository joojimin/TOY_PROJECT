package com.my.toyproject.ipaccess.factory;

import com.my.toyproject.ipaccess.application.IpAccessUserFactory;
import com.my.toyproject.ipaccess.domain.IpAccessUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.assertj.core.api.Assertions.assertThat;

class IpAccessUserFactoryTest {

    private IpAccessUserFactory ipAccessUserFactory;

    @BeforeEach
    void setUpInstacne() {
        ipAccessUserFactory = new IpAccessUserFactory();
    }

    @Test
    void loadTest() {
        //given
        List<IpAccessUser> ipAccessUsers = List.of(IpAccessUser.builder().ip("127.0.0.1").openYN(true).build(),
												   IpAccessUser.builder().ip("0.0.0.0").openYN(true).build(),
												   IpAccessUser.builder().ip("1.2.3.4").openYN(false).build());

        // when
        assertDoesNotThrow(() -> ipAccessUserFactory.load(ipAccessUsers));

        // then
        assertThat(ipAccessUserFactory.getIpAccessUserDto("127.0.0.1")).isPresent();
        assertThat(ipAccessUserFactory.getIpAccessUserDto("0.0.0.0")).isPresent();
        assertThat(ipAccessUserFactory.getIpAccessUserDto("1.2.3.4")).isEmpty();
        assertThat(ipAccessUserFactory.getIpAccessUserDto("5.6.7.8")).isEmpty();
    }


}
