package com.my.toyproject.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Profile("dev")
@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean
    public TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(5);	// 기본 스레드 수
        taskExecutor.setMaxPoolSize(10);	// 최대 스레드 수
        taskExecutor.setQueueCapacity(10);  // 대기 큐 사이즈
        taskExecutor.initialize();
        return taskExecutor;
    }

}
