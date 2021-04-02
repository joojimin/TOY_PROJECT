package com.my.toyproject;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Slf4j
@ActiveProfiles("dev")
@SpringBootTest
public class ApplicationTest {

	@Test
	public void startUp(){
		log.debug("###############################################");
		log.debug("###############################################");
		log.debug("############### TOY PROJECT TEST ##############");
		log.debug("################## START UP ###################");
		log.debug("###############################################");
		log.debug("###############################################");
	}
}
