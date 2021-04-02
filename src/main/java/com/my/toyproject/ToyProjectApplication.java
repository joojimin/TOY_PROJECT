package com.my.toyproject;

import com.my.toyproject.printrequest.service.PrintRequestMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@RequiredArgsConstructor
@SpringBootApplication
@ServletComponentScan(basePackages = "com.my.toyproject.spring")
public class ToyProjectApplication {

    private final PrintRequestMappingService printRequestMappingService;

    public static void main(String[] args) {
        SpringApplication.run(ToyProjectApplication.class, args);
    }

    /**
     * Print request mapping method
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(){
        return printRequestMappingService.run();
    }
}
