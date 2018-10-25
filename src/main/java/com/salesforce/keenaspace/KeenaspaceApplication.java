package com.salesforce.keenaspace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KeenaspaceApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(KeenaspaceApplication.class, args);
    }
}
