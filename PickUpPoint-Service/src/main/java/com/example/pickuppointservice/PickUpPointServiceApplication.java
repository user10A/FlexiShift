package com.example.pickuppointservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PickUpPointServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PickUpPointServiceApplication.class, args);
    }

}
