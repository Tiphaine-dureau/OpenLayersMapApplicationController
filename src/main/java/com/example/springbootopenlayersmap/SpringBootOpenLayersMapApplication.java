package com.example.springbootopenlayersmap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootOpenLayersMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootOpenLayersMapApplication.class, args);
    }

    // Création d'un RestTemplate
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
