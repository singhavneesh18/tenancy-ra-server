package com.singh.tenancy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class TenancyRaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TenancyRaServerApplication.class, args);
    }

}
