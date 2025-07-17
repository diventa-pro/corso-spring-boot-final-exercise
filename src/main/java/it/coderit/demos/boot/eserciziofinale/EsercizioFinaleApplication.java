package it.coderit.demos.boot.eserciziofinale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class EsercizioFinaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsercizioFinaleApplication.class, args);
    }
}
