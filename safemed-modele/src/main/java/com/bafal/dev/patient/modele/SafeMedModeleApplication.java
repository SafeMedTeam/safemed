package com.bafal.dev.patient.modele;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class SafeMedModeleApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder().web(false).sources(SafeMedModeleApplication.class).run(args);
    }
}
