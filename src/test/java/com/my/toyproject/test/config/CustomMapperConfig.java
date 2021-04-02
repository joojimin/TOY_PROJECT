package com.my.toyproject.test.config;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@ActiveProfiles("dev")
@SpringBootTest
@Transactional
public class CustomMapperConfig {
}
