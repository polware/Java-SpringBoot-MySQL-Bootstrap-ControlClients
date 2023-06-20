package com.polware.controlclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.polware.controlclients.repositories")
public class ControlClientsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ControlClientsApplication.class, args);
    }

}
