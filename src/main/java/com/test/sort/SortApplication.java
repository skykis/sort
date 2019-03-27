package com.test.sort;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SortApplication {

    public static void main(String[] args) {
        SpringApplication.run(SortApplication.class, args);
    }

}

