package com.eakonovalov.spring5jokes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:jokes-configuration.xml")
@SpringBootApplication
public class Spring5jokesApplication {

    public static void main(String[] args) {
        SpringApplication.run(Spring5jokesApplication.class, args);
    }
}
