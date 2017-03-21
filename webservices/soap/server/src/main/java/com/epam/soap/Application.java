package com.epam.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.epam.soap.config.AppConfig;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}