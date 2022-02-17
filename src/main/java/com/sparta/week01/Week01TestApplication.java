package com.sparta.week01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Week01TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Week01TestApplication.class, args);
    }

}
