package com.my.toyproject;

import com.my.toyproject.spring.service.PrintRequestMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
public class ToyProjectApplication {

    private final PrintRequestMappingService printRequestMappingService;

    public static void main(String[] args) {
        SpringApplication.run(ToyProjectApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(){
        return printRequestMappingService.run();
    }
}
